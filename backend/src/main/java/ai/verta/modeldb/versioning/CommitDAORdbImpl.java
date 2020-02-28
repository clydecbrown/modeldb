package ai.verta.modeldb.versioning;

import static ai.verta.modeldb.versioning.DatasetComponentDAORdbImpl.TREE;

import ai.verta.modeldb.App;
import ai.verta.modeldb.ModelDBException;
import ai.verta.modeldb.entities.versioning.CommitEntity;
import ai.verta.modeldb.entities.versioning.InternalFolderElementEntity;
import ai.verta.modeldb.entities.versioning.RepositoryEntity;
import ai.verta.modeldb.utils.ModelDBHibernateUtil;
import ai.verta.modeldb.versioning.CreateCommitRequest.Response;
import ai.verta.modeldb.versioning.Folder.Builder;
import com.google.protobuf.ProtocolStringList;
import io.grpc.Status.Code;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.persistence.Query;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;

public class CommitDAORdbImpl implements CommitDAO {

  private static final Logger LOGGER = LogManager.getLogger(CommitDAORdbImpl.class);
  public static final String CANT_FIND_FOLDER = "Can't find folder";

  /**
   * commit : details of the commit and the blobs to be added setBlobs : recursively creates trees
   * and blobs in top down fashion and generates SHAs in bottom up fashion getRepository : fetches
   * the repository the commit is made on
   */
  public Response setCommit(Commit commit, BlobFunction setBlobs, RepositoryFunction getRepository)
      throws ModelDBException, NoSuchAlgorithmException {
    try (Session session = ModelDBHibernateUtil.getSessionFactory().openSession()) {
      session.beginTransaction();
      final String rootSha = setBlobs.apply(session);
      long timeCreated = new Date().getTime();
      if (App.getInstance().getStoreClientCreationTimestamp() && commit.getDateCreated() != 0L) {
        timeCreated = commit.getDateCreated();
      }
      final String commitSha = generateCommitSHA(rootSha, commit, timeCreated);
      Commit internalCommit =
          Commit.newBuilder()
              .setDateCreated(timeCreated)
              .setAuthor(commit.getAuthor())
              .setMessage(commit.getMessage())
              .setCommitSha(commitSha)
              .build();
      CommitEntity commitEntity =
          new CommitEntity(
              getRepository.apply(session),
              getCommits(session, commit.getParentShasList()),
              internalCommit, rootSha);
      session.saveOrUpdate(commitEntity);
      session.getTransaction().commit();
      return Response.newBuilder().setCommit(commitEntity.toCommitProto()).build();
    }
  }

  @Override
  public ListCommitsRequest.Response listCommits(
      ListCommitsRequest request, RepositoryFunction getRepository) throws ModelDBException {
    try (Session session = ModelDBHibernateUtil.getSessionFactory().openSession()) {
      Stream<CommitEntity> stream;
      int pageLimit = request.getPagination().getPageLimit();
      RepositoryEntity repository = getRepository.apply(session);
      Set<CommitEntity> commits = repository.getCommits();
      stream = commits.stream();
      final int startPosition = (request.getPagination().getPageNumber() - 1) * pageLimit;
      if (request.getCommitBase().isEmpty() && request.getCommitHead().isEmpty()) {
        stream = stream.filter(c -> c.getChild_commits().isEmpty());
      } else {
        Predicate<CommitEntity> predicateBase =
            commitEntity -> commitEntity.getCommit_hash().equals(request.getCommitBase());
        Predicate<CommitEntity> predicateHead =
            commitEntity -> commitEntity.getCommit_hash().equals(request.getCommitHead());
        Stream<Set<CommitEntity>> filteredStream;
        if (request.getCommitHead().isEmpty()) {
          filteredStream =
              stream
                  .map(c -> c.getParent_commits().stream().filter(predicateBase))
                  .map(s -> s.collect(Collectors.toSet()));
        } else if (request.getCommitBase().isEmpty()) {
          filteredStream =
              stream
                  .map(c -> c.getChild_commits().stream().filter(predicateHead))
                  .map(s -> s.collect(Collectors.toSet()));
        } else {
          Stream<Set<CommitEntity>> resStr1 =
              stream
                  .map(c -> c.getParent_commits().stream().filter(predicateBase))
                  .map(s -> s.collect(Collectors.toSet()));
          Stream<Set<CommitEntity>> resStr2 =
              stream
                  .map(c -> c.getChild_commits().stream().filter(predicateHead))
                  .map(s -> s.collect(Collectors.toSet()));
          HashSet<Set<CommitEntity>> result = new HashSet<>();
          result.addAll(resStr1.collect(Collectors.toSet()));
          result.addAll(resStr2.collect(Collectors.toSet()));
          filteredStream = result.stream();
        }
        stream =
            filteredStream
                .reduce(
                    (l1, l2) -> {
                      HashSet<CommitEntity> set = new HashSet<>();
                      set.addAll(l1);
                      set.addAll(l2);
                      return set;
                    })
                .orElse(new HashSet<>()).stream();
      }
      stream = stream.sorted((c1, c2) -> c2.getDate_created().compareTo(c1.getDate_created()));
      if (request.hasPagination()) {
        stream = stream.skip(startPosition).limit(pageLimit);
      }
      return ListCommitsRequest.Response.newBuilder()
          .addAllCommits(stream.map(CommitEntity::toCommitProto).collect(Collectors.toList()))
          .build();
    }
  }

  private String generateCommitSHA(String blobSHA, Commit commit, long timeCreated)
      throws NoSuchAlgorithmException {

    StringBuilder sb = new StringBuilder();
    if (!commit.getParentShasList().isEmpty()) {
      List<String> parentSHAs = commit.getParentShasList();
      parentSHAs = parentSHAs.stream().sorted().collect(Collectors.toList());
      sb.append("parent:");
      parentSHAs.forEach(pSHA -> sb.append(pSHA));
    }
    sb.append(":message:")
        .append(commit.getMessage())
        .append(":date_created:")
        .append(timeCreated)
        .append(":author:")
        .append(commit.getAuthor())
        .append(":rootHash:")
        .append(blobSHA);

    return FileHasher.getSha(sb.toString());
  }

  private List<CommitEntity> getCommits(Session session, ProtocolStringList parentShasList)
      throws ModelDBException {
    List<CommitEntity> result =
        parentShasList.stream()
            .map(sha -> session.get(CommitEntity.class, sha))
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    if (result.size() != parentShasList.size()) {
      throw new ModelDBException("Cannot find parent commits", Code.INVALID_ARGUMENT);
    }
    return result;
  }

  private boolean commitRepositoryMappingExists(
      Session session, String commitHash, Long repositoryId) {
    String queryString =
        "SELECT count(*) FROM repository_commit rc WHERE rc.commit_hash = :commitHash AND rc.repository_id = :repoId";
    Query query = session.createQuery(queryString);
    query.setParameter("commitHash", commitHash);
    query.setParameter("repoId", repositoryId);
    Long count = (Long) query.getSingleResult();
    return count > 0;
  }

  @Override
  public Commit getCommit(String commitHash, RepositoryFunction getRepository)
      throws ModelDBException {
    try (Session session = ModelDBHibernateUtil.getSessionFactory().openSession()) {
      session.beginTransaction();
      RepositoryEntity repositoryEntity = getRepository.apply(session);
      boolean exists = commitRepositoryMappingExists(session, commitHash, repositoryEntity.getId());
      if (!exists) {
        throw new ModelDBException(
            "Commit_hash and repository_id mapping not found", Code.NOT_FOUND);
      }

      CommitEntity commitEntity = session.load(CommitEntity.class, commitHash);
      session.getTransaction().commit();
      return commitEntity.toCommitProto();
    }
  }

  @Override
  public GetCommitBlobRequest.Response getCommitBlob(GetCommitBlobRequest request) {
    return null;
  }

  @Override
  public GetCommitFolderRequest.Response getCommitFolder(
      GetCommitFolderRequest request, ProtocolStringList locationList) throws ModelDBException {
    try (Session session = ModelDBHibernateUtil.getSessionFactory().openSession()) {
      session.beginTransaction();
      final String simpleName = InternalFolderElementEntity.class.getSimpleName();
      try {

        CommitEntity commit = session.get(CommitEntity.class, request.getCommitSha());
        if (commit == null) {
          throw new ModelDBException("No such commit", Code.NOT_FOUND);
        }
        String foundFolderSha =
            findChildFolder(session, commit.getRootSha(), locationList);

        Optional result =
            session
                .createQuery("From " + simpleName + " where folder_hash = '" + foundFolderSha + "'")
                .list().stream()
                .map(
                    d -> {
                      InternalFolderElementEntity entity = (InternalFolderElementEntity) d;
                      Builder folder = Folder.newBuilder();
                      FolderElement.Builder folderElement =
                          FolderElement.newBuilder()
                              .setElementName(entity.getElement_name())
                              .setCreatedByCommit(request.getCommitSha());

                      if (entity.getElement_type().equals(TREE)) {
                        folder.addSubFolders(folderElement);
                      } else {
                        folder.addBlobs(folderElement);
                      }
                      return folder.build();
                    })
                .reduce((a, b) -> ((Folder) a).toBuilder().mergeFrom((Folder) b).build());

        session.getTransaction().commit();
        final Folder value =
            (Folder)
                result.orElseThrow(
                    () -> new ModelDBException(CANT_FIND_FOLDER, Code.NOT_FOUND));
        return GetCommitFolderRequest.Response.newBuilder().setFolder(value).build();
      } catch (Throwable throwable) {
        if (throwable instanceof ModelDBException) {
          throw (ModelDBException) throwable;
        }
        throw new ModelDBException("Unknown error", Code.INTERNAL);
      }
    }
  }

  private String findChildFolder(
      Session session, String rootSha, List<String> path) throws Throwable {
    if (path.size() == 0) {
      return rootSha;
    }
    InternalFolderElementEntity nextFolder =
        (InternalFolderElementEntity)
            session
                .createQuery(
                    "From "
                        + InternalFolderElementEntity.class.getSimpleName()
                        + " where folder_hash = '"
                        + rootSha
                        + "' and element_name = '"
                        + path.get(0)
                        + "'")
                .uniqueResultOptional()
                .orElseThrow(() -> new ModelDBException(CANT_FIND_FOLDER, Code.NOT_FOUND));
    return findChildFolder(session, nextFolder.getElement_sha(), path.subList(1, path.size()));
  }
}

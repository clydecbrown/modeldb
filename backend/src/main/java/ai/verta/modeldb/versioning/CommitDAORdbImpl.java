package ai.verta.modeldb.versioning;

import static ai.verta.modeldb.versioning.DatasetComponentDAORdbImpl.TREE;

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
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class CommitDAORdbImpl implements CommitDAO {
  private static final Logger LOGGER = LogManager.getLogger(CommitDAORdbImpl.class);

  public Response setCommit(Commit commit, BlobFunction setBlobs, RepositoryFunction getRepository)
      throws ModelDBException, NoSuchAlgorithmException {
    try (Session session = ModelDBHibernateUtil.getSessionFactory().openSession()) {
      session.beginTransaction();
      Commit internalCommit =
          Commit.newBuilder()
              .setDateCreated(new Date().getTime())
              .setAuthor(commit.getAuthor())
              .setMessage(commit.getAuthor())
              .setFolderSha(setBlobs.apply(session))
              .build();
      CommitEntity commitEntity =
          new CommitEntity(
              getRepository.apply(session),
              getCommits(session, commit.getParentShasList()),
              internalCommit);
      session.saveOrUpdate(commitEntity);
      session.getTransaction().commit();
      return Response.newBuilder().setCommit(commitEntity.toCommitProto()).build();
    }
  }

  @Override
  public ListCommitsRequest.Response listCommits(ListCommitsRequest request) {
    try (Session session = ModelDBHibernateUtil.getSessionFactory().openSession()) {
      Stream<CommitEntity> stream;
      int pageLimit = request.getPagination().getPageLimit();
      final int startPosition = (request.getPagination().getPageNumber() - 1) * pageLimit;
      if (request.getCommitBase().isEmpty() && request.getCommitHead().isEmpty()) {
        Query<CommitEntity> query =
            session.createQuery("From " + CommitEntity.class.getSimpleName());
        final List<CommitEntity> list = query.list();
        stream = list.stream().filter(c -> c.getChild_commits().isEmpty());
        if (request.hasPagination()) {
          stream = stream
              .skip(startPosition)
              .limit(pageLimit);
        }
      } else {
        Query<CommitEntity> query;
        if (request.getCommitBase().isEmpty()) {
          query =
              session.createQuery(
                  "From CommitEntity c where c.commit_parent.child_hash = :childHash");
          query.setParameter("childHash", request.getCommitBase());
        } else if (request.getCommitHead().isEmpty()) {
          query =
              session.createQuery(
                  "From CommitEntity c where c.commit_parent.parent_hash = :parentHash");
          query.setParameter("parentHash", request.getCommitHead());
        } else {
          query =
              session.createQuery(
                  "From CommitEntity c WHERE c.commit_parent.child_hash = :childHash AND c.commit_parent.parent_hash = :parentHash");
          query.setParameter("childHash", request.getCommitBase());
          query.setParameter("parentHash", request.getCommitHead());
        }
        LOGGER.debug("Final query : {}", query.getQueryString());
        if (request.hasPagination()) {
          query.setFirstResult(startPosition);
          query.setMaxResults(pageLimit);
        }
        stream = query.list().stream();
      }
      return ListCommitsRequest.Response.newBuilder()
          .addAllCommits(stream.map(CommitEntity::toCommitProto).collect(Collectors.toList()))
          .build();
    }
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
  public GetCommitFolderRequest.Response getCommitFolder(GetCommitFolderRequest request,
      String[] split) throws ModelDBException {
    try (Session session = ModelDBHibernateUtil.getSessionFactory().openSession()) {
      session.beginTransaction();
      final String simpleName = InternalFolderElementEntity.class.getSimpleName();
      try {
      InternalFolderElementEntity rootFolder = (InternalFolderElementEntity) session.createQuery(
          "From " + simpleName + " where element_sha = '"
              + request.getCommitSha() +"' and element_name = '" + split[0] + "'").uniqueResultOptional().orElseThrow(() -> new ModelDBException("No such path", Code.INVALID_ARGUMENT));

      String foundFolderSha = findChildFolder(session, rootFolder, Arrays.asList(
          split).subList(1, split.length));

      Optional result = session.createQuery(
          "From " + simpleName + " where folder_hash = '"
              + foundFolderSha + "'").list().stream().map(d -> {
        InternalFolderElementEntity entity = (InternalFolderElementEntity) d;
        Builder folder = Folder.newBuilder();
        FolderElement.Builder folderElement = FolderElement.newBuilder()
            .setElementName(entity.getElement_name()).setCreatedByCommit(request.getCommitSha());

        if (entity.getElement_type().equals(TREE)) {
          folder.addSubFolders(folderElement);
        } else {
          folder.addBlobs(folderElement);
        }
        return folder.build();
      }).reduce((a, b) -> ((Folder) a).toBuilder().mergeFrom((Folder) b).build());

      session.getTransaction().commit();
        final Folder value = (Folder) result .orElseThrow(() -> new ModelDBException("Can't find folder", Code.INVALID_ARGUMENT));
        return GetCommitFolderRequest.Response.newBuilder().setFolder(value)
            .build();
      } catch (Throwable throwable) {
        if (throwable instanceof ModelDBException) {
          throw (ModelDBException) throwable;
        }
        throw new ModelDBException("Unknown error", Code.INTERNAL);
      }
    }
  }

  private String findChildFolder(Session session,
      InternalFolderElementEntity rootFolder, List<String> path) throws Throwable {
    if (path.size() == 0) {
      return rootFolder.getElement_sha();
    }
    InternalFolderElementEntity nextFolder = (InternalFolderElementEntity) session.createQuery(
        "From " + InternalFolderElementEntity.class.getSimpleName() + " where folder_hash = '"
            + rootFolder.getElement_sha() + "' and element_name = '" + path.get(0) + "'").uniqueResultOptional().orElseThrow(() -> new ModelDBException("No such path", Code.INVALID_ARGUMENT));
    return findChildFolder(session, nextFolder, path.subList(1, path.size()));
  }
}

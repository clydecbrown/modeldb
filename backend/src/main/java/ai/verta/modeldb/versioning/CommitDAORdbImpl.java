package ai.verta.modeldb.versioning;

import ai.verta.modeldb.ModelDBException;
import ai.verta.modeldb.entities.versioning.CommitEntity;
import ai.verta.modeldb.utils.ModelDBHibernateUtil;
import ai.verta.modeldb.versioning.CreateCommitRequest.Response;
import com.google.protobuf.ProtocolStringList;
import io.grpc.Status.Code;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
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
      Stream<CommitEntity> list;
      if (request.getCommitBase().isEmpty() && request.getCommitHead().isEmpty()) {
        Query<CommitEntity> query = session.createQuery("select c From CommitEntity");
        list = query.list().stream().filter(c -> c.getParent_commits().isEmpty());
      } else {
        Query<CommitEntity> query;
        if (request.getCommitBase().isEmpty()) {
          query = session.createQuery(
              "select c From CommitEntity c join c.child_commits h where h.commit_hash='" + request
                  .getCommitHead() + "'");
        } else if (request.getCommitHead().isEmpty()) {
          query = session.createQuery(
              "select c From CommitEntity c join c.parent_commits p where p.commit_hash='"
                  + request.getCommitBase() + "'");
        } else {
          query = session.createQuery(
              "select c From CommitEntity c join c.parent_commits p join c.child_commits h where p.commit_hash='"
                  + request.getCommitBase() + "' and h.commit_hash='" + request.getCommitHead()
                  + "'");
        }
        LOGGER.debug("Final query : {}", query.getQueryString());
        list = query.list().stream();
      }
      return ListCommitsRequest.Response.newBuilder()
          .addAllCommits(list.map(CommitEntity::toCommitProto).collect(Collectors.toList()))
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
}

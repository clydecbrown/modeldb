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
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
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
      CriteriaBuilder builder = session.getCriteriaBuilder();
      CriteriaQuery<CommitEntity> criteriaQuery =
          builder.createQuery(CommitEntity.class);
      Root<CommitEntity> root = criteriaQuery.from(CommitEntity.class);
      //criteriaQuery.select(root);
      criteriaQuery.where(root.get("parent_commits").in(request.getCommitBase()));
      Query query2 = session.createQuery(criteriaQuery);
      LOGGER.debug("Final query : {}", query2.getQueryString());
      Query<CommitEntity> query = session.createQuery("select c From CommitEntity c join c.parent_commits p where p.commit_hash='" + request.getCommitBase() + "'");
      Query<CommitEntity> query123 = session.createQuery("select c From CommitEntity c join c.parent_commits p where p.commit_hash='" + request.getCommitBase() + "'");
      Query<CommitEntity> query23 = session.createQuery("select c From CommitEntity c join c.child_commits p where p.commit_hash='" + request.getCommitHead() + "'");
      LOGGER.debug("Final query : {}", query.getQueryString());
      List<CommitEntity> list = query.list();
      List<CommitEntity> list23 = query23.list();
      return null;
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

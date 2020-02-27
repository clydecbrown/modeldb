package ai.verta.modeldb.versioning;

import ai.verta.modeldb.ModelDBException;
import com.google.protobuf.ProtocolStringList;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import org.hibernate.Session;

interface DatasetComponentDAO {

  String setBlobs(Session session, List<BlobExpanded> blobsList, FileHasher fileHasher)
      throws NoSuchAlgorithmException;

  GetCommitBlobRequest.Response getCommitBlob(
      RepositoryFunction repositoryFunction, String commitHash, ProtocolStringList locationList)
      throws NoSuchAlgorithmException, ModelDBException;
}

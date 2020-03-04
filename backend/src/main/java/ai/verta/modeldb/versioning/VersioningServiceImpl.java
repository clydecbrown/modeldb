package ai.verta.modeldb.versioning;

import ai.verta.modeldb.ModelDBAuthInterceptor;
import ai.verta.modeldb.ModelDBException;
import ai.verta.modeldb.authservice.AuthService;
import ai.verta.modeldb.authservice.RoleService;
import ai.verta.modeldb.experiment.ExperimentDAO;
import ai.verta.modeldb.experimentRun.ExperimentRunDAO;
import ai.verta.modeldb.monitoring.QPSCountResource;
import ai.verta.modeldb.monitoring.RequestLatencyResource;
import ai.verta.modeldb.utils.ModelDBUtils;
import ai.verta.modeldb.versioning.ListRepositoriesRequest.Response;
import ai.verta.modeldb.versioning.PathDatasetComponentBlob.Builder;
import ai.verta.modeldb.versioning.VersioningServiceGrpc.VersioningServiceImplBase;
import ai.verta.uac.UserInfo;
import io.grpc.Status.Code;
import io.grpc.stub.StreamObserver;
import java.security.NoSuchAlgorithmException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VersioningServiceImpl extends VersioningServiceImplBase {

  private static final Logger LOGGER = LogManager.getLogger(VersioningServiceImpl.class);
  private final AuthService authService;
  private final RoleService roleService;
  private final RepositoryDAO repositoryDAO;
  private final CommitDAO commitDAO;
  private final DatasetComponentDAO datasetComponentDAO;
  private final ExperimentDAO experimentDAO;
  private final ExperimentRunDAO experimentRunDAO;
  private final ModelDBAuthInterceptor modelDBAuthInterceptor;
  private final FileHasher fileHasher;

  public VersioningServiceImpl(
      AuthService authService,
      RoleService roleService,
      RepositoryDAO repositoryDAO,
      CommitDAO commitDAO,
      DatasetComponentDAO datasetComponentDAO,
      ExperimentDAO experimentDAO,
      ExperimentRunDAO experimentRunDAO,
      ModelDBAuthInterceptor modelDBAuthInterceptor,
      FileHasher fileHasher) {
    this.authService = authService;
    this.roleService = roleService;
    this.repositoryDAO = repositoryDAO;
    this.commitDAO = commitDAO;
    this.datasetComponentDAO = datasetComponentDAO;
    this.experimentDAO = experimentDAO;
    this.experimentRunDAO = experimentRunDAO;
    this.modelDBAuthInterceptor = modelDBAuthInterceptor;
    this.fileHasher = fileHasher;
  }

  @Override
  public void listRepositories(
      ListRepositoriesRequest request, StreamObserver<Response> responseObserver) {
    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        if (request.hasPagination()) {
          if (request.getPagination().getPageLimit() < 1
              || request.getPagination().getPageLimit() > 100) {
            throw new ModelDBException("Page limit is invalid", Code.INVALID_ARGUMENT);
          }
        }
        Response response = repositoryDAO.listRepositories(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, ListRepositoriesRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void getRepository(
      GetRepositoryRequest request,
      StreamObserver<GetRepositoryRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        GetRepositoryRequest.Response response = repositoryDAO.getRepository(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, GetRepositoryRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void createRepository(
      SetRepository request, StreamObserver<SetRepository.Response> responseObserver) {
    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        if (request.getRepository().getName().isEmpty()) {
          throw new ModelDBException("Repository name is empty", Code.INVALID_ARGUMENT);
        }

        UserInfo userInfo = authService.getCurrentLoginUserInfo();
        SetRepository.Builder requestBuilder = request.toBuilder();
        if (userInfo != null) {
          String vertaId = authService.getVertaIdFromUserInfo(userInfo);
          requestBuilder.setRepository(request.getRepository().toBuilder().setOwner(vertaId));
        }
        SetRepository.Response response = repositoryDAO.setRepository(requestBuilder.build(), true);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(responseObserver, e, SetRepository.Response.getDefaultInstance());
    }
  }

  @Override
  public void updateRepository(
      SetRepository request, StreamObserver<SetRepository.Response> responseObserver) {
    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        if (request.getRepository().getName().isEmpty()) {
          throw new ModelDBException("Repository name is empty", Code.INVALID_ARGUMENT);
        }

        SetRepository.Response response = repositoryDAO.setRepository(request, false);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(responseObserver, e, SetRepository.Response.getDefaultInstance());
    }
  }

  @Override
  public void deleteRepository(
      DeleteRepositoryRequest request,
      StreamObserver<DeleteRepositoryRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        DeleteRepositoryRequest.Response response = repositoryDAO.deleteRepository(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, DeleteRepositoryRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void listCommits(
      ListCommitsRequest request, StreamObserver<ListCommitsRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try (RequestLatencyResource latencyResource =
        new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
      ListCommitsRequest.Response response =
          commitDAO.listCommits(
              request,
              (session) -> repositoryDAO.getRepositoryById(session, request.getRepositoryId()));
      responseObserver.onNext(response);
      responseObserver.onCompleted();
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, ListCommitsRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void getCommit(
      GetCommitRequest request, StreamObserver<GetCommitRequest.Response> responseObserver) {

    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        Commit commit =
            commitDAO.getCommit(
                request.getCommitSha(),
                (session) -> repositoryDAO.getRepositoryById(session, request.getRepositoryId()));
        responseObserver.onNext(GetCommitRequest.Response.newBuilder().setCommit(commit).build());
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, GetCommitRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void createCommit(
      CreateCommitRequest request, StreamObserver<CreateCommitRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try (RequestLatencyResource latencyResource =
        new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
      if (request.getBlobsCount() == 0) {
        throw new ModelDBException("Blob list should not be empty", Code.INVALID_ARGUMENT);
      }
      CreateCommitRequest.Builder newRequest = clearCommitDetails(request);
      UserInfo currentLoginUserInfo = authService.getCurrentLoginUserInfo();

      CreateCommitRequest.Response response =
          commitDAO.setCommit(
              authService.getVertaIdFromUserInfo(currentLoginUserInfo),
              request.getCommit(),
              (session) ->
                  datasetComponentDAO.setBlobs(session, newRequest.getBlobsList(), fileHasher),
              (session) -> repositoryDAO.getRepositoryById(session, request.getRepositoryId()));

      responseObserver.onNext(response);
      responseObserver.onCompleted();
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, CreateCommitRequest.Response.getDefaultInstance());
    }
  }

  // returns a builder without the commit Details like message and author
  private CreateCommitRequest.Builder clearCommitDetails(CreateCommitRequest request)
      throws ModelDBException, NoSuchAlgorithmException {
    CreateCommitRequest.Builder newRequest = CreateCommitRequest.newBuilder();
    for (BlobExpanded blob : request.getBlobsList()) {
      if (blob.getLocationList().isEmpty()) {
        throw new ModelDBException("Blob path should not be empty", Code.INVALID_ARGUMENT);
      }
      switch (blob.getBlob().getContentCase()) {
        case DATASET:
          final DatasetBlob dataset = blob.getBlob().getDataset();
          final DatasetBlob.Builder newDataset = validateDataset(dataset);
          newRequest.addBlobs(blob.toBuilder().setBlob(Blob.newBuilder().setDataset(newDataset)));
          break;
        case ENVIRONMENT:
          // Coming Soon.
          break;
        case CONTENT_NOT_SET:
        default:
          break;
      }
    }
    return newRequest;
  }
  // Not sure if this is required, Validate paths
  // TODO EL to add comment on what this function is suppose to do
  private DatasetBlob.Builder validateDataset(final DatasetBlob dataset)
      throws ModelDBException, NoSuchAlgorithmException {
    final DatasetBlob.Builder newDataset = DatasetBlob.newBuilder();

    switch (dataset.getContentCase()) {
      case S3:
        S3DatasetBlob.Builder newS3BlobBuilder = S3DatasetBlob.newBuilder();
        for (S3DatasetComponentBlob component : dataset.getS3().getComponentsList()) {
          if (!component.hasPath()) {
            throw new ModelDBException("Blob path should not be empty", Code.INVALID_ARGUMENT);
          }
          newS3BlobBuilder.addComponents(component.toBuilder().setPath(component.getPath()));
        }
        newDataset.setS3(newS3BlobBuilder);
        break;
      case PATH:
        PathDatasetBlob.Builder newPathBlobBuilder = PathDatasetBlob.newBuilder();
        for (PathDatasetComponentBlob component : dataset.getPath().getComponentsList()) {
          newPathBlobBuilder.addComponents(component);
        }
        newDataset.setPath(newPathBlobBuilder);
        break;
      default:
        throw new ModelDBException("Blob unknown type", Code.INVALID_ARGUMENT);
    }
    return newDataset;
  }

  @Override
  public void deleteCommit(
      DeleteCommitRequest request, StreamObserver<DeleteCommitRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        DeleteCommitRequest.Response response =
            commitDAO.deleteCommit(
                request.getCommitSha(),
                (session) -> repositoryDAO.getRepositoryById(session, request.getRepositoryId()));
        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, DeleteCommitRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void listCommitBlobs(
      ListCommitBlobsRequest request,
      StreamObserver<ListCommitBlobsRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try (RequestLatencyResource latencyResource =
        new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
      if (request.getCommitSha().isEmpty()) {
        throw new ModelDBException("Commit SHA should not be empty", Code.INVALID_ARGUMENT);
      } else if (request.getLocationPrefixList().isEmpty()) {
        throw new ModelDBException("location prefix should not be empty", Code.INVALID_ARGUMENT);
      }

      ListCommitBlobsRequest.Response response =
          datasetComponentDAO.getCommitBlobsList(
              (session) -> repositoryDAO.getRepositoryById(session, request.getRepositoryId()),
              request.getCommitSha(),
              request.getLocationPrefixList());
      responseObserver.onNext(response);
      responseObserver.onCompleted();
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, ListCommitBlobsRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void getCommitComponent(
      GetCommitComponentRequest request,
      StreamObserver<GetCommitComponentRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try (RequestLatencyResource latencyResource =
        new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
      if (request.getCommitSha().isEmpty()) {
        throw new ModelDBException("Commit SHA should not be empty", Code.INVALID_ARGUMENT);
      } else if (request.getLocationList().isEmpty()) {
        throw new ModelDBException("Blob location should not be empty", Code.INVALID_ARGUMENT);
      }

      GetCommitComponentRequest.Response response =
          datasetComponentDAO.getCommitComponent(
              (session) -> repositoryDAO.getRepositoryById(session, request.getRepositoryId()),
              request.getCommitSha(),
              request.getLocationList());
      responseObserver.onNext(response);
      responseObserver.onCompleted();
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, GetCommitComponentRequest.Response.getDefaultInstance());
    }
  }

  private Builder getPathInfo(PathDatasetComponentBlob path)
      throws ModelDBException, NoSuchAlgorithmException {
    // TODO: md5
    return path.toBuilder().setSha256(generateAndValidateSha(path));
  }

  String generateAndValidateSha(PathDatasetComponentBlob path)
      throws ModelDBException, NoSuchAlgorithmException {
    String sha = path.getSha256();
    String generatedSha = fileHasher.getSha(path);
    if (!sha.isEmpty() && !sha.equals(generatedSha)) {
      throw new ModelDBException("Checksum is wrong", Code.INVALID_ARGUMENT);
    }
    return generatedSha;
  }

  @Override
  public void computeRepositoryDiff(
      ComputeRepositoryDiffRequest request,
      StreamObserver<ComputeRepositoryDiffRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try (RequestLatencyResource latencyResource =
        new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
      ComputeRepositoryDiffRequest.Response response =
          datasetComponentDAO.computeRepositoryDiff(
              (session) -> repositoryDAO.getRepositoryById(session, request.getRepositoryId()),
              request);
      responseObserver.onNext(response);
      responseObserver.onCompleted();
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, ComputeRepositoryDiffRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void listBranches(
      ListBranchesRequest request, StreamObserver<ListBranchesRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        ListBranchesRequest.Response response = repositoryDAO.listBranches(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, ListBranchesRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void getBranch(
      GetBranchRequest request, StreamObserver<GetBranchRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        GetBranchRequest.Response response = repositoryDAO.getBranch(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, GetBranchRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void setBranch(
      SetBranchRequest request, StreamObserver<SetBranchRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        SetBranchRequest.Response response = repositoryDAO.setBranch(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, SetBranchRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void deleteBranch(
      DeleteBranchRequest request, StreamObserver<DeleteBranchRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        if (request.getBranch().isEmpty()) {
          throw new ModelDBException(
              "Branch not found in the DeleteBranchRequest", Code.INVALID_ARGUMENT);
        }
        DeleteBranchRequest.Response response = repositoryDAO.deleteBranch(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, DeleteBranchRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void listBranchCommits(
      ListBranchCommitsRequest request,
      StreamObserver<ListBranchCommitsRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        ListBranchCommitsRequest.Response response = repositoryDAO.listBranchCommits(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, ListBranchCommitsRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void listTags(
      ListTagsRequest request, StreamObserver<ListTagsRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        ListTagsRequest.Response response = repositoryDAO.listTags(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(responseObserver, e, ListTagsRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void getTag(
      GetTagRequest request, StreamObserver<GetTagRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        GetTagRequest.Response response = repositoryDAO.getTag(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(responseObserver, e, GetTagRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void setTag(
      SetTagRequest request, StreamObserver<SetTagRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        SetTagRequest.Response response = repositoryDAO.setTag(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(responseObserver, e, SetTagRequest.Response.getDefaultInstance());
    }
  }

  @Override
  public void deleteTag(
      DeleteTagRequest request, StreamObserver<DeleteTagRequest.Response> responseObserver) {
    QPSCountResource.inc();
    try {
      try (RequestLatencyResource latencyResource =
          new RequestLatencyResource(modelDBAuthInterceptor.getMethodName())) {
        if (request.getTag().isEmpty()) {
          throw new ModelDBException(
              "Tag not found in the DeleteTagRequest", Code.INVALID_ARGUMENT);
        }
        DeleteTagRequest.Response response = repositoryDAO.deleteTag(request);
        responseObserver.onNext(response);
        responseObserver.onCompleted();
      }
    } catch (Exception e) {
      ModelDBUtils.observeError(
          responseObserver, e, DeleteTagRequest.Response.getDefaultInstance());
    }
  }
}

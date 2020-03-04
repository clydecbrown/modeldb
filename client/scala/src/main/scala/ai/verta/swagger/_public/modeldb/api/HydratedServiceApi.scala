// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.swagger._public.modeldb.api

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.Duration
import scala.util.Try

import ai.verta.swagger.client.HttpClient
import ai.verta.swagger.client.type_hints.GenericObject
import ai.verta.swagger._public.modeldb.model._

class HydratedServiceApi(client: HttpClient, val basePath: String = "/v1") {
  def findHydratedDatasetVersionsAsync(body: ModeldbFindDatasetVersions)(implicit ec: ExecutionContext): Future[Try[ModeldbAdvancedQueryDatasetVersionsResponse]] = {
    val __query = Map[String,String](
    )
    if (body == null) throw new Exception("Missing required parameter \"body\"")
    return client.request[ModeldbFindDatasetVersions, ModeldbAdvancedQueryDatasetVersionsResponse]("POST", basePath + s"/hydratedData/findHydratedDatasetVersions", __query, body)
  }

  def findHydratedDatasetVersions(body: ModeldbFindDatasetVersions)(implicit ec: ExecutionContext): Try[ModeldbAdvancedQueryDatasetVersionsResponse] = Await.result(findHydratedDatasetVersionsAsync(body), Duration.Inf)

  def findHydratedDatasetsAsync(body: ModeldbFindDatasets)(implicit ec: ExecutionContext): Future[Try[ModeldbAdvancedQueryDatasetsResponse]] = {
    val __query = Map[String,String](
    )
    if (body == null) throw new Exception("Missing required parameter \"body\"")
    return client.request[ModeldbFindDatasets, ModeldbAdvancedQueryDatasetsResponse]("POST", basePath + s"/hydratedData/findHydratedDatasets", __query, body)
  }

  def findHydratedDatasets(body: ModeldbFindDatasets)(implicit ec: ExecutionContext): Try[ModeldbAdvancedQueryDatasetsResponse] = Await.result(findHydratedDatasetsAsync(body), Duration.Inf)

  def findHydratedDatasetsByOrganizationAsync(body: ModeldbFindHydratedDatasetsByOrganization)(implicit ec: ExecutionContext): Future[Try[ModeldbAdvancedQueryDatasetsResponse]] = {
    val __query = Map[String,String](
    )
    if (body == null) throw new Exception("Missing required parameter \"body\"")
    return client.request[ModeldbFindHydratedDatasetsByOrganization, ModeldbAdvancedQueryDatasetsResponse]("POST", basePath + s"/hydratedData/findHydratedDatasetsByOrganization", __query, body)
  }

  def findHydratedDatasetsByOrganization(body: ModeldbFindHydratedDatasetsByOrganization)(implicit ec: ExecutionContext): Try[ModeldbAdvancedQueryDatasetsResponse] = Await.result(findHydratedDatasetsByOrganizationAsync(body), Duration.Inf)

  def findHydratedDatasetsByTeamAsync(body: ModeldbFindHydratedDatasetsByTeam)(implicit ec: ExecutionContext): Future[Try[ModeldbAdvancedQueryDatasetsResponse]] = {
    val __query = Map[String,String](
    )
    if (body == null) throw new Exception("Missing required parameter \"body\"")
    return client.request[ModeldbFindHydratedDatasetsByTeam, ModeldbAdvancedQueryDatasetsResponse]("POST", basePath + s"/hydratedData/findHydratedDatasetsByTeam", __query, body)
  }

  def findHydratedDatasetsByTeam(body: ModeldbFindHydratedDatasetsByTeam)(implicit ec: ExecutionContext): Try[ModeldbAdvancedQueryDatasetsResponse] = Await.result(findHydratedDatasetsByTeamAsync(body), Duration.Inf)

  def findHydratedExperimentRunsAsync(body: ModeldbFindExperimentRuns)(implicit ec: ExecutionContext): Future[Try[ModeldbAdvancedQueryExperimentRunsResponse]] = {
    val __query = Map[String,String](
    )
    if (body == null) throw new Exception("Missing required parameter \"body\"")
    return client.request[ModeldbFindExperimentRuns, ModeldbAdvancedQueryExperimentRunsResponse]("POST", basePath + s"/hydratedData/findHydratedExperimentRuns", __query, body)
  }

  def findHydratedExperimentRuns(body: ModeldbFindExperimentRuns)(implicit ec: ExecutionContext): Try[ModeldbAdvancedQueryExperimentRunsResponse] = Await.result(findHydratedExperimentRunsAsync(body), Duration.Inf)

  def findHydratedExperimentsAsync(body: ModeldbFindExperiments)(implicit ec: ExecutionContext): Future[Try[ModeldbAdvancedQueryExperimentsResponse]] = {
    val __query = Map[String,String](
    )
    if (body == null) throw new Exception("Missing required parameter \"body\"")
    return client.request[ModeldbFindExperiments, ModeldbAdvancedQueryExperimentsResponse]("POST", basePath + s"/hydratedData/findHydratedExperiments", __query, body)
  }

  def findHydratedExperiments(body: ModeldbFindExperiments)(implicit ec: ExecutionContext): Try[ModeldbAdvancedQueryExperimentsResponse] = Await.result(findHydratedExperimentsAsync(body), Duration.Inf)

  def findHydratedProjectsAsync(body: ModeldbFindProjects)(implicit ec: ExecutionContext): Future[Try[ModeldbAdvancedQueryProjectsResponse]] = {
    val __query = Map[String,String](
    )
    if (body == null) throw new Exception("Missing required parameter \"body\"")
    return client.request[ModeldbFindProjects, ModeldbAdvancedQueryProjectsResponse]("POST", basePath + s"/hydratedData/findHydratedProjects", __query, body)
  }

  def findHydratedProjects(body: ModeldbFindProjects)(implicit ec: ExecutionContext): Try[ModeldbAdvancedQueryProjectsResponse] = Await.result(findHydratedProjectsAsync(body), Duration.Inf)

  def findHydratedProjectsByOrganizationAsync(body: ModeldbFindHydratedProjectsByOrganization)(implicit ec: ExecutionContext): Future[Try[ModeldbAdvancedQueryProjectsResponse]] = {
    val __query = Map[String,String](
    )
    if (body == null) throw new Exception("Missing required parameter \"body\"")
    return client.request[ModeldbFindHydratedProjectsByOrganization, ModeldbAdvancedQueryProjectsResponse]("POST", basePath + s"/hydratedData/findHydratedProjectsByOrganization", __query, body)
  }

  def findHydratedProjectsByOrganization(body: ModeldbFindHydratedProjectsByOrganization)(implicit ec: ExecutionContext): Try[ModeldbAdvancedQueryProjectsResponse] = Await.result(findHydratedProjectsByOrganizationAsync(body), Duration.Inf)

  def findHydratedProjectsByTeamAsync(body: ModeldbFindHydratedProjectsByTeam)(implicit ec: ExecutionContext): Future[Try[ModeldbAdvancedQueryProjectsResponse]] = {
    val __query = Map[String,String](
    )
    if (body == null) throw new Exception("Missing required parameter \"body\"")
    return client.request[ModeldbFindHydratedProjectsByTeam, ModeldbAdvancedQueryProjectsResponse]("POST", basePath + s"/hydratedData/findHydratedProjectsByTeam", __query, body)
  }

  def findHydratedProjectsByTeam(body: ModeldbFindHydratedProjectsByTeam)(implicit ec: ExecutionContext): Try[ModeldbAdvancedQueryProjectsResponse] = Await.result(findHydratedProjectsByTeamAsync(body), Duration.Inf)

  def findHydratedProjectsByUserAsync(body: ModeldbFindHydratedProjectsByUser)(implicit ec: ExecutionContext): Future[Try[ModeldbAdvancedQueryProjectsResponse]] = {
    val __query = Map[String,String](
    )
    if (body == null) throw new Exception("Missing required parameter \"body\"")
    return client.request[ModeldbFindHydratedProjectsByUser, ModeldbAdvancedQueryProjectsResponse]("POST", basePath + s"/hydratedData/findHydratedProjectsByUser", __query, body)
  }

  def findHydratedProjectsByUser(body: ModeldbFindHydratedProjectsByUser)(implicit ec: ExecutionContext): Try[ModeldbAdvancedQueryProjectsResponse] = Await.result(findHydratedProjectsByUserAsync(body), Duration.Inf)

  def findHydratedPublicDatasetsAsync(body: ModeldbFindDatasets)(implicit ec: ExecutionContext): Future[Try[ModeldbAdvancedQueryDatasetsResponse]] = {
    val __query = Map[String,String](
    )
    if (body == null) throw new Exception("Missing required parameter \"body\"")
    return client.request[ModeldbFindDatasets, ModeldbAdvancedQueryDatasetsResponse]("POST", basePath + s"/hydratedData/findHydratedPublicDatasets", __query, body)
  }

  def findHydratedPublicDatasets(body: ModeldbFindDatasets)(implicit ec: ExecutionContext): Try[ModeldbAdvancedQueryDatasetsResponse] = Await.result(findHydratedPublicDatasetsAsync(body), Duration.Inf)

  def findHydratedPublicProjectsAsync(body: ModeldbFindProjects)(implicit ec: ExecutionContext): Future[Try[ModeldbAdvancedQueryProjectsResponse]] = {
    val __query = Map[String,String](
    )
    if (body == null) throw new Exception("Missing required parameter \"body\"")
    return client.request[ModeldbFindProjects, ModeldbAdvancedQueryProjectsResponse]("POST", basePath + s"/hydratedData/findHydratedPublicProjects", __query, body)
  }

  def findHydratedPublicProjects(body: ModeldbFindProjects)(implicit ec: ExecutionContext): Try[ModeldbAdvancedQueryProjectsResponse] = Await.result(findHydratedPublicProjectsAsync(body), Duration.Inf)

  def getHydratedDatasetByNameAsync(name: String, workspace_name: String)(implicit ec: ExecutionContext): Future[Try[ModeldbGetHydratedDatasetByNameResponse]] = {
    val __query = Map[String,String](
      "name" -> client.toQuery(name),
      "workspace_name" -> client.toQuery(workspace_name)
    )
    val body: Any = null
    return client.request[Any, ModeldbGetHydratedDatasetByNameResponse]("GET", basePath + s"/hydratedData/getHydratedDatasetByName", __query, body)
  }

  def getHydratedDatasetByName(name: String, workspace_name: String)(implicit ec: ExecutionContext): Try[ModeldbGetHydratedDatasetByNameResponse] = Await.result(getHydratedDatasetByNameAsync(name, workspace_name), Duration.Inf)

  def getHydratedDatasetsByProjectIdAsync(project_id: String, page_number: Integer, page_limit: Integer, ascending: Boolean, sort_key: String)(implicit ec: ExecutionContext): Future[Try[ModeldbGetHydratedDatasetsByProjectIdResponse]] = {
    val __query = Map[String,String](
      "project_id" -> client.toQuery(project_id),
      "page_number" -> client.toQuery(page_number),
      "page_limit" -> client.toQuery(page_limit),
      "ascending" -> client.toQuery(ascending),
      "sort_key" -> client.toQuery(sort_key)
    )
    val body: Any = null
    return client.request[Any, ModeldbGetHydratedDatasetsByProjectIdResponse]("GET", basePath + s"/hydratedData/getHydratedDatasetsByProjectId", __query, body)
  }

  def getHydratedDatasetsByProjectId(project_id: String, page_number: Integer, page_limit: Integer, ascending: Boolean, sort_key: String)(implicit ec: ExecutionContext): Try[ModeldbGetHydratedDatasetsByProjectIdResponse] = Await.result(getHydratedDatasetsByProjectIdAsync(project_id, page_number, page_limit, ascending, sort_key), Duration.Inf)

  def getHydratedExperimentRunByIdAsync(id: String)(implicit ec: ExecutionContext): Future[Try[ModeldbGetHydratedExperimentRunByIdResponse]] = {
    val __query = Map[String,String](
      "id" -> client.toQuery(id)
    )
    val body: Any = null
    return client.request[Any, ModeldbGetHydratedExperimentRunByIdResponse]("GET", basePath + s"/hydratedData/getHydratedExperimentRunById", __query, body)
  }

  def getHydratedExperimentRunById(id: String)(implicit ec: ExecutionContext): Try[ModeldbGetHydratedExperimentRunByIdResponse] = Await.result(getHydratedExperimentRunByIdAsync(id), Duration.Inf)

  def getHydratedExperimentRunsInProjectAsync(project_id: String, page_number: Integer, page_limit: Integer, ascending: Boolean, sort_key: String)(implicit ec: ExecutionContext): Future[Try[ModeldbGetHydratedExperimentRunsByProjectIdResponse]] = {
    val __query = Map[String,String](
      "project_id" -> client.toQuery(project_id),
      "page_number" -> client.toQuery(page_number),
      "page_limit" -> client.toQuery(page_limit),
      "ascending" -> client.toQuery(ascending),
      "sort_key" -> client.toQuery(sort_key)
    )
    val body: Any = null
    return client.request[Any, ModeldbGetHydratedExperimentRunsByProjectIdResponse]("GET", basePath + s"/hydratedData/getHydratedExperimentRunsInProject", __query, body)
  }

  def getHydratedExperimentRunsInProject(project_id: String, page_number: Integer, page_limit: Integer, ascending: Boolean, sort_key: String)(implicit ec: ExecutionContext): Try[ModeldbGetHydratedExperimentRunsByProjectIdResponse] = Await.result(getHydratedExperimentRunsInProjectAsync(project_id, page_number, page_limit, ascending, sort_key), Duration.Inf)

  def getHydratedExperimentsByProjectIdAsync(project_id: String, page_number: Integer, page_limit: Integer, ascending: Boolean, sort_key: String)(implicit ec: ExecutionContext): Future[Try[ModeldbGetHydratedExperimentsByProjectIdResponse]] = {
    val __query = Map[String,String](
      "project_id" -> client.toQuery(project_id),
      "page_number" -> client.toQuery(page_number),
      "page_limit" -> client.toQuery(page_limit),
      "ascending" -> client.toQuery(ascending),
      "sort_key" -> client.toQuery(sort_key)
    )
    val body: Any = null
    return client.request[Any, ModeldbGetHydratedExperimentsByProjectIdResponse]("GET", basePath + s"/hydratedData/getHydratedExperimentsByProjectId", __query, body)
  }

  def getHydratedExperimentsByProjectId(project_id: String, page_number: Integer, page_limit: Integer, ascending: Boolean, sort_key: String)(implicit ec: ExecutionContext): Try[ModeldbGetHydratedExperimentsByProjectIdResponse] = Await.result(getHydratedExperimentsByProjectIdAsync(project_id, page_number, page_limit, ascending, sort_key), Duration.Inf)

  def getHydratedProjectByIdAsync(id: String)(implicit ec: ExecutionContext): Future[Try[ModeldbGetHydratedProjectByIdResponse]] = {
    val __query = Map[String,String](
      "id" -> client.toQuery(id)
    )
    val body: Any = null
    return client.request[Any, ModeldbGetHydratedProjectByIdResponse]("GET", basePath + s"/hydratedData/getHydratedProjectById", __query, body)
  }

  def getHydratedProjectById(id: String)(implicit ec: ExecutionContext): Try[ModeldbGetHydratedProjectByIdResponse] = Await.result(getHydratedProjectByIdAsync(id), Duration.Inf)

  def getHydratedProjectsAsync(page_number: Integer, page_limit: Integer, ascending: Boolean, sort_key: String, workspace_name: String)(implicit ec: ExecutionContext): Future[Try[ModeldbGetHydratedProjectsResponse]] = {
    val __query = Map[String,String](
      "page_number" -> client.toQuery(page_number),
      "page_limit" -> client.toQuery(page_limit),
      "ascending" -> client.toQuery(ascending),
      "sort_key" -> client.toQuery(sort_key),
      "workspace_name" -> client.toQuery(workspace_name)
    )
    val body: Any = null
    return client.request[Any, ModeldbGetHydratedProjectsResponse]("GET", basePath + s"/hydratedData/getHydratedProjects", __query, body)
  }

  def getHydratedProjects(page_number: Integer, page_limit: Integer, ascending: Boolean, sort_key: String, workspace_name: String)(implicit ec: ExecutionContext): Try[ModeldbGetHydratedProjectsResponse] = Await.result(getHydratedProjectsAsync(page_number, page_limit, ascending, sort_key, workspace_name), Duration.Inf)

  def getHydratedPublicProjectsAsync(page_number: Integer, page_limit: Integer, ascending: Boolean, sort_key: String, workspace_name: String)(implicit ec: ExecutionContext): Future[Try[ModeldbGetHydratedProjectsResponse]] = {
    val __query = Map[String,String](
      "page_number" -> client.toQuery(page_number),
      "page_limit" -> client.toQuery(page_limit),
      "ascending" -> client.toQuery(ascending),
      "sort_key" -> client.toQuery(sort_key),
      "workspace_name" -> client.toQuery(workspace_name)
    )
    val body: Any = null
    return client.request[Any, ModeldbGetHydratedProjectsResponse]("GET", basePath + s"/hydratedData/getHydratedPublicProjects", __query, body)
  }

  def getHydratedPublicProjects(page_number: Integer, page_limit: Integer, ascending: Boolean, sort_key: String, workspace_name: String)(implicit ec: ExecutionContext): Try[ModeldbGetHydratedProjectsResponse] = Await.result(getHydratedPublicProjectsAsync(page_number, page_limit, ascending, sort_key, workspace_name), Duration.Inf)

  def getTopHydratedExperimentRunsAsync(project_id: String, experiment_id: String, experiment_run_ids: List[String], sort_key: String, ascending: Boolean, top_k: Integer, ids_only: Boolean)(implicit ec: ExecutionContext): Future[Try[ModeldbAdvancedQueryExperimentRunsResponse]] = {
    val __query = Map[String,String](
      "project_id" -> client.toQuery(project_id),
      "experiment_id" -> client.toQuery(experiment_id),
      "experiment_run_ids" -> client.toQuery(experiment_run_ids),
      "sort_key" -> client.toQuery(sort_key),
      "ascending" -> client.toQuery(ascending),
      "top_k" -> client.toQuery(top_k),
      "ids_only" -> client.toQuery(ids_only)
    )
    val body: Any = null
    return client.request[Any, ModeldbAdvancedQueryExperimentRunsResponse]("GET", basePath + s"/hydratedData/getTopHydratedExperimentRuns", __query, body)
  }

  def getTopHydratedExperimentRuns(project_id: String, experiment_id: String, experiment_run_ids: List[String], sort_key: String, ascending: Boolean, top_k: Integer, ids_only: Boolean)(implicit ec: ExecutionContext): Try[ModeldbAdvancedQueryExperimentRunsResponse] = Await.result(getTopHydratedExperimentRunsAsync(project_id, experiment_id, experiment_run_ids, sort_key, ascending, top_k, ids_only), Duration.Inf)

  def sortHydratedExperimentRunsAsync(experiment_run_ids: List[String], sort_key: String, ascending: Boolean, ids_only: Boolean)(implicit ec: ExecutionContext): Future[Try[ModeldbAdvancedQueryExperimentRunsResponse]] = {
    val __query = Map[String,String](
      "experiment_run_ids" -> client.toQuery(experiment_run_ids),
      "sort_key" -> client.toQuery(sort_key),
      "ascending" -> client.toQuery(ascending),
      "ids_only" -> client.toQuery(ids_only)
    )
    val body: Any = null
    return client.request[Any, ModeldbAdvancedQueryExperimentRunsResponse]("GET", basePath + s"/hydratedData/sortHydratedExperimentRuns", __query, body)
  }

  def sortHydratedExperimentRuns(experiment_run_ids: List[String], sort_key: String, ascending: Boolean, ids_only: Boolean)(implicit ec: ExecutionContext): Try[ModeldbAdvancedQueryExperimentRunsResponse] = Await.result(sortHydratedExperimentRunsAsync(experiment_run_ids, sort_key, ascending, ids_only), Duration.Inf)

}

// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.swagger._public.modeldb.api

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.Duration
import scala.util.Try

import ai.verta.swagger.client.Client
import ai.verta.swagger._public.modeldb.model._

class CommentApi(client: Client, val basePath: String = "/v1") {
  def addExperimentRunCommentAsync(body: ModeldbAddComment)(implicit ec: ExecutionContext): Future[Try[ModeldbAddCommentResponse]] = {
    val __query = Map[String,String](
    )
    if (body == null) throw new Exception("Missing required parameter \"body\"")
    return client.request[ModeldbAddComment, ModeldbAddCommentResponse]("POST", basePath + s"/comment/addExperimentRunComment", __query, body)
  }

  def addExperimentRunComment(body: ModeldbAddComment)(implicit ec: ExecutionContext): Try[ModeldbAddCommentResponse] = Await.result(addExperimentRunCommentAsync(body), Duration.Inf)

  def deleteExperimentRunCommentAsync(id: String, entityId: String)(implicit ec: ExecutionContext): Future[Try[ModeldbDeleteCommentResponse]] = {
    val __query = Map[String,String](
      "id" -> client.toQuery(id),
      "entity_id" -> client.toQuery(entityId)
    )
    val body: Any = null
    return client.request[Any, ModeldbDeleteCommentResponse]("DELETE", basePath + s"/comment/deleteExperimentRunComment", __query, body)
  }

  def deleteExperimentRunComment(id: String, entityId: String)(implicit ec: ExecutionContext): Try[ModeldbDeleteCommentResponse] = Await.result(deleteExperimentRunCommentAsync(id, entityId), Duration.Inf)

  def getExperimentRunCommentsAsync(entityId: String)(implicit ec: ExecutionContext): Future[Try[ModeldbGetCommentsResponse]] = {
    val __query = Map[String,String](
      "entity_id" -> client.toQuery(entityId)
    )
    val body: Any = null
    return client.request[Any, ModeldbGetCommentsResponse]("GET", basePath + s"/comment/getExperimentRunComments", __query, body)
  }

  def getExperimentRunComments(entityId: String)(implicit ec: ExecutionContext): Try[ModeldbGetCommentsResponse] = Await.result(getExperimentRunCommentsAsync(entityId), Duration.Inf)

  def updateExperimentRunCommentAsync(body: ModeldbUpdateComment)(implicit ec: ExecutionContext): Future[Try[ModeldbUpdateCommentResponse]] = {
    val __query = Map[String,String](
    )
    if (body == null) throw new Exception("Missing required parameter \"body\"")
    return client.request[ModeldbUpdateComment, ModeldbUpdateCommentResponse]("POST", basePath + s"/comment/updateExperimentRunComment", __query, body)
  }

  def updateExperimentRunComment(body: ModeldbUpdateComment)(implicit ec: ExecutionContext): Try[ModeldbUpdateCommentResponse] = Await.result(updateExperimentRunCommentAsync(body), Duration.Inf)

}

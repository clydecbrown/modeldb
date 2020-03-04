package ai.verta.swagger.client

import java.io.InputStream
import java.net.{URI, URLEncoder}

import ai.verta.swagger.client.type_hints.CommonKeyValue
import net.liftweb.json.Serialization.write
import net.liftweb.json.{DefaultFormats, parse}
import sttp.client._
import sttp.client.asynchttpclient.future.AsyncHttpClientFutureBackend
import sttp.model._

import scala.concurrent.duration.Duration
import scala.concurrent.{Await, ExecutionContext, Future}
import scala.util.{Failure, Success, Try}

class HttpClient(val host: String, val headers: Map[String, String]) {
  implicit val formats = DefaultFormats.withHints(CommonKeyValue.hints)
  implicit val sttpBackend = AsyncHttpClientFutureBackend()

  private def urlEncodeUTF8(s: String) = {
    URLEncoder.encode(s, "UTF-8")
  }

  private def urlEncodeUTF8(q: Map[String, String]): String = {
    if (q.isEmpty) "" else
      q
        .map(entry => urlEncodeUTF8(entry._1) + "=" + urlEncodeUTF8(entry._2))
        .reduce((p1, p2) => p1 + "&" + p2)
  }

  def request[T1, T2](method: String, path: String, query: Map[String, String], body: T1)(implicit ec: ExecutionContext, m: Manifest[T2]): Future[Try[T2]] = {
    val request = if (body != null) basicRequest.body(write(body)) else basicRequest

    val queryString = urlEncodeUTF8(query)
    val uriPath = if (query.isEmpty) Uri(new URI(host + path)) else Uri(new URI(host + path + "?" + queryString))

    val request2 = method match {
      case "GET" => request.get(uriPath)
      case "POST" => request.post(uriPath)
      case "PUT" => request.put(uriPath)
      case "DELETE" => request.delete(uriPath)
      case _ => throw new IllegalArgumentException(s"unknown method $method")
    }

    val futureResponse = request2.headers(headers).send()

    futureResponse.map(response => {
      response.body match {
        case Left(failureBody) => Failure(HttpException(response.code, failureBody))
        case Right(successBody) => {
          println(successBody)
          val json = parse(successBody)
          val result = json.extract[T2]
          Success(result)
        }
      }
    })
  }

  def requestRaw(method: String, url: String, query: Map[String, String], body: InputStream)(implicit ec: ExecutionContext) = {
    val request = if (body != null) basicRequest.body(body) else basicRequest
    val uriPath = Uri(new URI(url))
    val request2 = method match {
      case "GET" => request.get(uriPath)
      case "POST" => request.post(uriPath)
      case "PUT" => request.put(uriPath)
      case "DELETE" => request.delete(uriPath)
      case _ => throw new IllegalArgumentException(s"unknown method $method")
    }

    val futureResponse = request2.send()

    futureResponse.map(response => {
      response.body match {
        case Left(failureBody) => Failure(HttpException(response.code, failureBody))
        case Right(successBody) => {
          Success(successBody)
        }
      }
    })
  }

  def toQuery[T](value: T): String = value.toString

  def close(): Unit = Await.result(sttpBackend.close(), Duration.Inf)
}
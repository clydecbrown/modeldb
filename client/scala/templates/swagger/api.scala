// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.swagger.{{package}}.api

import scala.concurrent.{Await, ExecutionContext, Future}
import scala.concurrent.duration.Duration
import scala.util.Try

import ai.verta.swagger.client.Client
import ai.verta.swagger.{{package}}.model._

class {{api_name}}Api(client: Client, val basePath: String = "{{base_path}}") {
{{#operations}}
  def {{operation_id}}Async({{#parameters}}{{safe_name}}: {{type}}{{^last}}, {{/last}}{{/parameters}})(implicit ec: ExecutionContext): Future[Try[{{success_type}}]] = {
    val __query = Map[String,String](
      {{#query}}
      "{{name}}" -> client.toQuery({{safe_name}}){{^last}},{{/last}}
      {{/query}}
    )
    {{#required}}
    if ({{safe_name}} == null) throw new Exception("Missing required parameter \"{{safe_name}}\"")
    {{/required}}
    {{^body_present}}
    val body: Any = null
    {{/body_present}}
    return client.request[{{body_type}}, {{success_type}}]("{{op}}", basePath + s"{{path}}", __query, body)
  }

  def {{operation_id}}({{#parameters}}{{safe_name}}: {{type}}{{^last}}, {{/last}}{{/parameters}})(implicit ec: ExecutionContext): Try[{{success_type}}] = Await.result({{operation_id}}Async({{#parameters}}{{safe_name}}{{^last}}, {{/last}}{{/parameters}}), Duration.Inf)

{{/operations}}
}

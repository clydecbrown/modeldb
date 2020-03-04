// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.swagger._public.modeldb.versioning.model

import ai.verta.swagger.client.type_hints.GenericObject
import ai.verta.swagger._public.modeldb.versioning.model.WorkspaceTypeEnumWorkspaceType._

case class VersioningEnvironmentBlob (
  python: Option[VersioningPythonEnvironmentBlob] = None,
  docker: Option[VersioningDockerEnvironmentBlob] = None,
  environment_variables: Option[List[VersioningEnvironmentVariablesBlob]] = None,
  command_line: Option[List[String]] = None
)

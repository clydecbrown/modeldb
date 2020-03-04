// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.swagger._public.modeldb.versioning.model

import ai.verta.swagger.client.type_hints.GenericObject
import ai.verta.swagger._public.modeldb.versioning.model.WorkspaceTypeEnumWorkspaceType._

case class VersioningPythonEnvironmentBlob (
  version: Option[VersioningVersionEnvironmentBlob] = None,
  requirements: Option[List[VersioningPythonRequirementEnvironmentBlob]] = None,
  constraints: Option[List[VersioningPythonRequirementEnvironmentBlob]] = None
)

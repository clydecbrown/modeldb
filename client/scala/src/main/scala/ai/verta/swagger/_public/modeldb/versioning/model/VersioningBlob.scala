// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.swagger._public.modeldb.versioning.model

import ai.verta.swagger.client.type_hints.GenericObject
import ai.verta.swagger._public.modeldb.versioning.model.WorkspaceTypeEnumWorkspaceType._

case class VersioningBlob (
  dataset: Option[VersioningDatasetBlob] = None,
  environment: Option[VersioningEnvironmentBlob] = None,
  code: Option[VersioningCodeBlob] = None,
  config: Option[VersioningConfigBlob] = None
)

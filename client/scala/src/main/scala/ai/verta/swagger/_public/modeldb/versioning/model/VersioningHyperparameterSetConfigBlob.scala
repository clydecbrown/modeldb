// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.swagger._public.modeldb.versioning.model

import ai.verta.swagger.client.type_hints.GenericObject
import ai.verta.swagger._public.modeldb.versioning.model.WorkspaceTypeEnumWorkspaceType._

case class VersioningHyperparameterSetConfigBlob (
  name: Option[String] = None,
  continuous: Option[VersioningContinuousHyperparameterSetConfigBlob] = None,
  discrete: Option[VersioningDiscreteHyperparameterSetConfigBlob] = None
)

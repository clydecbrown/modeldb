// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.swagger._public.modeldb.versioning.model

import ai.verta.swagger.client.type_hints.GenericObject
import ai.verta.swagger._public.modeldb.versioning.model.WorkspaceTypeEnumWorkspaceType._

case class VersioningConfigBlob (
  hyperparameter_set: Option[List[VersioningHyperparameterSetConfigBlob]] = None,
  hyperparameters: Option[List[VersioningHyperparameterConfigBlob]] = None
)
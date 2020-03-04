// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.swagger._public.modeldb.model

import ai.verta.swagger.client.type_hints.GenericObject
import ai.verta.swagger._public.modeldb.model.ArtifactTypeEnumArtifactType._
import ai.verta.swagger._public.modeldb.model.OperatorEnumOperator._
import ai.verta.swagger._public.modeldb.model.TernaryEnumTernary._
import ai.verta.swagger._public.modeldb.model.ValueTypeEnumValueType._
import ai.verta.swagger._public.modeldb.model.WorkspaceTypeEnumWorkspaceType._
import ai.verta.swagger._public.modeldb.model.ModeldbProjectVisibility._
import ai.verta.swagger._public.modeldb.model.ProtobufNullValue._

case class ModeldbArtifact (
  key: Option[String] = None,
  path: Option[String] = None,
  path_only: Option[Boolean] = None,
  artifact_type: Option[ArtifactTypeEnumArtifactType] = None,
  linked_artifact_id: Option[String] = None,
  filename_extension: Option[String] = None
)

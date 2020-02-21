// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.swagger._public.modeldb.model

import ai.verta.swagger._public.modeldb.model.ArtifactTypeEnumArtifactType._
import ai.verta.swagger._public.modeldb.model.DatasetTypeEnumDatasetType._
import ai.verta.swagger._public.modeldb.model.DatasetVisibilityEnumDatasetVisibility._
import ai.verta.swagger._public.modeldb.model.OperatorEnumOperator._
import ai.verta.swagger._public.modeldb.model.TernaryEnumTernary._
import ai.verta.swagger._public.modeldb.model.ValueTypeEnumValueType._
import ai.verta.swagger._public.modeldb.model.WorkspaceTypeEnumWorkspaceType._
import ai.verta.swagger._public.modeldb.model.ProtobufNullValue._

case class ModeldbCreateDataset (
  name: Option[String] = None,
  description: Option[String] = None,
  tags: Option[List[String]] = None,
  attributes: Option[List[CommonKeyValue]] = None,
  datasetVisibility: Option[DatasetVisibilityEnumDatasetVisibility] = None,
  datasetType: Option[DatasetTypeEnumDatasetType] = None,
  workspaceName: Option[String] = None,
  timeCreated: Option[String] = None
)

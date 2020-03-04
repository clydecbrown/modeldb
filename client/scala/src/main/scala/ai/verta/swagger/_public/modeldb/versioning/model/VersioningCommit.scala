// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.swagger._public.modeldb.versioning.model

import ai.verta.swagger.client.type_hints.GenericObject
import ai.verta.swagger._public.modeldb.versioning.model.WorkspaceTypeEnumWorkspaceType._

case class VersioningCommit (
  parent_shas: Option[List[String]] = None,
  message: Option[String] = None,
  date_created: Option[String] = None,
  author: Option[String] = None,
  commit_sha: Option[String] = None
)

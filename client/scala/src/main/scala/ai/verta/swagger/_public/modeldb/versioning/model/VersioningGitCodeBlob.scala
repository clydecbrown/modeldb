// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.swagger._public.modeldb.versioning.model

import ai.verta.swagger.client.type_hints.GenericObject
import ai.verta.swagger._public.modeldb.versioning.model.WorkspaceTypeEnumWorkspaceType._

case class VersioningGitCodeBlob (
  repo: Option[String] = None,
  hash: Option[String] = None,
  branch: Option[String] = None,
  tag: Option[String] = None,
  is_dirty: Option[Boolean] = None
)
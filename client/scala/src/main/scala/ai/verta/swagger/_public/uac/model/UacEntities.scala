// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.swagger._public.uac.model

import ai.verta.swagger._public.uac.model.AuthzActionEnumAuthzServiceActions._
import ai.verta.swagger._public.uac.model.AuthzResourceEnumAuthzServiceResourceTypes._
import ai.verta.swagger._public.uac.model.ModelDBActionEnumModelDBServiceActions._
import ai.verta.swagger._public.uac.model.ModelResourceEnumModelDBServiceResourceTypes._
import ai.verta.swagger._public.uac.model.RoleActionEnumRoleServiceActions._
import ai.verta.swagger._public.uac.model.RoleResourceEnumRoleServiceResourceTypes._
import ai.verta.swagger._public.uac.model.ServiceEnumService._

case class UacEntities (
  user_ids: Option[List[String]] = None,
  org_ids: Option[List[String]] = None,
  team_ids: Option[List[String]] = None
)

// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.swagger._public.uac.model

import ai.verta.swagger.client.type_hints.GenericObject
import ai.verta.swagger._public.uac.model.IdServiceProviderEnumIdServiceProvider._
import ai.verta.swagger._public.uac.model.UacFlagEnum._

case class RuntimeError (
  error: Option[String] = None,
  code: Option[Integer] = None,
  message: Option[String] = None,
  details: Option[List[ProtobufAny]] = None
)
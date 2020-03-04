// THIS FILE IS AUTO-GENERATED. DO NOT EDIT
package ai.verta.swagger.{{package}}.model

import ai.verta.swagger.client.type_hints.GenericObject
{{#__object_flag}}
{{#enums}}
import ai.verta.swagger.{{package}}.model.{{name}}._
{{/enums}}

case class {{class_name}} (
{{#properties}}
  {{#required}}
  {{name}}: {{#type}}{{> type}}{{/type}}{{^last}},{{/last}}
  {{/required}}
  {{^required}}
  {{name}}: Option[{{#type}}{{> type}}{{/type}}] = None{{^last}},{{/last}}
  {{/required}}
{{/properties}}
)
{{/__object_flag}}
{{#__enum_flag}}
object {{class_name}} {
  type {{class_name}} = String
  {{#enum_values}}
  val {{name}}: {{class_name}} = "{{name}}"
  {{/enum_values}}
}
{{/__enum_flag}}

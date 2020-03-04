package ai.verta.swagger.client.type_hints

case class GenericObject(
                          null_value: Option[Unit] = None,
                          number_value: Option[Double] = None,
                          string_value: Option[String] = None,
                          bool_value: Option[Boolean] = None,
                          struct_value: Option[Map[String, GenericObject]] = None,
                          list_value: Option[List[GenericObject]] = None
                        )

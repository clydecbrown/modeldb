# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: protos/public/uac/Authorization.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


from google.api import annotations_pb2 as google_dot_api_dot_annotations__pb2
from ...public.uac import RoleService_pb2 as protos_dot_public_dot_uac_dot_RoleService__pb2


DESCRIPTOR = _descriptor.FileDescriptor(
  name='protos/public/uac/Authorization.proto',
  package='ai.verta.uac',
  syntax='proto3',
  serialized_options=_b('P\001Z:github.com/VertaAI/modeldb/protos/gen/go/protos/public/uac'),
  serialized_pb=_b('\n%protos/public/uac/Authorization.proto\x12\x0c\x61i.verta.uac\x1a\x1cgoogle/api/annotations.proto\x1a#protos/public/uac/RoleService.proto\"\xa5\x01\n\tIsAllowed\x12(\n\x08\x65ntities\x18\x01 \x03(\x0b\x32\x16.ai.verta.uac.Entities\x12%\n\x07\x61\x63tions\x18\x02 \x03(\x0b\x32\x14.ai.verta.uac.Action\x12*\n\tresources\x18\x03 \x03(\x0b\x32\x17.ai.verta.uac.Resources\x1a\x1b\n\x08Response\x12\x0f\n\x07\x61llowed\x18\x01 \x01(\x08\"\x9d\x01\n\x12GetAllowedEntities\x12%\n\x07\x61\x63tions\x18\x01 \x03(\x0b\x32\x14.ai.verta.uac.Action\x12*\n\tresources\x18\x02 \x03(\x0b\x32\x17.ai.verta.uac.Resources\x1a\x34\n\x08Response\x12(\n\x08\x65ntities\x18\x01 \x03(\x0b\x32\x16.ai.verta.uac.Entities\"\x9e\x01\n\x13GetAllowedResources\x12(\n\x08\x65ntities\x18\x01 \x03(\x0b\x32\x16.ai.verta.uac.Entities\x12%\n\x07\x61\x63tions\x18\x02 \x03(\x0b\x32\x14.ai.verta.uac.Action\x1a\x36\n\x08Response\x12*\n\tresources\x18\x01 \x03(\x0b\x32\x17.ai.verta.uac.Resources\"\x7f\n\rIsSelfAllowed\x12%\n\x07\x61\x63tions\x18\x02 \x03(\x0b\x32\x14.ai.verta.uac.Action\x12*\n\tresources\x18\x03 \x03(\x0b\x32\x17.ai.verta.uac.Resources\x1a\x1b\n\x08Response\x12\x0f\n\x07\x61llowed\x18\x01 \x01(\x08\"x\n\x17GetSelfAllowedResources\x12%\n\x07\x61\x63tions\x18\x02 \x03(\x0b\x32\x14.ai.verta.uac.Action\x1a\x36\n\x08Response\x12*\n\tresources\x18\x01 \x03(\x0b\x32\x17.ai.verta.uac.Resources\"0\n\x07\x41\x63tions\x12%\n\x07\x61\x63tions\x18\x02 \x03(\x0b\x32\x14.ai.verta.uac.Action\"\xed\x01\n\x1aGetSelfAllowedActionsBatch\x12*\n\tresources\x18\x03 \x01(\x0b\x32\x17.ai.verta.uac.Resources\x1a\xa2\x01\n\x08Response\x12O\n\x07\x61\x63tions\x18\x02 \x03(\x0b\x32>.ai.verta.uac.GetSelfAllowedActionsBatch.Response.ActionsEntry\x1a\x45\n\x0c\x41\x63tionsEntry\x12\x0b\n\x03key\x18\x01 \x01(\t\x12$\n\x05value\x18\x02 \x01(\x0b\x32\x15.ai.verta.uac.Actions:\x02\x38\x01\x32\xab\t\n\x0c\x41uthzService\x12\x66\n\tisAllowed\x12\x17.ai.verta.uac.IsAllowed\x1a .ai.verta.uac.IsAllowed.Response\"\x1e\x82\xd3\xe4\x93\x02\x18\"\x13/v1/authz/isAllowed:\x01*\x12\x8a\x01\n\x12getAllowedEntities\x12 .ai.verta.uac.GetAllowedEntities\x1a).ai.verta.uac.GetAllowedEntities.Response\"\'\x82\xd3\xe4\x93\x02!\"\x1c/v1/authz/getAllowedEntities:\x01*\x12\x8e\x01\n\x13getAllowedResources\x12!.ai.verta.uac.GetAllowedResources\x1a*.ai.verta.uac.GetAllowedResources.Response\"(\x82\xd3\xe4\x93\x02\"\"\x1d/v1/authz/getAllowedResources:\x01*\x12\x9d\x01\n\x1agetDireclyAllowedResources\x12!.ai.verta.uac.GetAllowedResources\x1a*.ai.verta.uac.GetAllowedResources.Response\"0\x82\xd3\xe4\x93\x02*\"%/v1/authz/getDirectlyAllowedResources:\x01*\x12v\n\risSelfAllowed\x12\x1b.ai.verta.uac.IsSelfAllowed\x1a$.ai.verta.uac.IsSelfAllowed.Response\"\"\x82\xd3\xe4\x93\x02\x1c\"\x17/v1/authz/isSelfAllowed:\x01*\x12\x9e\x01\n\x17getSelfAllowedResources\x12%.ai.verta.uac.GetSelfAllowedResources\x1a..ai.verta.uac.GetSelfAllowedResources.Response\",\x82\xd3\xe4\x93\x02&\"!/v1/authz/getSelfAllowedResources:\x01*\x12\xae\x01\n\x1fgetSelfDirectlyAllowedResources\x12%.ai.verta.uac.GetSelfAllowedResources\x1a..ai.verta.uac.GetSelfAllowedResources.Response\"4\x82\xd3\xe4\x93\x02.\")/v1/authz/getSelfDirectlyAllowedResources:\x01*\x12\xaa\x01\n\x1agetSelfAllowedActionsBatch\x12(.ai.verta.uac.GetSelfAllowedActionsBatch\x1a\x31.ai.verta.uac.GetSelfAllowedActionsBatch.Response\"/\x82\xd3\xe4\x93\x02)\"$/v1/authz/getSelfAllowedActionsBatch:\x01*B>P\x01Z:github.com/VertaAI/modeldb/protos/gen/go/protos/public/uacb\x06proto3')
  ,
  dependencies=[google_dot_api_dot_annotations__pb2.DESCRIPTOR,protos_dot_public_dot_uac_dot_RoleService__pb2.DESCRIPTOR,])




_ISALLOWED_RESPONSE = _descriptor.Descriptor(
  name='Response',
  full_name='ai.verta.uac.IsAllowed.Response',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='allowed', full_name='ai.verta.uac.IsAllowed.Response.allowed', index=0,
      number=1, type=8, cpp_type=7, label=1,
      has_default_value=False, default_value=False,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=261,
  serialized_end=288,
)

_ISALLOWED = _descriptor.Descriptor(
  name='IsAllowed',
  full_name='ai.verta.uac.IsAllowed',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='entities', full_name='ai.verta.uac.IsAllowed.entities', index=0,
      number=1, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='actions', full_name='ai.verta.uac.IsAllowed.actions', index=1,
      number=2, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='resources', full_name='ai.verta.uac.IsAllowed.resources', index=2,
      number=3, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[_ISALLOWED_RESPONSE, ],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=123,
  serialized_end=288,
)


_GETALLOWEDENTITIES_RESPONSE = _descriptor.Descriptor(
  name='Response',
  full_name='ai.verta.uac.GetAllowedEntities.Response',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='entities', full_name='ai.verta.uac.GetAllowedEntities.Response.entities', index=0,
      number=1, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=396,
  serialized_end=448,
)

_GETALLOWEDENTITIES = _descriptor.Descriptor(
  name='GetAllowedEntities',
  full_name='ai.verta.uac.GetAllowedEntities',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='actions', full_name='ai.verta.uac.GetAllowedEntities.actions', index=0,
      number=1, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='resources', full_name='ai.verta.uac.GetAllowedEntities.resources', index=1,
      number=2, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[_GETALLOWEDENTITIES_RESPONSE, ],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=291,
  serialized_end=448,
)


_GETALLOWEDRESOURCES_RESPONSE = _descriptor.Descriptor(
  name='Response',
  full_name='ai.verta.uac.GetAllowedResources.Response',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='resources', full_name='ai.verta.uac.GetAllowedResources.Response.resources', index=0,
      number=1, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=555,
  serialized_end=609,
)

_GETALLOWEDRESOURCES = _descriptor.Descriptor(
  name='GetAllowedResources',
  full_name='ai.verta.uac.GetAllowedResources',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='entities', full_name='ai.verta.uac.GetAllowedResources.entities', index=0,
      number=1, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='actions', full_name='ai.verta.uac.GetAllowedResources.actions', index=1,
      number=2, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[_GETALLOWEDRESOURCES_RESPONSE, ],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=451,
  serialized_end=609,
)


_ISSELFALLOWED_RESPONSE = _descriptor.Descriptor(
  name='Response',
  full_name='ai.verta.uac.IsSelfAllowed.Response',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='allowed', full_name='ai.verta.uac.IsSelfAllowed.Response.allowed', index=0,
      number=1, type=8, cpp_type=7, label=1,
      has_default_value=False, default_value=False,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=261,
  serialized_end=288,
)

_ISSELFALLOWED = _descriptor.Descriptor(
  name='IsSelfAllowed',
  full_name='ai.verta.uac.IsSelfAllowed',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='actions', full_name='ai.verta.uac.IsSelfAllowed.actions', index=0,
      number=2, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='resources', full_name='ai.verta.uac.IsSelfAllowed.resources', index=1,
      number=3, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[_ISSELFALLOWED_RESPONSE, ],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=611,
  serialized_end=738,
)


_GETSELFALLOWEDRESOURCES_RESPONSE = _descriptor.Descriptor(
  name='Response',
  full_name='ai.verta.uac.GetSelfAllowedResources.Response',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='resources', full_name='ai.verta.uac.GetSelfAllowedResources.Response.resources', index=0,
      number=1, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=555,
  serialized_end=609,
)

_GETSELFALLOWEDRESOURCES = _descriptor.Descriptor(
  name='GetSelfAllowedResources',
  full_name='ai.verta.uac.GetSelfAllowedResources',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='actions', full_name='ai.verta.uac.GetSelfAllowedResources.actions', index=0,
      number=2, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[_GETSELFALLOWEDRESOURCES_RESPONSE, ],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=740,
  serialized_end=860,
)


_ACTIONS = _descriptor.Descriptor(
  name='Actions',
  full_name='ai.verta.uac.Actions',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='actions', full_name='ai.verta.uac.Actions.actions', index=0,
      number=2, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=862,
  serialized_end=910,
)


_GETSELFALLOWEDACTIONSBATCH_RESPONSE_ACTIONSENTRY = _descriptor.Descriptor(
  name='ActionsEntry',
  full_name='ai.verta.uac.GetSelfAllowedActionsBatch.Response.ActionsEntry',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='key', full_name='ai.verta.uac.GetSelfAllowedActionsBatch.Response.ActionsEntry.key', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='value', full_name='ai.verta.uac.GetSelfAllowedActionsBatch.Response.ActionsEntry.value', index=1,
      number=2, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
  ],
  serialized_options=_b('8\001'),
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=1081,
  serialized_end=1150,
)

_GETSELFALLOWEDACTIONSBATCH_RESPONSE = _descriptor.Descriptor(
  name='Response',
  full_name='ai.verta.uac.GetSelfAllowedActionsBatch.Response',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='actions', full_name='ai.verta.uac.GetSelfAllowedActionsBatch.Response.actions', index=0,
      number=2, type=11, cpp_type=10, label=3,
      has_default_value=False, default_value=[],
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[_GETSELFALLOWEDACTIONSBATCH_RESPONSE_ACTIONSENTRY, ],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=988,
  serialized_end=1150,
)

_GETSELFALLOWEDACTIONSBATCH = _descriptor.Descriptor(
  name='GetSelfAllowedActionsBatch',
  full_name='ai.verta.uac.GetSelfAllowedActionsBatch',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='resources', full_name='ai.verta.uac.GetSelfAllowedActionsBatch.resources', index=0,
      number=3, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[_GETSELFALLOWEDACTIONSBATCH_RESPONSE, ],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=913,
  serialized_end=1150,
)

_ISALLOWED_RESPONSE.containing_type = _ISALLOWED
_ISALLOWED.fields_by_name['entities'].message_type = protos_dot_public_dot_uac_dot_RoleService__pb2._ENTITIES
_ISALLOWED.fields_by_name['actions'].message_type = protos_dot_public_dot_uac_dot_RoleService__pb2._ACTION
_ISALLOWED.fields_by_name['resources'].message_type = protos_dot_public_dot_uac_dot_RoleService__pb2._RESOURCES
_GETALLOWEDENTITIES_RESPONSE.fields_by_name['entities'].message_type = protos_dot_public_dot_uac_dot_RoleService__pb2._ENTITIES
_GETALLOWEDENTITIES_RESPONSE.containing_type = _GETALLOWEDENTITIES
_GETALLOWEDENTITIES.fields_by_name['actions'].message_type = protos_dot_public_dot_uac_dot_RoleService__pb2._ACTION
_GETALLOWEDENTITIES.fields_by_name['resources'].message_type = protos_dot_public_dot_uac_dot_RoleService__pb2._RESOURCES
_GETALLOWEDRESOURCES_RESPONSE.fields_by_name['resources'].message_type = protos_dot_public_dot_uac_dot_RoleService__pb2._RESOURCES
_GETALLOWEDRESOURCES_RESPONSE.containing_type = _GETALLOWEDRESOURCES
_GETALLOWEDRESOURCES.fields_by_name['entities'].message_type = protos_dot_public_dot_uac_dot_RoleService__pb2._ENTITIES
_GETALLOWEDRESOURCES.fields_by_name['actions'].message_type = protos_dot_public_dot_uac_dot_RoleService__pb2._ACTION
_ISSELFALLOWED_RESPONSE.containing_type = _ISSELFALLOWED
_ISSELFALLOWED.fields_by_name['actions'].message_type = protos_dot_public_dot_uac_dot_RoleService__pb2._ACTION
_ISSELFALLOWED.fields_by_name['resources'].message_type = protos_dot_public_dot_uac_dot_RoleService__pb2._RESOURCES
_GETSELFALLOWEDRESOURCES_RESPONSE.fields_by_name['resources'].message_type = protos_dot_public_dot_uac_dot_RoleService__pb2._RESOURCES
_GETSELFALLOWEDRESOURCES_RESPONSE.containing_type = _GETSELFALLOWEDRESOURCES
_GETSELFALLOWEDRESOURCES.fields_by_name['actions'].message_type = protos_dot_public_dot_uac_dot_RoleService__pb2._ACTION
_ACTIONS.fields_by_name['actions'].message_type = protos_dot_public_dot_uac_dot_RoleService__pb2._ACTION
_GETSELFALLOWEDACTIONSBATCH_RESPONSE_ACTIONSENTRY.fields_by_name['value'].message_type = _ACTIONS
_GETSELFALLOWEDACTIONSBATCH_RESPONSE_ACTIONSENTRY.containing_type = _GETSELFALLOWEDACTIONSBATCH_RESPONSE
_GETSELFALLOWEDACTIONSBATCH_RESPONSE.fields_by_name['actions'].message_type = _GETSELFALLOWEDACTIONSBATCH_RESPONSE_ACTIONSENTRY
_GETSELFALLOWEDACTIONSBATCH_RESPONSE.containing_type = _GETSELFALLOWEDACTIONSBATCH
_GETSELFALLOWEDACTIONSBATCH.fields_by_name['resources'].message_type = protos_dot_public_dot_uac_dot_RoleService__pb2._RESOURCES
DESCRIPTOR.message_types_by_name['IsAllowed'] = _ISALLOWED
DESCRIPTOR.message_types_by_name['GetAllowedEntities'] = _GETALLOWEDENTITIES
DESCRIPTOR.message_types_by_name['GetAllowedResources'] = _GETALLOWEDRESOURCES
DESCRIPTOR.message_types_by_name['IsSelfAllowed'] = _ISSELFALLOWED
DESCRIPTOR.message_types_by_name['GetSelfAllowedResources'] = _GETSELFALLOWEDRESOURCES
DESCRIPTOR.message_types_by_name['Actions'] = _ACTIONS
DESCRIPTOR.message_types_by_name['GetSelfAllowedActionsBatch'] = _GETSELFALLOWEDACTIONSBATCH
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

IsAllowed = _reflection.GeneratedProtocolMessageType('IsAllowed', (_message.Message,), dict(

  Response = _reflection.GeneratedProtocolMessageType('Response', (_message.Message,), dict(
    DESCRIPTOR = _ISALLOWED_RESPONSE,
    __module__ = 'protos.public.uac.Authorization_pb2'
    # @@protoc_insertion_point(class_scope:ai.verta.uac.IsAllowed.Response)
    ))
  ,
  DESCRIPTOR = _ISALLOWED,
  __module__ = 'protos.public.uac.Authorization_pb2'
  # @@protoc_insertion_point(class_scope:ai.verta.uac.IsAllowed)
  ))
_sym_db.RegisterMessage(IsAllowed)
_sym_db.RegisterMessage(IsAllowed.Response)

GetAllowedEntities = _reflection.GeneratedProtocolMessageType('GetAllowedEntities', (_message.Message,), dict(

  Response = _reflection.GeneratedProtocolMessageType('Response', (_message.Message,), dict(
    DESCRIPTOR = _GETALLOWEDENTITIES_RESPONSE,
    __module__ = 'protos.public.uac.Authorization_pb2'
    # @@protoc_insertion_point(class_scope:ai.verta.uac.GetAllowedEntities.Response)
    ))
  ,
  DESCRIPTOR = _GETALLOWEDENTITIES,
  __module__ = 'protos.public.uac.Authorization_pb2'
  # @@protoc_insertion_point(class_scope:ai.verta.uac.GetAllowedEntities)
  ))
_sym_db.RegisterMessage(GetAllowedEntities)
_sym_db.RegisterMessage(GetAllowedEntities.Response)

GetAllowedResources = _reflection.GeneratedProtocolMessageType('GetAllowedResources', (_message.Message,), dict(

  Response = _reflection.GeneratedProtocolMessageType('Response', (_message.Message,), dict(
    DESCRIPTOR = _GETALLOWEDRESOURCES_RESPONSE,
    __module__ = 'protos.public.uac.Authorization_pb2'
    # @@protoc_insertion_point(class_scope:ai.verta.uac.GetAllowedResources.Response)
    ))
  ,
  DESCRIPTOR = _GETALLOWEDRESOURCES,
  __module__ = 'protos.public.uac.Authorization_pb2'
  # @@protoc_insertion_point(class_scope:ai.verta.uac.GetAllowedResources)
  ))
_sym_db.RegisterMessage(GetAllowedResources)
_sym_db.RegisterMessage(GetAllowedResources.Response)

IsSelfAllowed = _reflection.GeneratedProtocolMessageType('IsSelfAllowed', (_message.Message,), dict(

  Response = _reflection.GeneratedProtocolMessageType('Response', (_message.Message,), dict(
    DESCRIPTOR = _ISSELFALLOWED_RESPONSE,
    __module__ = 'protos.public.uac.Authorization_pb2'
    # @@protoc_insertion_point(class_scope:ai.verta.uac.IsSelfAllowed.Response)
    ))
  ,
  DESCRIPTOR = _ISSELFALLOWED,
  __module__ = 'protos.public.uac.Authorization_pb2'
  # @@protoc_insertion_point(class_scope:ai.verta.uac.IsSelfAllowed)
  ))
_sym_db.RegisterMessage(IsSelfAllowed)
_sym_db.RegisterMessage(IsSelfAllowed.Response)

GetSelfAllowedResources = _reflection.GeneratedProtocolMessageType('GetSelfAllowedResources', (_message.Message,), dict(

  Response = _reflection.GeneratedProtocolMessageType('Response', (_message.Message,), dict(
    DESCRIPTOR = _GETSELFALLOWEDRESOURCES_RESPONSE,
    __module__ = 'protos.public.uac.Authorization_pb2'
    # @@protoc_insertion_point(class_scope:ai.verta.uac.GetSelfAllowedResources.Response)
    ))
  ,
  DESCRIPTOR = _GETSELFALLOWEDRESOURCES,
  __module__ = 'protos.public.uac.Authorization_pb2'
  # @@protoc_insertion_point(class_scope:ai.verta.uac.GetSelfAllowedResources)
  ))
_sym_db.RegisterMessage(GetSelfAllowedResources)
_sym_db.RegisterMessage(GetSelfAllowedResources.Response)

Actions = _reflection.GeneratedProtocolMessageType('Actions', (_message.Message,), dict(
  DESCRIPTOR = _ACTIONS,
  __module__ = 'protos.public.uac.Authorization_pb2'
  # @@protoc_insertion_point(class_scope:ai.verta.uac.Actions)
  ))
_sym_db.RegisterMessage(Actions)

GetSelfAllowedActionsBatch = _reflection.GeneratedProtocolMessageType('GetSelfAllowedActionsBatch', (_message.Message,), dict(

  Response = _reflection.GeneratedProtocolMessageType('Response', (_message.Message,), dict(

    ActionsEntry = _reflection.GeneratedProtocolMessageType('ActionsEntry', (_message.Message,), dict(
      DESCRIPTOR = _GETSELFALLOWEDACTIONSBATCH_RESPONSE_ACTIONSENTRY,
      __module__ = 'protos.public.uac.Authorization_pb2'
      # @@protoc_insertion_point(class_scope:ai.verta.uac.GetSelfAllowedActionsBatch.Response.ActionsEntry)
      ))
    ,
    DESCRIPTOR = _GETSELFALLOWEDACTIONSBATCH_RESPONSE,
    __module__ = 'protos.public.uac.Authorization_pb2'
    # @@protoc_insertion_point(class_scope:ai.verta.uac.GetSelfAllowedActionsBatch.Response)
    ))
  ,
  DESCRIPTOR = _GETSELFALLOWEDACTIONSBATCH,
  __module__ = 'protos.public.uac.Authorization_pb2'
  # @@protoc_insertion_point(class_scope:ai.verta.uac.GetSelfAllowedActionsBatch)
  ))
_sym_db.RegisterMessage(GetSelfAllowedActionsBatch)
_sym_db.RegisterMessage(GetSelfAllowedActionsBatch.Response)
_sym_db.RegisterMessage(GetSelfAllowedActionsBatch.Response.ActionsEntry)


DESCRIPTOR._options = None
_GETSELFALLOWEDACTIONSBATCH_RESPONSE_ACTIONSENTRY._options = None

_AUTHZSERVICE = _descriptor.ServiceDescriptor(
  name='AuthzService',
  full_name='ai.verta.uac.AuthzService',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  serialized_start=1153,
  serialized_end=2348,
  methods=[
  _descriptor.MethodDescriptor(
    name='isAllowed',
    full_name='ai.verta.uac.AuthzService.isAllowed',
    index=0,
    containing_service=None,
    input_type=_ISALLOWED,
    output_type=_ISALLOWED_RESPONSE,
    serialized_options=_b('\202\323\344\223\002\030\"\023/v1/authz/isAllowed:\001*'),
  ),
  _descriptor.MethodDescriptor(
    name='getAllowedEntities',
    full_name='ai.verta.uac.AuthzService.getAllowedEntities',
    index=1,
    containing_service=None,
    input_type=_GETALLOWEDENTITIES,
    output_type=_GETALLOWEDENTITIES_RESPONSE,
    serialized_options=_b('\202\323\344\223\002!\"\034/v1/authz/getAllowedEntities:\001*'),
  ),
  _descriptor.MethodDescriptor(
    name='getAllowedResources',
    full_name='ai.verta.uac.AuthzService.getAllowedResources',
    index=2,
    containing_service=None,
    input_type=_GETALLOWEDRESOURCES,
    output_type=_GETALLOWEDRESOURCES_RESPONSE,
    serialized_options=_b('\202\323\344\223\002\"\"\035/v1/authz/getAllowedResources:\001*'),
  ),
  _descriptor.MethodDescriptor(
    name='getDireclyAllowedResources',
    full_name='ai.verta.uac.AuthzService.getDireclyAllowedResources',
    index=3,
    containing_service=None,
    input_type=_GETALLOWEDRESOURCES,
    output_type=_GETALLOWEDRESOURCES_RESPONSE,
    serialized_options=_b('\202\323\344\223\002*\"%/v1/authz/getDirectlyAllowedResources:\001*'),
  ),
  _descriptor.MethodDescriptor(
    name='isSelfAllowed',
    full_name='ai.verta.uac.AuthzService.isSelfAllowed',
    index=4,
    containing_service=None,
    input_type=_ISSELFALLOWED,
    output_type=_ISSELFALLOWED_RESPONSE,
    serialized_options=_b('\202\323\344\223\002\034\"\027/v1/authz/isSelfAllowed:\001*'),
  ),
  _descriptor.MethodDescriptor(
    name='getSelfAllowedResources',
    full_name='ai.verta.uac.AuthzService.getSelfAllowedResources',
    index=5,
    containing_service=None,
    input_type=_GETSELFALLOWEDRESOURCES,
    output_type=_GETSELFALLOWEDRESOURCES_RESPONSE,
    serialized_options=_b('\202\323\344\223\002&\"!/v1/authz/getSelfAllowedResources:\001*'),
  ),
  _descriptor.MethodDescriptor(
    name='getSelfDirectlyAllowedResources',
    full_name='ai.verta.uac.AuthzService.getSelfDirectlyAllowedResources',
    index=6,
    containing_service=None,
    input_type=_GETSELFALLOWEDRESOURCES,
    output_type=_GETSELFALLOWEDRESOURCES_RESPONSE,
    serialized_options=_b('\202\323\344\223\002.\")/v1/authz/getSelfDirectlyAllowedResources:\001*'),
  ),
  _descriptor.MethodDescriptor(
    name='getSelfAllowedActionsBatch',
    full_name='ai.verta.uac.AuthzService.getSelfAllowedActionsBatch',
    index=7,
    containing_service=None,
    input_type=_GETSELFALLOWEDACTIONSBATCH,
    output_type=_GETSELFALLOWEDACTIONSBATCH_RESPONSE,
    serialized_options=_b('\202\323\344\223\002)\"$/v1/authz/getSelfAllowedActionsBatch:\001*'),
  ),
])
_sym_db.RegisterServiceDescriptor(_AUTHZSERVICE)

DESCRIPTOR.services_by_name['AuthzService'] = _AUTHZSERVICE

# @@protoc_insertion_point(module_scope)

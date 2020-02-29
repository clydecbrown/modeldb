# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: protos/public/common/CommonService.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


from google.protobuf import struct_pb2 as google_dot_protobuf_dot_struct__pb2
from google.api import annotations_pb2 as google_dot_api_dot_annotations__pb2


DESCRIPTOR = _descriptor.FileDescriptor(
  name='protos/public/common/CommonService.proto',
  package='ai.verta.common',
  syntax='proto3',
  serialized_options=_b('P\001Z=github.com/VertaAI/modeldb/protos/gen/go/protos/public/common'),
  serialized_pb=_b('\n(protos/public/common/CommonService.proto\x12\x0f\x61i.verta.common\x1a\x1cgoogle/protobuf/struct.proto\x1a\x1cgoogle/api/annotations.proto\":\n\x0bTernaryEnum\"+\n\x07Ternary\x12\x0b\n\x07UNKNOWN\x10\x00\x12\x08\n\x04TRUE\x10\x01\x12\t\n\x05\x46\x41LSE\x10\x02\"|\n\x08KeyValue\x12\x0b\n\x03key\x18\x01 \x01(\t\x12%\n\x05value\x18\x02 \x01(\x0b\x32\x16.google.protobuf.Value\x12<\n\nvalue_type\x18\x03 \x01(\x0e\x32(.ai.verta.common.ValueTypeEnum.ValueType\"H\n\rValueTypeEnum\"7\n\tValueType\x12\n\n\x06STRING\x10\x00\x12\n\n\x06NUMBER\x10\x01\x12\x08\n\x04LIST\x10\x02\x12\x08\n\x04\x42LOB\x10\x03\"I\n\x14\x43ollaboratorTypeEnum\"1\n\x10\x43ollaboratorType\x12\r\n\tREAD_ONLY\x10\x00\x12\x0e\n\nREAD_WRITE\x10\x01\x42\x41P\x01Z=github.com/VertaAI/modeldb/protos/gen/go/protos/public/commonb\x06proto3')
  ,
  dependencies=[google_dot_protobuf_dot_struct__pb2.DESCRIPTOR,google_dot_api_dot_annotations__pb2.DESCRIPTOR,])



_TERNARYENUM_TERNARY = _descriptor.EnumDescriptor(
  name='Ternary',
  full_name='ai.verta.common.TernaryEnum.Ternary',
  filename=None,
  file=DESCRIPTOR,
  values=[
    _descriptor.EnumValueDescriptor(
      name='UNKNOWN', index=0, number=0,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='TRUE', index=1, number=1,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='FALSE', index=2, number=2,
      serialized_options=None,
      type=None),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=136,
  serialized_end=179,
)
_sym_db.RegisterEnumDescriptor(_TERNARYENUM_TERNARY)

_VALUETYPEENUM_VALUETYPE = _descriptor.EnumDescriptor(
  name='ValueType',
  full_name='ai.verta.common.ValueTypeEnum.ValueType',
  filename=None,
  file=DESCRIPTOR,
  values=[
    _descriptor.EnumValueDescriptor(
      name='STRING', index=0, number=0,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='NUMBER', index=1, number=1,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='LIST', index=2, number=2,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='BLOB', index=3, number=3,
      serialized_options=None,
      type=None),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=324,
  serialized_end=379,
)
_sym_db.RegisterEnumDescriptor(_VALUETYPEENUM_VALUETYPE)

_COLLABORATORTYPEENUM_COLLABORATORTYPE = _descriptor.EnumDescriptor(
  name='CollaboratorType',
  full_name='ai.verta.common.CollaboratorTypeEnum.CollaboratorType',
  filename=None,
  file=DESCRIPTOR,
  values=[
    _descriptor.EnumValueDescriptor(
      name='READ_ONLY', index=0, number=0,
      serialized_options=None,
      type=None),
    _descriptor.EnumValueDescriptor(
      name='READ_WRITE', index=1, number=1,
      serialized_options=None,
      type=None),
  ],
  containing_type=None,
  serialized_options=None,
  serialized_start=405,
  serialized_end=454,
)
_sym_db.RegisterEnumDescriptor(_COLLABORATORTYPEENUM_COLLABORATORTYPE)


_TERNARYENUM = _descriptor.Descriptor(
  name='TernaryEnum',
  full_name='ai.verta.common.TernaryEnum',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
    _TERNARYENUM_TERNARY,
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=121,
  serialized_end=179,
)


_KEYVALUE = _descriptor.Descriptor(
  name='KeyValue',
  full_name='ai.verta.common.KeyValue',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='key', full_name='ai.verta.common.KeyValue.key', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='value', full_name='ai.verta.common.KeyValue.value', index=1,
      number=2, type=11, cpp_type=10, label=1,
      has_default_value=False, default_value=None,
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='value_type', full_name='ai.verta.common.KeyValue.value_type', index=2,
      number=3, type=14, cpp_type=8, label=1,
      has_default_value=False, default_value=0,
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
  serialized_start=181,
  serialized_end=305,
)


_VALUETYPEENUM = _descriptor.Descriptor(
  name='ValueTypeEnum',
  full_name='ai.verta.common.ValueTypeEnum',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
    _VALUETYPEENUM_VALUETYPE,
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=307,
  serialized_end=379,
)


_COLLABORATORTYPEENUM = _descriptor.Descriptor(
  name='CollaboratorTypeEnum',
  full_name='ai.verta.common.CollaboratorTypeEnum',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
  ],
  extensions=[
  ],
  nested_types=[],
  enum_types=[
    _COLLABORATORTYPEENUM_COLLABORATORTYPE,
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=381,
  serialized_end=454,
)

_TERNARYENUM_TERNARY.containing_type = _TERNARYENUM
_KEYVALUE.fields_by_name['value'].message_type = google_dot_protobuf_dot_struct__pb2._VALUE
_KEYVALUE.fields_by_name['value_type'].enum_type = _VALUETYPEENUM_VALUETYPE
_VALUETYPEENUM_VALUETYPE.containing_type = _VALUETYPEENUM
_COLLABORATORTYPEENUM_COLLABORATORTYPE.containing_type = _COLLABORATORTYPEENUM
DESCRIPTOR.message_types_by_name['TernaryEnum'] = _TERNARYENUM
DESCRIPTOR.message_types_by_name['KeyValue'] = _KEYVALUE
DESCRIPTOR.message_types_by_name['ValueTypeEnum'] = _VALUETYPEENUM
DESCRIPTOR.message_types_by_name['CollaboratorTypeEnum'] = _COLLABORATORTYPEENUM
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

TernaryEnum = _reflection.GeneratedProtocolMessageType('TernaryEnum', (_message.Message,), dict(
  DESCRIPTOR = _TERNARYENUM,
  __module__ = 'protos.public.common.CommonService_pb2'
  # @@protoc_insertion_point(class_scope:ai.verta.common.TernaryEnum)
  ))
_sym_db.RegisterMessage(TernaryEnum)

KeyValue = _reflection.GeneratedProtocolMessageType('KeyValue', (_message.Message,), dict(
  DESCRIPTOR = _KEYVALUE,
  __module__ = 'protos.public.common.CommonService_pb2'
  # @@protoc_insertion_point(class_scope:ai.verta.common.KeyValue)
  ))
_sym_db.RegisterMessage(KeyValue)

ValueTypeEnum = _reflection.GeneratedProtocolMessageType('ValueTypeEnum', (_message.Message,), dict(
  DESCRIPTOR = _VALUETYPEENUM,
  __module__ = 'protos.public.common.CommonService_pb2'
  # @@protoc_insertion_point(class_scope:ai.verta.common.ValueTypeEnum)
  ))
_sym_db.RegisterMessage(ValueTypeEnum)

CollaboratorTypeEnum = _reflection.GeneratedProtocolMessageType('CollaboratorTypeEnum', (_message.Message,), dict(
  DESCRIPTOR = _COLLABORATORTYPEENUM,
  __module__ = 'protos.public.common.CommonService_pb2'
  # @@protoc_insertion_point(class_scope:ai.verta.common.CollaboratorTypeEnum)
  ))
_sym_db.RegisterMessage(CollaboratorTypeEnum)


DESCRIPTOR._options = None
# @@protoc_insertion_point(module_scope)

# -*- coding: utf-8 -*-
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: protos/public/artifactstore/ArtifactStore.proto

import sys
_b=sys.version_info[0]<3 and (lambda x:x) or (lambda x:x.encode('latin1'))
from google.protobuf import descriptor as _descriptor
from google.protobuf import message as _message
from google.protobuf import reflection as _reflection
from google.protobuf import symbol_database as _symbol_database
# @@protoc_insertion_point(imports)

_sym_db = _symbol_database.Default()


from google.api import annotations_pb2 as google_dot_api_dot_annotations__pb2


DESCRIPTOR = _descriptor.FileDescriptor(
  name='protos/public/artifactstore/ArtifactStore.proto',
  package='ai.verta.artifactstore',
  syntax='proto3',
  serialized_options=_b('P\001ZDgithub.com/VertaAI/modeldb/protos/gen/go/protos/public/artifactstore'),
  serialized_pb=_b('\n/protos/public/artifactstore/ArtifactStore.proto\x12\x16\x61i.verta.artifactstore\x1a\x1cgoogle/api/annotations.proto\"o\n\rStoreArtifact\x12\x0b\n\x03key\x18\x01 \x01(\t\x12\x0c\n\x04path\x18\x02 \x01(\t\x1a\x43\n\x08Response\x12\x1a\n\x12\x61rtifact_store_key\x18\x01 \x01(\t\x12\x1b\n\x13\x61rtifact_store_path\x18\x02 \x01(\t\"x\n\x17StoreArtifactWithStream\x12\x0b\n\x03key\x18\x01 \x01(\t\x12\x13\n\x0b\x63lient_file\x18\x02 \x01(\x0c\x1a;\n\x08Response\x12\x16\n\x0e\x63loud_file_key\x18\x01 \x01(\t\x12\x17\n\x0f\x63loud_file_path\x18\x02 \x01(\t\"8\n\x0bGetArtifact\x12\x0b\n\x03key\x18\x01 \x01(\t\x1a\x1c\n\x08Response\x12\x10\n\x08\x63ontents\x18\x01 \x01(\x0c\"9\n\x0e\x44\x65leteArtifact\x12\x0b\n\x03key\x18\x01 \x01(\t\x1a\x1a\n\x08Response\x12\x0e\n\x06status\x18\x01 \x01(\x08\x32\xf0\x04\n\rArtifactStore\x12\x8d\x01\n\rstoreArtifact\x12%.ai.verta.artifactstore.StoreArtifact\x1a..ai.verta.artifactstore.StoreArtifact.Response\"%\x82\xd3\xe4\x93\x02\x1f\"\x1a/v1/artifact/storeArtifact:\x01*\x12\xb5\x01\n\x17storeArtifactWithStream\x12/.ai.verta.artifactstore.StoreArtifactWithStream\x1a\x38.ai.verta.artifactstore.StoreArtifactWithStream.Response\"/\x82\xd3\xe4\x93\x02)\"$/v1/artifact/storeArtifactWithStream:\x01*\x12\x82\x01\n\x0bgetArtifact\x12#.ai.verta.artifactstore.GetArtifact\x1a,.ai.verta.artifactstore.GetArtifact.Response\" \x82\xd3\xe4\x93\x02\x1a\x12\x18/v1/artifact/getArtifact\x12\x91\x01\n\x0e\x64\x65leteArtifact\x12&.ai.verta.artifactstore.DeleteArtifact\x1a/.ai.verta.artifactstore.DeleteArtifact.Response\"&\x82\xd3\xe4\x93\x02 \"\x1b/v1/artifact/deleteArtifact:\x01*BHP\x01ZDgithub.com/VertaAI/modeldb/protos/gen/go/protos/public/artifactstoreb\x06proto3')
  ,
  dependencies=[google_dot_api_dot_annotations__pb2.DESCRIPTOR,])




_STOREARTIFACT_RESPONSE = _descriptor.Descriptor(
  name='Response',
  full_name='ai.verta.artifactstore.StoreArtifact.Response',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='artifact_store_key', full_name='ai.verta.artifactstore.StoreArtifact.Response.artifact_store_key', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='artifact_store_path', full_name='ai.verta.artifactstore.StoreArtifact.Response.artifact_store_path', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
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
  serialized_start=149,
  serialized_end=216,
)

_STOREARTIFACT = _descriptor.Descriptor(
  name='StoreArtifact',
  full_name='ai.verta.artifactstore.StoreArtifact',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='key', full_name='ai.verta.artifactstore.StoreArtifact.key', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='path', full_name='ai.verta.artifactstore.StoreArtifact.path', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[_STOREARTIFACT_RESPONSE, ],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=105,
  serialized_end=216,
)


_STOREARTIFACTWITHSTREAM_RESPONSE = _descriptor.Descriptor(
  name='Response',
  full_name='ai.verta.artifactstore.StoreArtifactWithStream.Response',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='cloud_file_key', full_name='ai.verta.artifactstore.StoreArtifactWithStream.Response.cloud_file_key', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='cloud_file_path', full_name='ai.verta.artifactstore.StoreArtifactWithStream.Response.cloud_file_path', index=1,
      number=2, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
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
  serialized_start=279,
  serialized_end=338,
)

_STOREARTIFACTWITHSTREAM = _descriptor.Descriptor(
  name='StoreArtifactWithStream',
  full_name='ai.verta.artifactstore.StoreArtifactWithStream',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='key', full_name='ai.verta.artifactstore.StoreArtifactWithStream.key', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
    _descriptor.FieldDescriptor(
      name='client_file', full_name='ai.verta.artifactstore.StoreArtifactWithStream.client_file', index=1,
      number=2, type=12, cpp_type=9, label=1,
      has_default_value=False, default_value=_b(""),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[_STOREARTIFACTWITHSTREAM_RESPONSE, ],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=218,
  serialized_end=338,
)


_GETARTIFACT_RESPONSE = _descriptor.Descriptor(
  name='Response',
  full_name='ai.verta.artifactstore.GetArtifact.Response',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='contents', full_name='ai.verta.artifactstore.GetArtifact.Response.contents', index=0,
      number=1, type=12, cpp_type=9, label=1,
      has_default_value=False, default_value=_b(""),
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
  serialized_start=368,
  serialized_end=396,
)

_GETARTIFACT = _descriptor.Descriptor(
  name='GetArtifact',
  full_name='ai.verta.artifactstore.GetArtifact',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='key', full_name='ai.verta.artifactstore.GetArtifact.key', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[_GETARTIFACT_RESPONSE, ],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=340,
  serialized_end=396,
)


_DELETEARTIFACT_RESPONSE = _descriptor.Descriptor(
  name='Response',
  full_name='ai.verta.artifactstore.DeleteArtifact.Response',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='status', full_name='ai.verta.artifactstore.DeleteArtifact.Response.status', index=0,
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
  serialized_start=429,
  serialized_end=455,
)

_DELETEARTIFACT = _descriptor.Descriptor(
  name='DeleteArtifact',
  full_name='ai.verta.artifactstore.DeleteArtifact',
  filename=None,
  file=DESCRIPTOR,
  containing_type=None,
  fields=[
    _descriptor.FieldDescriptor(
      name='key', full_name='ai.verta.artifactstore.DeleteArtifact.key', index=0,
      number=1, type=9, cpp_type=9, label=1,
      has_default_value=False, default_value=_b("").decode('utf-8'),
      message_type=None, enum_type=None, containing_type=None,
      is_extension=False, extension_scope=None,
      serialized_options=None, file=DESCRIPTOR),
  ],
  extensions=[
  ],
  nested_types=[_DELETEARTIFACT_RESPONSE, ],
  enum_types=[
  ],
  serialized_options=None,
  is_extendable=False,
  syntax='proto3',
  extension_ranges=[],
  oneofs=[
  ],
  serialized_start=398,
  serialized_end=455,
)

_STOREARTIFACT_RESPONSE.containing_type = _STOREARTIFACT
_STOREARTIFACTWITHSTREAM_RESPONSE.containing_type = _STOREARTIFACTWITHSTREAM
_GETARTIFACT_RESPONSE.containing_type = _GETARTIFACT
_DELETEARTIFACT_RESPONSE.containing_type = _DELETEARTIFACT
DESCRIPTOR.message_types_by_name['StoreArtifact'] = _STOREARTIFACT
DESCRIPTOR.message_types_by_name['StoreArtifactWithStream'] = _STOREARTIFACTWITHSTREAM
DESCRIPTOR.message_types_by_name['GetArtifact'] = _GETARTIFACT
DESCRIPTOR.message_types_by_name['DeleteArtifact'] = _DELETEARTIFACT
_sym_db.RegisterFileDescriptor(DESCRIPTOR)

StoreArtifact = _reflection.GeneratedProtocolMessageType('StoreArtifact', (_message.Message,), dict(

  Response = _reflection.GeneratedProtocolMessageType('Response', (_message.Message,), dict(
    DESCRIPTOR = _STOREARTIFACT_RESPONSE,
    __module__ = 'protos.public.artifactstore.ArtifactStore_pb2'
    # @@protoc_insertion_point(class_scope:ai.verta.artifactstore.StoreArtifact.Response)
    ))
  ,
  DESCRIPTOR = _STOREARTIFACT,
  __module__ = 'protos.public.artifactstore.ArtifactStore_pb2'
  # @@protoc_insertion_point(class_scope:ai.verta.artifactstore.StoreArtifact)
  ))
_sym_db.RegisterMessage(StoreArtifact)
_sym_db.RegisterMessage(StoreArtifact.Response)

StoreArtifactWithStream = _reflection.GeneratedProtocolMessageType('StoreArtifactWithStream', (_message.Message,), dict(

  Response = _reflection.GeneratedProtocolMessageType('Response', (_message.Message,), dict(
    DESCRIPTOR = _STOREARTIFACTWITHSTREAM_RESPONSE,
    __module__ = 'protos.public.artifactstore.ArtifactStore_pb2'
    # @@protoc_insertion_point(class_scope:ai.verta.artifactstore.StoreArtifactWithStream.Response)
    ))
  ,
  DESCRIPTOR = _STOREARTIFACTWITHSTREAM,
  __module__ = 'protos.public.artifactstore.ArtifactStore_pb2'
  # @@protoc_insertion_point(class_scope:ai.verta.artifactstore.StoreArtifactWithStream)
  ))
_sym_db.RegisterMessage(StoreArtifactWithStream)
_sym_db.RegisterMessage(StoreArtifactWithStream.Response)

GetArtifact = _reflection.GeneratedProtocolMessageType('GetArtifact', (_message.Message,), dict(

  Response = _reflection.GeneratedProtocolMessageType('Response', (_message.Message,), dict(
    DESCRIPTOR = _GETARTIFACT_RESPONSE,
    __module__ = 'protos.public.artifactstore.ArtifactStore_pb2'
    # @@protoc_insertion_point(class_scope:ai.verta.artifactstore.GetArtifact.Response)
    ))
  ,
  DESCRIPTOR = _GETARTIFACT,
  __module__ = 'protos.public.artifactstore.ArtifactStore_pb2'
  # @@protoc_insertion_point(class_scope:ai.verta.artifactstore.GetArtifact)
  ))
_sym_db.RegisterMessage(GetArtifact)
_sym_db.RegisterMessage(GetArtifact.Response)

DeleteArtifact = _reflection.GeneratedProtocolMessageType('DeleteArtifact', (_message.Message,), dict(

  Response = _reflection.GeneratedProtocolMessageType('Response', (_message.Message,), dict(
    DESCRIPTOR = _DELETEARTIFACT_RESPONSE,
    __module__ = 'protos.public.artifactstore.ArtifactStore_pb2'
    # @@protoc_insertion_point(class_scope:ai.verta.artifactstore.DeleteArtifact.Response)
    ))
  ,
  DESCRIPTOR = _DELETEARTIFACT,
  __module__ = 'protos.public.artifactstore.ArtifactStore_pb2'
  # @@protoc_insertion_point(class_scope:ai.verta.artifactstore.DeleteArtifact)
  ))
_sym_db.RegisterMessage(DeleteArtifact)
_sym_db.RegisterMessage(DeleteArtifact.Response)


DESCRIPTOR._options = None

_ARTIFACTSTORE = _descriptor.ServiceDescriptor(
  name='ArtifactStore',
  full_name='ai.verta.artifactstore.ArtifactStore',
  file=DESCRIPTOR,
  index=0,
  serialized_options=None,
  serialized_start=458,
  serialized_end=1082,
  methods=[
  _descriptor.MethodDescriptor(
    name='storeArtifact',
    full_name='ai.verta.artifactstore.ArtifactStore.storeArtifact',
    index=0,
    containing_service=None,
    input_type=_STOREARTIFACT,
    output_type=_STOREARTIFACT_RESPONSE,
    serialized_options=_b('\202\323\344\223\002\037\"\032/v1/artifact/storeArtifact:\001*'),
  ),
  _descriptor.MethodDescriptor(
    name='storeArtifactWithStream',
    full_name='ai.verta.artifactstore.ArtifactStore.storeArtifactWithStream',
    index=1,
    containing_service=None,
    input_type=_STOREARTIFACTWITHSTREAM,
    output_type=_STOREARTIFACTWITHSTREAM_RESPONSE,
    serialized_options=_b('\202\323\344\223\002)\"$/v1/artifact/storeArtifactWithStream:\001*'),
  ),
  _descriptor.MethodDescriptor(
    name='getArtifact',
    full_name='ai.verta.artifactstore.ArtifactStore.getArtifact',
    index=2,
    containing_service=None,
    input_type=_GETARTIFACT,
    output_type=_GETARTIFACT_RESPONSE,
    serialized_options=_b('\202\323\344\223\002\032\022\030/v1/artifact/getArtifact'),
  ),
  _descriptor.MethodDescriptor(
    name='deleteArtifact',
    full_name='ai.verta.artifactstore.ArtifactStore.deleteArtifact',
    index=3,
    containing_service=None,
    input_type=_DELETEARTIFACT,
    output_type=_DELETEARTIFACT_RESPONSE,
    serialized_options=_b('\202\323\344\223\002 \"\033/v1/artifact/deleteArtifact:\001*'),
  ),
])
_sym_db.RegisterServiceDescriptor(_ARTIFACTSTORE)

DESCRIPTOR.services_by_name['ArtifactStore'] = _ARTIFACTSTORE

# @@protoc_insertion_point(module_scope)

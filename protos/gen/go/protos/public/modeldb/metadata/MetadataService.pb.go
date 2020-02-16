// Code generated by protoc-gen-go. DO NOT EDIT.
// source: protos/public/modeldb/metadata/MetadataService.proto

package metadata

import (
	context "context"
	fmt "fmt"
	proto "github.com/golang/protobuf/proto"
	_ "google.golang.org/genproto/googleapis/api/annotations"
	grpc "google.golang.org/grpc"
	codes "google.golang.org/grpc/codes"
	status "google.golang.org/grpc/status"
	math "math"
)

// Reference imports to suppress errors if they are not otherwise used.
var _ = proto.Marshal
var _ = fmt.Errorf
var _ = math.Inf

// This is a compile-time assertion to ensure that this generated file
// is compatible with the proto package it is being compiled against.
// A compilation error at this line likely means your copy of the
// proto package needs to be updated.
const _ = proto.ProtoPackageIsVersion3 // please upgrade the proto package

type IDTypeEnum_IDType int32

const (
	IDTypeEnum_UNKNOWN               IDTypeEnum_IDType = 0
	IDTypeEnum_VERSIONING_REPOSITORY IDTypeEnum_IDType = 1
	IDTypeEnum_VERSIONING_COMMIT     IDTypeEnum_IDType = 2
)

var IDTypeEnum_IDType_name = map[int32]string{
	0: "UNKNOWN",
	1: "VERSIONING_REPOSITORY",
	2: "VERSIONING_COMMIT",
}

var IDTypeEnum_IDType_value = map[string]int32{
	"UNKNOWN":               0,
	"VERSIONING_REPOSITORY": 1,
	"VERSIONING_COMMIT":     2,
}

func (x IDTypeEnum_IDType) String() string {
	return proto.EnumName(IDTypeEnum_IDType_name, int32(x))
}

func (IDTypeEnum_IDType) EnumDescriptor() ([]byte, []int) {
	return fileDescriptor_146adf422da79009, []int{0, 0}
}

type IDTypeEnum struct {
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *IDTypeEnum) Reset()         { *m = IDTypeEnum{} }
func (m *IDTypeEnum) String() string { return proto.CompactTextString(m) }
func (*IDTypeEnum) ProtoMessage()    {}
func (*IDTypeEnum) Descriptor() ([]byte, []int) {
	return fileDescriptor_146adf422da79009, []int{0}
}

func (m *IDTypeEnum) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_IDTypeEnum.Unmarshal(m, b)
}
func (m *IDTypeEnum) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_IDTypeEnum.Marshal(b, m, deterministic)
}
func (m *IDTypeEnum) XXX_Merge(src proto.Message) {
	xxx_messageInfo_IDTypeEnum.Merge(m, src)
}
func (m *IDTypeEnum) XXX_Size() int {
	return xxx_messageInfo_IDTypeEnum.Size(m)
}
func (m *IDTypeEnum) XXX_DiscardUnknown() {
	xxx_messageInfo_IDTypeEnum.DiscardUnknown(m)
}

var xxx_messageInfo_IDTypeEnum proto.InternalMessageInfo

type IdentificationType struct {
	IdType IDTypeEnum_IDType `protobuf:"varint,1,opt,name=id_type,json=idType,proto3,enum=ai.verta.modeldb.metadata.IDTypeEnum_IDType" json:"id_type,omitempty"`
	// Types that are valid to be assigned to Id:
	//	*IdentificationType_Code
	//	*IdentificationType_Uuid
	Id                   isIdentificationType_Id `protobuf_oneof:"id"`
	XXX_NoUnkeyedLiteral struct{}                `json:"-"`
	XXX_unrecognized     []byte                  `json:"-"`
	XXX_sizecache        int32                   `json:"-"`
}

func (m *IdentificationType) Reset()         { *m = IdentificationType{} }
func (m *IdentificationType) String() string { return proto.CompactTextString(m) }
func (*IdentificationType) ProtoMessage()    {}
func (*IdentificationType) Descriptor() ([]byte, []int) {
	return fileDescriptor_146adf422da79009, []int{1}
}

func (m *IdentificationType) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_IdentificationType.Unmarshal(m, b)
}
func (m *IdentificationType) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_IdentificationType.Marshal(b, m, deterministic)
}
func (m *IdentificationType) XXX_Merge(src proto.Message) {
	xxx_messageInfo_IdentificationType.Merge(m, src)
}
func (m *IdentificationType) XXX_Size() int {
	return xxx_messageInfo_IdentificationType.Size(m)
}
func (m *IdentificationType) XXX_DiscardUnknown() {
	xxx_messageInfo_IdentificationType.DiscardUnknown(m)
}

var xxx_messageInfo_IdentificationType proto.InternalMessageInfo

func (m *IdentificationType) GetIdType() IDTypeEnum_IDType {
	if m != nil {
		return m.IdType
	}
	return IDTypeEnum_UNKNOWN
}

type isIdentificationType_Id interface {
	isIdentificationType_Id()
}

type IdentificationType_Code struct {
	Code uint64 `protobuf:"varint,2,opt,name=code,proto3,oneof"`
}

type IdentificationType_Uuid struct {
	Uuid string `protobuf:"bytes,3,opt,name=uuid,proto3,oneof"`
}

func (*IdentificationType_Code) isIdentificationType_Id() {}

func (*IdentificationType_Uuid) isIdentificationType_Id() {}

func (m *IdentificationType) GetId() isIdentificationType_Id {
	if m != nil {
		return m.Id
	}
	return nil
}

func (m *IdentificationType) GetCode() uint64 {
	if x, ok := m.GetId().(*IdentificationType_Code); ok {
		return x.Code
	}
	return 0
}

func (m *IdentificationType) GetUuid() string {
	if x, ok := m.GetId().(*IdentificationType_Uuid); ok {
		return x.Uuid
	}
	return ""
}

// XXX_OneofWrappers is for the internal use of the proto package.
func (*IdentificationType) XXX_OneofWrappers() []interface{} {
	return []interface{}{
		(*IdentificationType_Code)(nil),
		(*IdentificationType_Uuid)(nil),
	}
}

type GetLabelsRequest struct {
	// If only id_type is provided, gather from all of such sources
	Id                   *IdentificationType `protobuf:"bytes,1,opt,name=id,proto3" json:"id,omitempty"`
	XXX_NoUnkeyedLiteral struct{}            `json:"-"`
	XXX_unrecognized     []byte              `json:"-"`
	XXX_sizecache        int32               `json:"-"`
}

func (m *GetLabelsRequest) Reset()         { *m = GetLabelsRequest{} }
func (m *GetLabelsRequest) String() string { return proto.CompactTextString(m) }
func (*GetLabelsRequest) ProtoMessage()    {}
func (*GetLabelsRequest) Descriptor() ([]byte, []int) {
	return fileDescriptor_146adf422da79009, []int{2}
}

func (m *GetLabelsRequest) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_GetLabelsRequest.Unmarshal(m, b)
}
func (m *GetLabelsRequest) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_GetLabelsRequest.Marshal(b, m, deterministic)
}
func (m *GetLabelsRequest) XXX_Merge(src proto.Message) {
	xxx_messageInfo_GetLabelsRequest.Merge(m, src)
}
func (m *GetLabelsRequest) XXX_Size() int {
	return xxx_messageInfo_GetLabelsRequest.Size(m)
}
func (m *GetLabelsRequest) XXX_DiscardUnknown() {
	xxx_messageInfo_GetLabelsRequest.DiscardUnknown(m)
}

var xxx_messageInfo_GetLabelsRequest proto.InternalMessageInfo

func (m *GetLabelsRequest) GetId() *IdentificationType {
	if m != nil {
		return m.Id
	}
	return nil
}

type GetLabelsRequest_Response struct {
	Labels               []string `protobuf:"bytes,1,rep,name=labels,proto3" json:"labels,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *GetLabelsRequest_Response) Reset()         { *m = GetLabelsRequest_Response{} }
func (m *GetLabelsRequest_Response) String() string { return proto.CompactTextString(m) }
func (*GetLabelsRequest_Response) ProtoMessage()    {}
func (*GetLabelsRequest_Response) Descriptor() ([]byte, []int) {
	return fileDescriptor_146adf422da79009, []int{2, 0}
}

func (m *GetLabelsRequest_Response) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_GetLabelsRequest_Response.Unmarshal(m, b)
}
func (m *GetLabelsRequest_Response) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_GetLabelsRequest_Response.Marshal(b, m, deterministic)
}
func (m *GetLabelsRequest_Response) XXX_Merge(src proto.Message) {
	xxx_messageInfo_GetLabelsRequest_Response.Merge(m, src)
}
func (m *GetLabelsRequest_Response) XXX_Size() int {
	return xxx_messageInfo_GetLabelsRequest_Response.Size(m)
}
func (m *GetLabelsRequest_Response) XXX_DiscardUnknown() {
	xxx_messageInfo_GetLabelsRequest_Response.DiscardUnknown(m)
}

var xxx_messageInfo_GetLabelsRequest_Response proto.InternalMessageInfo

func (m *GetLabelsRequest_Response) GetLabels() []string {
	if m != nil {
		return m.Labels
	}
	return nil
}

type AddLabelsRequest struct {
	Id                   *IdentificationType `protobuf:"bytes,1,opt,name=id,proto3" json:"id,omitempty"`
	Labels               []string            `protobuf:"bytes,2,rep,name=labels,proto3" json:"labels,omitempty"`
	XXX_NoUnkeyedLiteral struct{}            `json:"-"`
	XXX_unrecognized     []byte              `json:"-"`
	XXX_sizecache        int32               `json:"-"`
}

func (m *AddLabelsRequest) Reset()         { *m = AddLabelsRequest{} }
func (m *AddLabelsRequest) String() string { return proto.CompactTextString(m) }
func (*AddLabelsRequest) ProtoMessage()    {}
func (*AddLabelsRequest) Descriptor() ([]byte, []int) {
	return fileDescriptor_146adf422da79009, []int{3}
}

func (m *AddLabelsRequest) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_AddLabelsRequest.Unmarshal(m, b)
}
func (m *AddLabelsRequest) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_AddLabelsRequest.Marshal(b, m, deterministic)
}
func (m *AddLabelsRequest) XXX_Merge(src proto.Message) {
	xxx_messageInfo_AddLabelsRequest.Merge(m, src)
}
func (m *AddLabelsRequest) XXX_Size() int {
	return xxx_messageInfo_AddLabelsRequest.Size(m)
}
func (m *AddLabelsRequest) XXX_DiscardUnknown() {
	xxx_messageInfo_AddLabelsRequest.DiscardUnknown(m)
}

var xxx_messageInfo_AddLabelsRequest proto.InternalMessageInfo

func (m *AddLabelsRequest) GetId() *IdentificationType {
	if m != nil {
		return m.Id
	}
	return nil
}

func (m *AddLabelsRequest) GetLabels() []string {
	if m != nil {
		return m.Labels
	}
	return nil
}

type AddLabelsRequest_Response struct {
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *AddLabelsRequest_Response) Reset()         { *m = AddLabelsRequest_Response{} }
func (m *AddLabelsRequest_Response) String() string { return proto.CompactTextString(m) }
func (*AddLabelsRequest_Response) ProtoMessage()    {}
func (*AddLabelsRequest_Response) Descriptor() ([]byte, []int) {
	return fileDescriptor_146adf422da79009, []int{3, 0}
}

func (m *AddLabelsRequest_Response) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_AddLabelsRequest_Response.Unmarshal(m, b)
}
func (m *AddLabelsRequest_Response) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_AddLabelsRequest_Response.Marshal(b, m, deterministic)
}
func (m *AddLabelsRequest_Response) XXX_Merge(src proto.Message) {
	xxx_messageInfo_AddLabelsRequest_Response.Merge(m, src)
}
func (m *AddLabelsRequest_Response) XXX_Size() int {
	return xxx_messageInfo_AddLabelsRequest_Response.Size(m)
}
func (m *AddLabelsRequest_Response) XXX_DiscardUnknown() {
	xxx_messageInfo_AddLabelsRequest_Response.DiscardUnknown(m)
}

var xxx_messageInfo_AddLabelsRequest_Response proto.InternalMessageInfo

type DeleteLabelsRequest struct {
	Id                   *IdentificationType `protobuf:"bytes,1,opt,name=id,proto3" json:"id,omitempty"`
	Labels               []string            `protobuf:"bytes,2,rep,name=labels,proto3" json:"labels,omitempty"`
	XXX_NoUnkeyedLiteral struct{}            `json:"-"`
	XXX_unrecognized     []byte              `json:"-"`
	XXX_sizecache        int32               `json:"-"`
}

func (m *DeleteLabelsRequest) Reset()         { *m = DeleteLabelsRequest{} }
func (m *DeleteLabelsRequest) String() string { return proto.CompactTextString(m) }
func (*DeleteLabelsRequest) ProtoMessage()    {}
func (*DeleteLabelsRequest) Descriptor() ([]byte, []int) {
	return fileDescriptor_146adf422da79009, []int{4}
}

func (m *DeleteLabelsRequest) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_DeleteLabelsRequest.Unmarshal(m, b)
}
func (m *DeleteLabelsRequest) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_DeleteLabelsRequest.Marshal(b, m, deterministic)
}
func (m *DeleteLabelsRequest) XXX_Merge(src proto.Message) {
	xxx_messageInfo_DeleteLabelsRequest.Merge(m, src)
}
func (m *DeleteLabelsRequest) XXX_Size() int {
	return xxx_messageInfo_DeleteLabelsRequest.Size(m)
}
func (m *DeleteLabelsRequest) XXX_DiscardUnknown() {
	xxx_messageInfo_DeleteLabelsRequest.DiscardUnknown(m)
}

var xxx_messageInfo_DeleteLabelsRequest proto.InternalMessageInfo

func (m *DeleteLabelsRequest) GetId() *IdentificationType {
	if m != nil {
		return m.Id
	}
	return nil
}

func (m *DeleteLabelsRequest) GetLabels() []string {
	if m != nil {
		return m.Labels
	}
	return nil
}

type DeleteLabelsRequest_Response struct {
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *DeleteLabelsRequest_Response) Reset()         { *m = DeleteLabelsRequest_Response{} }
func (m *DeleteLabelsRequest_Response) String() string { return proto.CompactTextString(m) }
func (*DeleteLabelsRequest_Response) ProtoMessage()    {}
func (*DeleteLabelsRequest_Response) Descriptor() ([]byte, []int) {
	return fileDescriptor_146adf422da79009, []int{4, 0}
}

func (m *DeleteLabelsRequest_Response) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_DeleteLabelsRequest_Response.Unmarshal(m, b)
}
func (m *DeleteLabelsRequest_Response) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_DeleteLabelsRequest_Response.Marshal(b, m, deterministic)
}
func (m *DeleteLabelsRequest_Response) XXX_Merge(src proto.Message) {
	xxx_messageInfo_DeleteLabelsRequest_Response.Merge(m, src)
}
func (m *DeleteLabelsRequest_Response) XXX_Size() int {
	return xxx_messageInfo_DeleteLabelsRequest_Response.Size(m)
}
func (m *DeleteLabelsRequest_Response) XXX_DiscardUnknown() {
	xxx_messageInfo_DeleteLabelsRequest_Response.DiscardUnknown(m)
}

var xxx_messageInfo_DeleteLabelsRequest_Response proto.InternalMessageInfo

func init() {
	proto.RegisterEnum("ai.verta.modeldb.metadata.IDTypeEnum_IDType", IDTypeEnum_IDType_name, IDTypeEnum_IDType_value)
	proto.RegisterType((*IDTypeEnum)(nil), "ai.verta.modeldb.metadata.IDTypeEnum")
	proto.RegisterType((*IdentificationType)(nil), "ai.verta.modeldb.metadata.IdentificationType")
	proto.RegisterType((*GetLabelsRequest)(nil), "ai.verta.modeldb.metadata.GetLabelsRequest")
	proto.RegisterType((*GetLabelsRequest_Response)(nil), "ai.verta.modeldb.metadata.GetLabelsRequest.Response")
	proto.RegisterType((*AddLabelsRequest)(nil), "ai.verta.modeldb.metadata.AddLabelsRequest")
	proto.RegisterType((*AddLabelsRequest_Response)(nil), "ai.verta.modeldb.metadata.AddLabelsRequest.Response")
	proto.RegisterType((*DeleteLabelsRequest)(nil), "ai.verta.modeldb.metadata.DeleteLabelsRequest")
	proto.RegisterType((*DeleteLabelsRequest_Response)(nil), "ai.verta.modeldb.metadata.DeleteLabelsRequest.Response")
}

func init() {
	proto.RegisterFile("protos/public/modeldb/metadata/MetadataService.proto", fileDescriptor_146adf422da79009)
}

var fileDescriptor_146adf422da79009 = []byte{
	// 505 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0xff, 0xbc, 0x94, 0xcf, 0x6f, 0x12, 0x41,
	0x14, 0xc7, 0x3b, 0x0b, 0xa1, 0xf2, 0x6a, 0x14, 0xa7, 0x62, 0xe8, 0x6a, 0x0c, 0xd9, 0x13, 0x41,
	0xdd, 0x89, 0xd8, 0xc4, 0xa4, 0x89, 0x87, 0xd6, 0x12, 0xdc, 0x54, 0xa0, 0x59, 0x68, 0x8d, 0x5e,
	0x9a, 0x85, 0x79, 0xae, 0x93, 0x2c, 0x3b, 0x2b, 0x3b, 0x4b, 0xec, 0xd5, 0xab, 0xd1, 0x8b, 0x07,
	0xff, 0x27, 0xaf, 0xfe, 0x0b, 0xfe, 0x21, 0x66, 0x87, 0x15, 0x90, 0xd6, 0x4d, 0x9a, 0x18, 0x6f,
	0xf3, 0xe6, 0xfd, 0xf8, 0x7e, 0x86, 0x2f, 0xfb, 0x60, 0x37, 0x9a, 0x4a, 0x25, 0x63, 0x16, 0x25,
	0xa3, 0x40, 0x8c, 0xd9, 0x44, 0x72, 0x0c, 0xf8, 0x88, 0x4d, 0x50, 0x79, 0xdc, 0x53, 0x1e, 0xeb,
	0x66, 0x87, 0x01, 0x4e, 0x67, 0x62, 0x8c, 0xb6, 0x2e, 0xa7, 0x3b, 0x9e, 0xb0, 0x67, 0x38, 0x55,
	0x9e, 0x9d, 0x35, 0xd8, 0xbf, 0x1b, 0xcc, 0x7b, 0xbe, 0x94, 0x7e, 0x80, 0xcc, 0x8b, 0x04, 0xf3,
	0xc2, 0x50, 0x2a, 0x4f, 0x09, 0x19, 0xc6, 0xf3, 0x46, 0xeb, 0x04, 0xc0, 0x39, 0x1c, 0x9e, 0x47,
	0xd8, 0x0e, 0x93, 0x89, 0xd5, 0x81, 0xd2, 0x3c, 0xa2, 0x5b, 0xb0, 0x79, 0xd2, 0x3b, 0xea, 0xf5,
	0x5f, 0xf5, 0x2a, 0x1b, 0x74, 0x07, 0xaa, 0xa7, 0x6d, 0x77, 0xe0, 0xf4, 0x7b, 0x4e, 0xaf, 0x73,
	0xe6, 0xb6, 0x8f, 0xfb, 0x03, 0x67, 0xd8, 0x77, 0x5f, 0x57, 0x08, 0xad, 0xc2, 0xad, 0x95, 0xd4,
	0xf3, 0x7e, 0xb7, 0xeb, 0x0c, 0x2b, 0x86, 0xf5, 0x99, 0x00, 0x75, 0x38, 0x86, 0x4a, 0xbc, 0x15,
	0x63, 0x2d, 0xa8, 0xa7, 0xb6, 0x61, 0x53, 0xf0, 0x33, 0x75, 0x1e, 0x61, 0x8d, 0xd4, 0x49, 0xe3,
	0x46, 0xeb, 0xa1, 0xfd, 0x57, 0x70, 0x7b, 0xc9, 0x95, 0x1d, 0xdd, 0x92, 0xe0, 0x7a, 0xcc, 0x6d,
	0x28, 0x8e, 0x25, 0xc7, 0x9a, 0x51, 0x27, 0x8d, 0xe2, 0x8b, 0x0d, 0x57, 0x47, 0xe9, 0x6d, 0x92,
	0x08, 0x5e, 0x2b, 0xd4, 0x49, 0xa3, 0x9c, 0xde, 0xa6, 0xd1, 0x41, 0x11, 0x0c, 0xc1, 0xad, 0x04,
	0x2a, 0x1d, 0x54, 0x2f, 0xbd, 0x11, 0x06, 0xb1, 0x8b, 0xef, 0x13, 0x8c, 0x15, 0x7d, 0x96, 0x66,
	0x34, 0xc7, 0x56, 0xeb, 0x51, 0x1e, 0xc7, 0x85, 0x77, 0xb8, 0x86, 0xe0, 0xa6, 0x05, 0xd7, 0x5c,
	0x8c, 0x23, 0x19, 0xc6, 0x48, 0xef, 0x40, 0x29, 0xd0, 0xb3, 0x6b, 0xa4, 0x5e, 0x68, 0x94, 0xdd,
	0x2c, 0x4a, 0x65, 0xf7, 0x39, 0xff, 0x97, 0xb2, 0x2b, 0x52, 0xc6, 0xaa, 0x94, 0x09, 0x4b, 0x1c,
	0xeb, 0x03, 0x6c, 0x1f, 0x62, 0x80, 0x0a, 0xff, 0xb7, 0x72, 0xeb, 0x7b, 0x01, 0x6e, 0xae, 0xfd,
	0x43, 0xe9, 0x27, 0x02, 0xe5, 0xc5, 0x8f, 0x4f, 0x1f, 0xe4, 0x08, 0xaf, 0x5b, 0x64, 0xee, 0x5e,
	0xa1, 0xd8, 0x5e, 0x3c, 0xff, 0xee, 0xc7, 0x1f, 0x3f, 0xbf, 0x1a, 0x55, 0xba, 0xcd, 0x66, 0x8f,
	0x97, 0x1f, 0xce, 0x9c, 0x96, 0x7e, 0x21, 0x50, 0x5e, 0x78, 0x92, 0x4b, 0xb3, 0xee, 0x5c, 0x2e,
	0xcd, 0x7a, 0xf1, 0x92, 0xe6, 0xbe, 0xa6, 0xa9, 0x99, 0x97, 0xd1, 0xec, 0x91, 0x26, 0xfd, 0x46,
	0xe0, 0xfa, 0xaa, 0x5b, 0xd4, 0xce, 0x91, 0xb9, 0xc4, 0x56, 0xf3, 0xe9, 0xd5, 0xea, 0x2f, 0x90,
	0x35, 0xff, 0x24, 0xe3, 0xba, 0x65, 0x8f, 0x34, 0x0f, 0x8e, 0x8e, 0xc9, 0x9b, 0x8e, 0x2f, 0xd4,
	0xbb, 0x64, 0x64, 0x8f, 0xe5, 0x84, 0x9d, 0xa6, 0x1a, 0xfb, 0xce, 0x62, 0x27, 0x65, 0x9b, 0xca,
	0xc7, 0x90, 0xf9, 0x92, 0xe5, 0xef, 0xad, 0x51, 0x49, 0xe7, 0x9f, 0xfc, 0x0a, 0x00, 0x00, 0xff,
	0xff, 0x60, 0xfd, 0x7b, 0xb5, 0xe0, 0x04, 0x00, 0x00,
}

// Reference imports to suppress errors if they are not otherwise used.
var _ context.Context
var _ grpc.ClientConnInterface

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
const _ = grpc.SupportPackageIsVersion6

// MetadataServiceClient is the client API for MetadataService service.
//
// For semantics around ctx use and closing/ending streaming RPCs, please refer to https://godoc.org/google.golang.org/grpc#ClientConn.NewStream.
type MetadataServiceClient interface {
	GetLabels(ctx context.Context, in *GetLabelsRequest, opts ...grpc.CallOption) (*GetLabelsRequest_Response, error)
	AddLabels(ctx context.Context, in *AddLabelsRequest, opts ...grpc.CallOption) (*AddLabelsRequest_Response, error)
	DeleteLabels(ctx context.Context, in *DeleteLabelsRequest, opts ...grpc.CallOption) (*DeleteLabelsRequest_Response, error)
}

type metadataServiceClient struct {
	cc grpc.ClientConnInterface
}

func NewMetadataServiceClient(cc grpc.ClientConnInterface) MetadataServiceClient {
	return &metadataServiceClient{cc}
}

func (c *metadataServiceClient) GetLabels(ctx context.Context, in *GetLabelsRequest, opts ...grpc.CallOption) (*GetLabelsRequest_Response, error) {
	out := new(GetLabelsRequest_Response)
	err := c.cc.Invoke(ctx, "/ai.verta.modeldb.metadata.MetadataService/GetLabels", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *metadataServiceClient) AddLabels(ctx context.Context, in *AddLabelsRequest, opts ...grpc.CallOption) (*AddLabelsRequest_Response, error) {
	out := new(AddLabelsRequest_Response)
	err := c.cc.Invoke(ctx, "/ai.verta.modeldb.metadata.MetadataService/AddLabels", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *metadataServiceClient) DeleteLabels(ctx context.Context, in *DeleteLabelsRequest, opts ...grpc.CallOption) (*DeleteLabelsRequest_Response, error) {
	out := new(DeleteLabelsRequest_Response)
	err := c.cc.Invoke(ctx, "/ai.verta.modeldb.metadata.MetadataService/DeleteLabels", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// MetadataServiceServer is the server API for MetadataService service.
type MetadataServiceServer interface {
	GetLabels(context.Context, *GetLabelsRequest) (*GetLabelsRequest_Response, error)
	AddLabels(context.Context, *AddLabelsRequest) (*AddLabelsRequest_Response, error)
	DeleteLabels(context.Context, *DeleteLabelsRequest) (*DeleteLabelsRequest_Response, error)
}

// UnimplementedMetadataServiceServer can be embedded to have forward compatible implementations.
type UnimplementedMetadataServiceServer struct {
}

func (*UnimplementedMetadataServiceServer) GetLabels(ctx context.Context, req *GetLabelsRequest) (*GetLabelsRequest_Response, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetLabels not implemented")
}
func (*UnimplementedMetadataServiceServer) AddLabels(ctx context.Context, req *AddLabelsRequest) (*AddLabelsRequest_Response, error) {
	return nil, status.Errorf(codes.Unimplemented, "method AddLabels not implemented")
}
func (*UnimplementedMetadataServiceServer) DeleteLabels(ctx context.Context, req *DeleteLabelsRequest) (*DeleteLabelsRequest_Response, error) {
	return nil, status.Errorf(codes.Unimplemented, "method DeleteLabels not implemented")
}

func RegisterMetadataServiceServer(s *grpc.Server, srv MetadataServiceServer) {
	s.RegisterService(&_MetadataService_serviceDesc, srv)
}

func _MetadataService_GetLabels_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetLabelsRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(MetadataServiceServer).GetLabels(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/ai.verta.modeldb.metadata.MetadataService/GetLabels",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(MetadataServiceServer).GetLabels(ctx, req.(*GetLabelsRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _MetadataService_AddLabels_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(AddLabelsRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(MetadataServiceServer).AddLabels(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/ai.verta.modeldb.metadata.MetadataService/AddLabels",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(MetadataServiceServer).AddLabels(ctx, req.(*AddLabelsRequest))
	}
	return interceptor(ctx, in, info, handler)
}

func _MetadataService_DeleteLabels_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(DeleteLabelsRequest)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(MetadataServiceServer).DeleteLabels(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/ai.verta.modeldb.metadata.MetadataService/DeleteLabels",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(MetadataServiceServer).DeleteLabels(ctx, req.(*DeleteLabelsRequest))
	}
	return interceptor(ctx, in, info, handler)
}

var _MetadataService_serviceDesc = grpc.ServiceDesc{
	ServiceName: "ai.verta.modeldb.metadata.MetadataService",
	HandlerType: (*MetadataServiceServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "GetLabels",
			Handler:    _MetadataService_GetLabels_Handler,
		},
		{
			MethodName: "AddLabels",
			Handler:    _MetadataService_AddLabels_Handler,
		},
		{
			MethodName: "DeleteLabels",
			Handler:    _MetadataService_DeleteLabels_Handler,
		},
	},
	Streams:  []grpc.StreamDesc{},
	Metadata: "protos/public/modeldb/metadata/MetadataService.proto",
}

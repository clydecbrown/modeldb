// Code generated by protoc-gen-go. DO NOT EDIT.
// source: protos/public/modeldb/Comment.proto

package ai_verta_modeldb

import (
	context "context"
	fmt "fmt"
	proto "github.com/golang/protobuf/proto"
	_ "google.golang.org/genproto/googleapis/api/annotations"
	grpc "google.golang.org/grpc"
	codes "google.golang.org/grpc/codes"
	status "google.golang.org/grpc/status"
	math "math"
	uac "github.com/VertaAI/modeldb-oss/protos/protos/public/uac"
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

type EntityComment struct {
	Id                   string     `protobuf:"bytes,1,opt,name=id,proto3" json:"id,omitempty"`
	EntityId             string     `protobuf:"bytes,2,opt,name=entity_id,json=entityId,proto3" json:"entity_id,omitempty"`
	EntityName           string     `protobuf:"bytes,3,opt,name=entity_name,json=entityName,proto3" json:"entity_name,omitempty"`
	Comments             []*Comment `protobuf:"bytes,4,rep,name=comments,proto3" json:"comments,omitempty"`
	XXX_NoUnkeyedLiteral struct{}   `json:"-"`
	XXX_unrecognized     []byte     `json:"-"`
	XXX_sizecache        int32      `json:"-"`
}

func (m *EntityComment) Reset()         { *m = EntityComment{} }
func (m *EntityComment) String() string { return proto.CompactTextString(m) }
func (*EntityComment) ProtoMessage()    {}
func (*EntityComment) Descriptor() ([]byte, []int) {
	return fileDescriptor_868d8be803d709b5, []int{0}
}

func (m *EntityComment) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_EntityComment.Unmarshal(m, b)
}
func (m *EntityComment) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_EntityComment.Marshal(b, m, deterministic)
}
func (m *EntityComment) XXX_Merge(src proto.Message) {
	xxx_messageInfo_EntityComment.Merge(m, src)
}
func (m *EntityComment) XXX_Size() int {
	return xxx_messageInfo_EntityComment.Size(m)
}
func (m *EntityComment) XXX_DiscardUnknown() {
	xxx_messageInfo_EntityComment.DiscardUnknown(m)
}

var xxx_messageInfo_EntityComment proto.InternalMessageInfo

func (m *EntityComment) GetId() string {
	if m != nil {
		return m.Id
	}
	return ""
}

func (m *EntityComment) GetEntityId() string {
	if m != nil {
		return m.EntityId
	}
	return ""
}

func (m *EntityComment) GetEntityName() string {
	if m != nil {
		return m.EntityName
	}
	return ""
}

func (m *EntityComment) GetComments() []*Comment {
	if m != nil {
		return m.Comments
	}
	return nil
}

type Comment struct {
	Id                   string        `protobuf:"bytes,1,opt,name=id,proto3" json:"id,omitempty"`
	UserId               string        `protobuf:"bytes,2,opt,name=user_id,json=userId,proto3" json:"user_id,omitempty"` // Deprecated: Do not use.
	DateTime             uint64        `protobuf:"varint,3,opt,name=date_time,json=dateTime,proto3" json:"date_time,omitempty"`
	Message              string        `protobuf:"bytes,4,opt,name=message,proto3" json:"message,omitempty"`
	UserInfo             *uac.UserInfo `protobuf:"bytes,5,opt,name=user_info,json=userInfo,proto3" json:"user_info,omitempty"`
	VertaId              string        `protobuf:"bytes,6,opt,name=verta_id,json=vertaId,proto3" json:"verta_id,omitempty"`
	XXX_NoUnkeyedLiteral struct{}      `json:"-"`
	XXX_unrecognized     []byte        `json:"-"`
	XXX_sizecache        int32         `json:"-"`
}

func (m *Comment) Reset()         { *m = Comment{} }
func (m *Comment) String() string { return proto.CompactTextString(m) }
func (*Comment) ProtoMessage()    {}
func (*Comment) Descriptor() ([]byte, []int) {
	return fileDescriptor_868d8be803d709b5, []int{1}
}

func (m *Comment) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_Comment.Unmarshal(m, b)
}
func (m *Comment) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_Comment.Marshal(b, m, deterministic)
}
func (m *Comment) XXX_Merge(src proto.Message) {
	xxx_messageInfo_Comment.Merge(m, src)
}
func (m *Comment) XXX_Size() int {
	return xxx_messageInfo_Comment.Size(m)
}
func (m *Comment) XXX_DiscardUnknown() {
	xxx_messageInfo_Comment.DiscardUnknown(m)
}

var xxx_messageInfo_Comment proto.InternalMessageInfo

func (m *Comment) GetId() string {
	if m != nil {
		return m.Id
	}
	return ""
}

// Deprecated: Do not use.
func (m *Comment) GetUserId() string {
	if m != nil {
		return m.UserId
	}
	return ""
}

func (m *Comment) GetDateTime() uint64 {
	if m != nil {
		return m.DateTime
	}
	return 0
}

func (m *Comment) GetMessage() string {
	if m != nil {
		return m.Message
	}
	return ""
}

func (m *Comment) GetUserInfo() *uac.UserInfo {
	if m != nil {
		return m.UserInfo
	}
	return nil
}

func (m *Comment) GetVertaId() string {
	if m != nil {
		return m.VertaId
	}
	return ""
}

type AddComment struct {
	EntityId             string   `protobuf:"bytes,1,opt,name=entity_id,json=entityId,proto3" json:"entity_id,omitempty"`
	DateTime             uint64   `protobuf:"varint,2,opt,name=date_time,json=dateTime,proto3" json:"date_time,omitempty"`
	Message              string   `protobuf:"bytes,3,opt,name=message,proto3" json:"message,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *AddComment) Reset()         { *m = AddComment{} }
func (m *AddComment) String() string { return proto.CompactTextString(m) }
func (*AddComment) ProtoMessage()    {}
func (*AddComment) Descriptor() ([]byte, []int) {
	return fileDescriptor_868d8be803d709b5, []int{2}
}

func (m *AddComment) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_AddComment.Unmarshal(m, b)
}
func (m *AddComment) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_AddComment.Marshal(b, m, deterministic)
}
func (m *AddComment) XXX_Merge(src proto.Message) {
	xxx_messageInfo_AddComment.Merge(m, src)
}
func (m *AddComment) XXX_Size() int {
	return xxx_messageInfo_AddComment.Size(m)
}
func (m *AddComment) XXX_DiscardUnknown() {
	xxx_messageInfo_AddComment.DiscardUnknown(m)
}

var xxx_messageInfo_AddComment proto.InternalMessageInfo

func (m *AddComment) GetEntityId() string {
	if m != nil {
		return m.EntityId
	}
	return ""
}

func (m *AddComment) GetDateTime() uint64 {
	if m != nil {
		return m.DateTime
	}
	return 0
}

func (m *AddComment) GetMessage() string {
	if m != nil {
		return m.Message
	}
	return ""
}

type AddComment_Response struct {
	Comment              *Comment `protobuf:"bytes,1,opt,name=comment,proto3" json:"comment,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *AddComment_Response) Reset()         { *m = AddComment_Response{} }
func (m *AddComment_Response) String() string { return proto.CompactTextString(m) }
func (*AddComment_Response) ProtoMessage()    {}
func (*AddComment_Response) Descriptor() ([]byte, []int) {
	return fileDescriptor_868d8be803d709b5, []int{2, 0}
}

func (m *AddComment_Response) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_AddComment_Response.Unmarshal(m, b)
}
func (m *AddComment_Response) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_AddComment_Response.Marshal(b, m, deterministic)
}
func (m *AddComment_Response) XXX_Merge(src proto.Message) {
	xxx_messageInfo_AddComment_Response.Merge(m, src)
}
func (m *AddComment_Response) XXX_Size() int {
	return xxx_messageInfo_AddComment_Response.Size(m)
}
func (m *AddComment_Response) XXX_DiscardUnknown() {
	xxx_messageInfo_AddComment_Response.DiscardUnknown(m)
}

var xxx_messageInfo_AddComment_Response proto.InternalMessageInfo

func (m *AddComment_Response) GetComment() *Comment {
	if m != nil {
		return m.Comment
	}
	return nil
}

type UpdateComment struct {
	Id                   string   `protobuf:"bytes,1,opt,name=id,proto3" json:"id,omitempty"`
	EntityId             string   `protobuf:"bytes,2,opt,name=entity_id,json=entityId,proto3" json:"entity_id,omitempty"`
	DateTime             uint64   `protobuf:"varint,3,opt,name=date_time,json=dateTime,proto3" json:"date_time,omitempty"`
	Message              string   `protobuf:"bytes,4,opt,name=message,proto3" json:"message,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *UpdateComment) Reset()         { *m = UpdateComment{} }
func (m *UpdateComment) String() string { return proto.CompactTextString(m) }
func (*UpdateComment) ProtoMessage()    {}
func (*UpdateComment) Descriptor() ([]byte, []int) {
	return fileDescriptor_868d8be803d709b5, []int{3}
}

func (m *UpdateComment) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_UpdateComment.Unmarshal(m, b)
}
func (m *UpdateComment) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_UpdateComment.Marshal(b, m, deterministic)
}
func (m *UpdateComment) XXX_Merge(src proto.Message) {
	xxx_messageInfo_UpdateComment.Merge(m, src)
}
func (m *UpdateComment) XXX_Size() int {
	return xxx_messageInfo_UpdateComment.Size(m)
}
func (m *UpdateComment) XXX_DiscardUnknown() {
	xxx_messageInfo_UpdateComment.DiscardUnknown(m)
}

var xxx_messageInfo_UpdateComment proto.InternalMessageInfo

func (m *UpdateComment) GetId() string {
	if m != nil {
		return m.Id
	}
	return ""
}

func (m *UpdateComment) GetEntityId() string {
	if m != nil {
		return m.EntityId
	}
	return ""
}

func (m *UpdateComment) GetDateTime() uint64 {
	if m != nil {
		return m.DateTime
	}
	return 0
}

func (m *UpdateComment) GetMessage() string {
	if m != nil {
		return m.Message
	}
	return ""
}

type UpdateComment_Response struct {
	Comment              *Comment `protobuf:"bytes,1,opt,name=comment,proto3" json:"comment,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *UpdateComment_Response) Reset()         { *m = UpdateComment_Response{} }
func (m *UpdateComment_Response) String() string { return proto.CompactTextString(m) }
func (*UpdateComment_Response) ProtoMessage()    {}
func (*UpdateComment_Response) Descriptor() ([]byte, []int) {
	return fileDescriptor_868d8be803d709b5, []int{3, 0}
}

func (m *UpdateComment_Response) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_UpdateComment_Response.Unmarshal(m, b)
}
func (m *UpdateComment_Response) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_UpdateComment_Response.Marshal(b, m, deterministic)
}
func (m *UpdateComment_Response) XXX_Merge(src proto.Message) {
	xxx_messageInfo_UpdateComment_Response.Merge(m, src)
}
func (m *UpdateComment_Response) XXX_Size() int {
	return xxx_messageInfo_UpdateComment_Response.Size(m)
}
func (m *UpdateComment_Response) XXX_DiscardUnknown() {
	xxx_messageInfo_UpdateComment_Response.DiscardUnknown(m)
}

var xxx_messageInfo_UpdateComment_Response proto.InternalMessageInfo

func (m *UpdateComment_Response) GetComment() *Comment {
	if m != nil {
		return m.Comment
	}
	return nil
}

type DeleteComment struct {
	Id                   string   `protobuf:"bytes,1,opt,name=id,proto3" json:"id,omitempty"`
	EntityId             string   `protobuf:"bytes,2,opt,name=entity_id,json=entityId,proto3" json:"entity_id,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *DeleteComment) Reset()         { *m = DeleteComment{} }
func (m *DeleteComment) String() string { return proto.CompactTextString(m) }
func (*DeleteComment) ProtoMessage()    {}
func (*DeleteComment) Descriptor() ([]byte, []int) {
	return fileDescriptor_868d8be803d709b5, []int{4}
}

func (m *DeleteComment) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_DeleteComment.Unmarshal(m, b)
}
func (m *DeleteComment) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_DeleteComment.Marshal(b, m, deterministic)
}
func (m *DeleteComment) XXX_Merge(src proto.Message) {
	xxx_messageInfo_DeleteComment.Merge(m, src)
}
func (m *DeleteComment) XXX_Size() int {
	return xxx_messageInfo_DeleteComment.Size(m)
}
func (m *DeleteComment) XXX_DiscardUnknown() {
	xxx_messageInfo_DeleteComment.DiscardUnknown(m)
}

var xxx_messageInfo_DeleteComment proto.InternalMessageInfo

func (m *DeleteComment) GetId() string {
	if m != nil {
		return m.Id
	}
	return ""
}

func (m *DeleteComment) GetEntityId() string {
	if m != nil {
		return m.EntityId
	}
	return ""
}

type DeleteComment_Response struct {
	Status               bool     `protobuf:"varint,1,opt,name=status,proto3" json:"status,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *DeleteComment_Response) Reset()         { *m = DeleteComment_Response{} }
func (m *DeleteComment_Response) String() string { return proto.CompactTextString(m) }
func (*DeleteComment_Response) ProtoMessage()    {}
func (*DeleteComment_Response) Descriptor() ([]byte, []int) {
	return fileDescriptor_868d8be803d709b5, []int{4, 0}
}

func (m *DeleteComment_Response) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_DeleteComment_Response.Unmarshal(m, b)
}
func (m *DeleteComment_Response) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_DeleteComment_Response.Marshal(b, m, deterministic)
}
func (m *DeleteComment_Response) XXX_Merge(src proto.Message) {
	xxx_messageInfo_DeleteComment_Response.Merge(m, src)
}
func (m *DeleteComment_Response) XXX_Size() int {
	return xxx_messageInfo_DeleteComment_Response.Size(m)
}
func (m *DeleteComment_Response) XXX_DiscardUnknown() {
	xxx_messageInfo_DeleteComment_Response.DiscardUnknown(m)
}

var xxx_messageInfo_DeleteComment_Response proto.InternalMessageInfo

func (m *DeleteComment_Response) GetStatus() bool {
	if m != nil {
		return m.Status
	}
	return false
}

type GetComments struct {
	EntityId             string   `protobuf:"bytes,1,opt,name=entity_id,json=entityId,proto3" json:"entity_id,omitempty"`
	XXX_NoUnkeyedLiteral struct{} `json:"-"`
	XXX_unrecognized     []byte   `json:"-"`
	XXX_sizecache        int32    `json:"-"`
}

func (m *GetComments) Reset()         { *m = GetComments{} }
func (m *GetComments) String() string { return proto.CompactTextString(m) }
func (*GetComments) ProtoMessage()    {}
func (*GetComments) Descriptor() ([]byte, []int) {
	return fileDescriptor_868d8be803d709b5, []int{5}
}

func (m *GetComments) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_GetComments.Unmarshal(m, b)
}
func (m *GetComments) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_GetComments.Marshal(b, m, deterministic)
}
func (m *GetComments) XXX_Merge(src proto.Message) {
	xxx_messageInfo_GetComments.Merge(m, src)
}
func (m *GetComments) XXX_Size() int {
	return xxx_messageInfo_GetComments.Size(m)
}
func (m *GetComments) XXX_DiscardUnknown() {
	xxx_messageInfo_GetComments.DiscardUnknown(m)
}

var xxx_messageInfo_GetComments proto.InternalMessageInfo

func (m *GetComments) GetEntityId() string {
	if m != nil {
		return m.EntityId
	}
	return ""
}

type GetComments_Response struct {
	Comments             []*Comment `protobuf:"bytes,1,rep,name=comments,proto3" json:"comments,omitempty"`
	XXX_NoUnkeyedLiteral struct{}   `json:"-"`
	XXX_unrecognized     []byte     `json:"-"`
	XXX_sizecache        int32      `json:"-"`
}

func (m *GetComments_Response) Reset()         { *m = GetComments_Response{} }
func (m *GetComments_Response) String() string { return proto.CompactTextString(m) }
func (*GetComments_Response) ProtoMessage()    {}
func (*GetComments_Response) Descriptor() ([]byte, []int) {
	return fileDescriptor_868d8be803d709b5, []int{5, 0}
}

func (m *GetComments_Response) XXX_Unmarshal(b []byte) error {
	return xxx_messageInfo_GetComments_Response.Unmarshal(m, b)
}
func (m *GetComments_Response) XXX_Marshal(b []byte, deterministic bool) ([]byte, error) {
	return xxx_messageInfo_GetComments_Response.Marshal(b, m, deterministic)
}
func (m *GetComments_Response) XXX_Merge(src proto.Message) {
	xxx_messageInfo_GetComments_Response.Merge(m, src)
}
func (m *GetComments_Response) XXX_Size() int {
	return xxx_messageInfo_GetComments_Response.Size(m)
}
func (m *GetComments_Response) XXX_DiscardUnknown() {
	xxx_messageInfo_GetComments_Response.DiscardUnknown(m)
}

var xxx_messageInfo_GetComments_Response proto.InternalMessageInfo

func (m *GetComments_Response) GetComments() []*Comment {
	if m != nil {
		return m.Comments
	}
	return nil
}

func init() {
	proto.RegisterType((*EntityComment)(nil), "ai.verta.modeldb.EntityComment")
	proto.RegisterType((*Comment)(nil), "ai.verta.modeldb.Comment")
	proto.RegisterType((*AddComment)(nil), "ai.verta.modeldb.AddComment")
	proto.RegisterType((*AddComment_Response)(nil), "ai.verta.modeldb.AddComment.Response")
	proto.RegisterType((*UpdateComment)(nil), "ai.verta.modeldb.UpdateComment")
	proto.RegisterType((*UpdateComment_Response)(nil), "ai.verta.modeldb.UpdateComment.Response")
	proto.RegisterType((*DeleteComment)(nil), "ai.verta.modeldb.DeleteComment")
	proto.RegisterType((*DeleteComment_Response)(nil), "ai.verta.modeldb.DeleteComment.Response")
	proto.RegisterType((*GetComments)(nil), "ai.verta.modeldb.GetComments")
	proto.RegisterType((*GetComments_Response)(nil), "ai.verta.modeldb.GetComments.Response")
}

func init() {
	proto.RegisterFile("protos/public/modeldb/Comment.proto", fileDescriptor_868d8be803d709b5)
}

var fileDescriptor_868d8be803d709b5 = []byte{
	// 579 bytes of a gzipped FileDescriptorProto
	0x1f, 0x8b, 0x08, 0x00, 0x00, 0x00, 0x00, 0x00, 0x02, 0xff, 0xa4, 0x94, 0x4f, 0x6f, 0x12, 0x41,
	0x18, 0xc6, 0x33, 0x0b, 0xc2, 0xf2, 0x12, 0x1a, 0x33, 0x87, 0xba, 0x5d, 0x6b, 0x4a, 0xb6, 0x4a,
	0x48, 0x35, 0xbb, 0x29, 0x8d, 0x17, 0x2f, 0x86, 0xd6, 0xc6, 0x70, 0x31, 0x66, 0x95, 0x73, 0x1d,
	0x98, 0x29, 0x99, 0x84, 0xfd, 0x13, 0x66, 0x96, 0xe8, 0xd5, 0x0f, 0xa0, 0x07, 0x4d, 0x4c, 0xbc,
	0xf9, 0x1d, 0xbc, 0xfa, 0x29, 0xfc, 0x0a, 0x9e, 0xfc, 0x14, 0x66, 0x67, 0x87, 0xb2, 0x5b, 0x58,
	0x6c, 0xe8, 0x8d, 0x79, 0xdf, 0x97, 0xe7, 0xf9, 0xcd, 0x33, 0x2f, 0xc0, 0x61, 0x3c, 0x8b, 0x64,
	0x24, 0xbc, 0x38, 0x19, 0x4d, 0xf9, 0xd8, 0x0b, 0x22, 0xca, 0xa6, 0x74, 0xe4, 0x9d, 0x45, 0x41,
	0xc0, 0x42, 0xe9, 0xaa, 0x2e, 0xbe, 0x4b, 0xb8, 0x3b, 0x67, 0x33, 0x49, 0x5c, 0xdd, 0xb7, 0xf7,
	0x27, 0x51, 0x34, 0x99, 0x32, 0x8f, 0xc4, 0xdc, 0x23, 0x61, 0x18, 0x49, 0x22, 0x79, 0x14, 0x8a,
	0x6c, 0xde, 0x76, 0x8a, 0xa2, 0x09, 0x19, 0x7b, 0xc3, 0xfe, 0xd9, 0x1b, 0x36, 0x9b, 0xf3, 0x31,
	0xcb, 0x66, 0x9c, 0xaf, 0x08, 0x5a, 0xe7, 0xa1, 0xe4, 0xf2, 0x83, 0xf6, 0xc2, 0x3b, 0x60, 0x70,
	0x6a, 0xa1, 0x36, 0xea, 0x36, 0x7c, 0x83, 0x53, 0x7c, 0x1f, 0x1a, 0x4c, 0x0d, 0x5c, 0x70, 0x6a,
	0x19, 0xaa, 0x6c, 0x66, 0x85, 0x01, 0xc5, 0x07, 0xd0, 0xd4, 0xcd, 0x90, 0x04, 0xcc, 0xaa, 0xa8,
	0x36, 0x64, 0xa5, 0x57, 0x24, 0x60, 0xf8, 0x29, 0x98, 0xe3, 0x4c, 0x58, 0x58, 0xd5, 0x76, 0xa5,
	0xdb, 0xec, 0xed, 0xb9, 0xd7, 0xaf, 0xe1, 0x6a, 0x6b, 0xff, 0x6a, 0xd4, 0xf9, 0x85, 0xa0, 0x5e,
	0x0e, 0x54, 0x4f, 0x04, 0x9b, 0x5d, 0xe1, 0x9c, 0x1a, 0x16, 0xf2, 0x6b, 0x69, 0x69, 0xa0, 0x68,
	0x29, 0x91, 0xec, 0x42, 0x72, 0x8d, 0x53, 0xf5, 0xcd, 0xb4, 0xf0, 0x96, 0x07, 0x0c, 0x5b, 0x50,
	0x0f, 0x98, 0x10, 0x64, 0xc2, 0xac, 0xaa, 0x92, 0x5b, 0x1c, 0xf1, 0x09, 0x34, 0x32, 0xcd, 0xf0,
	0x32, 0xb2, 0xee, 0xb4, 0x51, 0xb7, 0xd9, 0xdb, 0x5d, 0x72, 0x26, 0x64, 0xec, 0x0e, 0x53, 0xfd,
	0xf0, 0x32, 0xf2, 0xcd, 0x44, 0x7f, 0xc2, 0x7b, 0x60, 0xaa, 0x7e, 0x4a, 0x52, 0xcb, 0xf4, 0xd4,
	0x79, 0x40, 0x9d, 0x1f, 0x08, 0xa0, 0x4f, 0xe9, 0xe2, 0x0a, 0x85, 0x0c, 0xd1, 0xb5, 0x0c, 0x0b,
	0xc8, 0x46, 0x39, 0x72, 0xa5, 0x80, 0x6c, 0x3f, 0x07, 0xd3, 0x67, 0x22, 0x8e, 0x42, 0x91, 0xe2,
	0xd7, 0x75, 0x74, 0x4a, 0x7d, 0x63, 0xc8, 0x8b, 0x49, 0xe7, 0x27, 0x82, 0xd6, 0x30, 0x4e, 0x9d,
	0xb6, 0x7a, 0xfa, 0xed, 0x92, 0xbe, 0x3d, 0xf6, 0x3b, 0x68, 0xbd, 0x60, 0x53, 0xb6, 0x1d, 0xb5,
	0xed, 0xe4, 0xec, 0x77, 0xa1, 0x26, 0x24, 0x91, 0x89, 0x50, 0x5f, 0x36, 0x7d, 0x7d, 0x72, 0x02,
	0x68, 0xbe, 0x64, 0x52, 0xcb, 0x8b, 0x8d, 0x8f, 0x67, 0xf7, 0x73, 0x7a, 0xf9, 0x5d, 0x47, 0x37,
	0xde, 0xf5, 0xde, 0xdf, 0x2a, 0xec, 0xe8, 0xaa, 0xfe, 0x6d, 0xe2, 0x4f, 0x08, 0xee, 0x11, 0x4a,
	0xcf, 0xdf, 0xc7, 0x6c, 0xc6, 0xd5, 0x78, 0x12, 0x2e, 0xae, 0xbb, 0xbf, 0xaa, 0xb9, 0xdc, 0x34,
	0xfb, 0xd1, 0xa6, 0xae, 0xbb, 0x40, 0x75, 0xdc, 0x8f, 0xbf, 0xff, 0x7c, 0x31, 0xba, 0xce, 0xa1,
	0x37, 0x3f, 0xf6, 0x34, 0x89, 0x57, 0xe2, 0xf8, 0x0c, 0x1d, 0xe1, 0xef, 0x08, 0xec, 0x44, 0xed,
	0xca, 0x5a, 0xa6, 0x83, 0x55, 0xd7, 0xc2, 0x66, 0xd9, 0xdd, 0xff, 0x0c, 0x2c, 0xc9, 0x8e, 0x15,
	0xd9, 0x63, 0xa7, 0x93, 0x27, 0x2b, 0xb7, 0x4e, 0xe1, 0x3e, 0x23, 0xb0, 0x26, 0x4c, 0xae, 0x6b,
	0x0b, 0xfc, 0x60, 0xd5, 0x39, 0xf7, 0xb8, 0x76, 0x67, 0x63, 0x7b, 0x89, 0xf5, 0x44, 0x61, 0x75,
	0xf0, 0xc3, 0x3c, 0x56, 0xa9, 0xe9, 0x37, 0x04, 0x36, 0x55, 0x4b, 0x7a, 0xd3, 0xb8, 0x0a, 0x2b,
	0xbd, 0x2e, 0xae, 0xc2, 0xc0, 0xca, 0x43, 0x1e, 0x15, 0xe2, 0x2a, 0xb7, 0x3e, 0x35, 0x5e, 0xa3,
	0x51, 0x4d, 0xfd, 0xf5, 0x9f, 0xfc, 0x0b, 0x00, 0x00, 0xff, 0xff, 0x92, 0x0f, 0xb2, 0x00, 0x75,
	0x06, 0x00, 0x00,
}

// Reference imports to suppress errors if they are not otherwise used.
var _ context.Context
var _ grpc.ClientConn

// This is a compile-time assertion to ensure that this generated file
// is compatible with the grpc package it is being compiled against.
const _ = grpc.SupportPackageIsVersion4

// CommentServiceClient is the client API for CommentService service.
//
// For semantics around ctx use and closing/ending streaming RPCs, please refer to https://godoc.org/google.golang.org/grpc#ClientConn.NewStream.
type CommentServiceClient interface {
	AddExperimentRunComment(ctx context.Context, in *AddComment, opts ...grpc.CallOption) (*AddComment_Response, error)
	UpdateExperimentRunComment(ctx context.Context, in *UpdateComment, opts ...grpc.CallOption) (*UpdateComment_Response, error)
	GetExperimentRunComments(ctx context.Context, in *GetComments, opts ...grpc.CallOption) (*GetComments_Response, error)
	DeleteExperimentRunComment(ctx context.Context, in *DeleteComment, opts ...grpc.CallOption) (*DeleteComment_Response, error)
}

type commentServiceClient struct {
	cc *grpc.ClientConn
}

func NewCommentServiceClient(cc *grpc.ClientConn) CommentServiceClient {
	return &commentServiceClient{cc}
}

func (c *commentServiceClient) AddExperimentRunComment(ctx context.Context, in *AddComment, opts ...grpc.CallOption) (*AddComment_Response, error) {
	out := new(AddComment_Response)
	err := c.cc.Invoke(ctx, "/ai.verta.modeldb.CommentService/addExperimentRunComment", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *commentServiceClient) UpdateExperimentRunComment(ctx context.Context, in *UpdateComment, opts ...grpc.CallOption) (*UpdateComment_Response, error) {
	out := new(UpdateComment_Response)
	err := c.cc.Invoke(ctx, "/ai.verta.modeldb.CommentService/updateExperimentRunComment", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *commentServiceClient) GetExperimentRunComments(ctx context.Context, in *GetComments, opts ...grpc.CallOption) (*GetComments_Response, error) {
	out := new(GetComments_Response)
	err := c.cc.Invoke(ctx, "/ai.verta.modeldb.CommentService/getExperimentRunComments", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

func (c *commentServiceClient) DeleteExperimentRunComment(ctx context.Context, in *DeleteComment, opts ...grpc.CallOption) (*DeleteComment_Response, error) {
	out := new(DeleteComment_Response)
	err := c.cc.Invoke(ctx, "/ai.verta.modeldb.CommentService/deleteExperimentRunComment", in, out, opts...)
	if err != nil {
		return nil, err
	}
	return out, nil
}

// CommentServiceServer is the server API for CommentService service.
type CommentServiceServer interface {
	AddExperimentRunComment(context.Context, *AddComment) (*AddComment_Response, error)
	UpdateExperimentRunComment(context.Context, *UpdateComment) (*UpdateComment_Response, error)
	GetExperimentRunComments(context.Context, *GetComments) (*GetComments_Response, error)
	DeleteExperimentRunComment(context.Context, *DeleteComment) (*DeleteComment_Response, error)
}

// UnimplementedCommentServiceServer can be embedded to have forward compatible implementations.
type UnimplementedCommentServiceServer struct {
}

func (*UnimplementedCommentServiceServer) AddExperimentRunComment(ctx context.Context, req *AddComment) (*AddComment_Response, error) {
	return nil, status.Errorf(codes.Unimplemented, "method AddExperimentRunComment not implemented")
}
func (*UnimplementedCommentServiceServer) UpdateExperimentRunComment(ctx context.Context, req *UpdateComment) (*UpdateComment_Response, error) {
	return nil, status.Errorf(codes.Unimplemented, "method UpdateExperimentRunComment not implemented")
}
func (*UnimplementedCommentServiceServer) GetExperimentRunComments(ctx context.Context, req *GetComments) (*GetComments_Response, error) {
	return nil, status.Errorf(codes.Unimplemented, "method GetExperimentRunComments not implemented")
}
func (*UnimplementedCommentServiceServer) DeleteExperimentRunComment(ctx context.Context, req *DeleteComment) (*DeleteComment_Response, error) {
	return nil, status.Errorf(codes.Unimplemented, "method DeleteExperimentRunComment not implemented")
}

func RegisterCommentServiceServer(s *grpc.Server, srv CommentServiceServer) {
	s.RegisterService(&_CommentService_serviceDesc, srv)
}

func _CommentService_AddExperimentRunComment_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(AddComment)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(CommentServiceServer).AddExperimentRunComment(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/ai.verta.modeldb.CommentService/AddExperimentRunComment",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(CommentServiceServer).AddExperimentRunComment(ctx, req.(*AddComment))
	}
	return interceptor(ctx, in, info, handler)
}

func _CommentService_UpdateExperimentRunComment_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(UpdateComment)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(CommentServiceServer).UpdateExperimentRunComment(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/ai.verta.modeldb.CommentService/UpdateExperimentRunComment",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(CommentServiceServer).UpdateExperimentRunComment(ctx, req.(*UpdateComment))
	}
	return interceptor(ctx, in, info, handler)
}

func _CommentService_GetExperimentRunComments_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(GetComments)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(CommentServiceServer).GetExperimentRunComments(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/ai.verta.modeldb.CommentService/GetExperimentRunComments",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(CommentServiceServer).GetExperimentRunComments(ctx, req.(*GetComments))
	}
	return interceptor(ctx, in, info, handler)
}

func _CommentService_DeleteExperimentRunComment_Handler(srv interface{}, ctx context.Context, dec func(interface{}) error, interceptor grpc.UnaryServerInterceptor) (interface{}, error) {
	in := new(DeleteComment)
	if err := dec(in); err != nil {
		return nil, err
	}
	if interceptor == nil {
		return srv.(CommentServiceServer).DeleteExperimentRunComment(ctx, in)
	}
	info := &grpc.UnaryServerInfo{
		Server:     srv,
		FullMethod: "/ai.verta.modeldb.CommentService/DeleteExperimentRunComment",
	}
	handler := func(ctx context.Context, req interface{}) (interface{}, error) {
		return srv.(CommentServiceServer).DeleteExperimentRunComment(ctx, req.(*DeleteComment))
	}
	return interceptor(ctx, in, info, handler)
}

var _CommentService_serviceDesc = grpc.ServiceDesc{
	ServiceName: "ai.verta.modeldb.CommentService",
	HandlerType: (*CommentServiceServer)(nil),
	Methods: []grpc.MethodDesc{
		{
			MethodName: "addExperimentRunComment",
			Handler:    _CommentService_AddExperimentRunComment_Handler,
		},
		{
			MethodName: "updateExperimentRunComment",
			Handler:    _CommentService_UpdateExperimentRunComment_Handler,
		},
		{
			MethodName: "getExperimentRunComments",
			Handler:    _CommentService_GetExperimentRunComments_Handler,
		},
		{
			MethodName: "deleteExperimentRunComment",
			Handler:    _CommentService_DeleteExperimentRunComment_Handler,
		},
	},
	Streams:  []grpc.StreamDesc{},
	Metadata: "protos/public/modeldb/Comment.proto",
}

# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
import grpc

from ...public.uac import Team_pb2 as protos_dot_public_dot_uac_dot_Team__pb2


class TeamServiceStub(object):
  # missing associated documentation comment in .proto file
  pass

  def __init__(self, channel):
    """Constructor.

    Args:
      channel: A grpc.Channel.
    """
    self.getTeamById = channel.unary_unary(
        '/ai.verta.uac.TeamService/getTeamById',
        request_serializer=protos_dot_public_dot_uac_dot_Team__pb2.GetTeamById.SerializeToString,
        response_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.GetTeamById.Response.FromString,
        )
    self.getTeamByName = channel.unary_unary(
        '/ai.verta.uac.TeamService/getTeamByName',
        request_serializer=protos_dot_public_dot_uac_dot_Team__pb2.GetTeamByName.SerializeToString,
        response_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.GetTeamByName.Response.FromString,
        )
    self.getTeamByShortName = channel.unary_unary(
        '/ai.verta.uac.TeamService/getTeamByShortName',
        request_serializer=protos_dot_public_dot_uac_dot_Team__pb2.GetTeamByShortName.SerializeToString,
        response_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.GetTeamByShortName.Response.FromString,
        )
    self.listMyTeams = channel.unary_unary(
        '/ai.verta.uac.TeamService/listMyTeams',
        request_serializer=protos_dot_public_dot_uac_dot_Team__pb2.ListMyTeams.SerializeToString,
        response_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.ListMyTeams.Response.FromString,
        )
    self.setTeam = channel.unary_unary(
        '/ai.verta.uac.TeamService/setTeam',
        request_serializer=protos_dot_public_dot_uac_dot_Team__pb2.SetTeam.SerializeToString,
        response_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.SetTeam.Response.FromString,
        )
    self.deleteTeam = channel.unary_unary(
        '/ai.verta.uac.TeamService/deleteTeam',
        request_serializer=protos_dot_public_dot_uac_dot_Team__pb2.DeleteTeam.SerializeToString,
        response_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.DeleteTeam.Response.FromString,
        )
    self.listUsers = channel.unary_unary(
        '/ai.verta.uac.TeamService/listUsers',
        request_serializer=protos_dot_public_dot_uac_dot_Team__pb2.ListTeamUser.SerializeToString,
        response_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.ListTeamUser.Response.FromString,
        )
    self.addUser = channel.unary_unary(
        '/ai.verta.uac.TeamService/addUser',
        request_serializer=protos_dot_public_dot_uac_dot_Team__pb2.AddTeamUser.SerializeToString,
        response_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.AddTeamUser.Response.FromString,
        )
    self.removeUser = channel.unary_unary(
        '/ai.verta.uac.TeamService/removeUser',
        request_serializer=protos_dot_public_dot_uac_dot_Team__pb2.RemoveTeamUser.SerializeToString,
        response_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.RemoveTeamUser.Response.FromString,
        )


class TeamServiceServicer(object):
  # missing associated documentation comment in .proto file
  pass

  def getTeamById(self, request, context):
    """Gets information from a given team
    """
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def getTeamByName(self, request, context):
    """Gets information from a given team
    """
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def getTeamByShortName(self, request, context):
    """Gets information from a given team
    """
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def listMyTeams(self, request, context):
    """Lists the teams that the current user can see
    """
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def setTeam(self, request, context):
    """Create or update a team
    Automatically adds the caller to the team
    """
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def deleteTeam(self, request, context):
    """Delete an existing team
    Only enabled if the person deleting is the owner of the organization or owner of the team
    """
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def listUsers(self, request, context):
    """List users inside a team
    Only available for users inside the team itself
    """
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def addUser(self, request, context):
    """Adds the given user to the team
    Only enabled if the requester is the creator of the team or the organization
    """
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')

  def removeUser(self, request, context):
    """Removes the given user to the team
    Only enabled if the requester is the creator of the team
    The owner can never be removed
    """
    context.set_code(grpc.StatusCode.UNIMPLEMENTED)
    context.set_details('Method not implemented!')
    raise NotImplementedError('Method not implemented!')


def add_TeamServiceServicer_to_server(servicer, server):
  rpc_method_handlers = {
      'getTeamById': grpc.unary_unary_rpc_method_handler(
          servicer.getTeamById,
          request_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.GetTeamById.FromString,
          response_serializer=protos_dot_public_dot_uac_dot_Team__pb2.GetTeamById.Response.SerializeToString,
      ),
      'getTeamByName': grpc.unary_unary_rpc_method_handler(
          servicer.getTeamByName,
          request_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.GetTeamByName.FromString,
          response_serializer=protos_dot_public_dot_uac_dot_Team__pb2.GetTeamByName.Response.SerializeToString,
      ),
      'getTeamByShortName': grpc.unary_unary_rpc_method_handler(
          servicer.getTeamByShortName,
          request_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.GetTeamByShortName.FromString,
          response_serializer=protos_dot_public_dot_uac_dot_Team__pb2.GetTeamByShortName.Response.SerializeToString,
      ),
      'listMyTeams': grpc.unary_unary_rpc_method_handler(
          servicer.listMyTeams,
          request_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.ListMyTeams.FromString,
          response_serializer=protos_dot_public_dot_uac_dot_Team__pb2.ListMyTeams.Response.SerializeToString,
      ),
      'setTeam': grpc.unary_unary_rpc_method_handler(
          servicer.setTeam,
          request_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.SetTeam.FromString,
          response_serializer=protos_dot_public_dot_uac_dot_Team__pb2.SetTeam.Response.SerializeToString,
      ),
      'deleteTeam': grpc.unary_unary_rpc_method_handler(
          servicer.deleteTeam,
          request_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.DeleteTeam.FromString,
          response_serializer=protos_dot_public_dot_uac_dot_Team__pb2.DeleteTeam.Response.SerializeToString,
      ),
      'listUsers': grpc.unary_unary_rpc_method_handler(
          servicer.listUsers,
          request_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.ListTeamUser.FromString,
          response_serializer=protos_dot_public_dot_uac_dot_Team__pb2.ListTeamUser.Response.SerializeToString,
      ),
      'addUser': grpc.unary_unary_rpc_method_handler(
          servicer.addUser,
          request_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.AddTeamUser.FromString,
          response_serializer=protos_dot_public_dot_uac_dot_Team__pb2.AddTeamUser.Response.SerializeToString,
      ),
      'removeUser': grpc.unary_unary_rpc_method_handler(
          servicer.removeUser,
          request_deserializer=protos_dot_public_dot_uac_dot_Team__pb2.RemoveTeamUser.FromString,
          response_serializer=protos_dot_public_dot_uac_dot_Team__pb2.RemoveTeamUser.Response.SerializeToString,
      ),
  }
  generic_handler = grpc.method_handlers_generic_handler(
      'ai.verta.uac.TeamService', rpc_method_handlers)
  server.add_generic_rpc_handlers((generic_handler,))

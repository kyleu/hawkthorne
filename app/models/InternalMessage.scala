package models

import java.util.UUID

import akka.actor.ActorRef
import models.auth.Credentials
import models.supervisor.ConnectionDescription

sealed trait InternalMessage

object InternalMessage {
  final case class ConnectionStarted(creds: Credentials, channel: String, id: UUID, conn: ActorRef) extends InternalMessage
  final case class ConnectionStopped(id: UUID) extends InternalMessage
  case object GetSystemStatus extends InternalMessage
  final case class SystemStatus(connections: Seq[ConnectionDescription]) extends InternalMessage
  final case class SendConnectionTrace(id: UUID) extends InternalMessage
  final case class ConnectionTraceResponse(id: UUID, userId: UUID, username: String) extends InternalMessage
  final case class SendClientTrace(id: UUID) extends InternalMessage
  final case class ClientTraceResponse(id: UUID, data: String) extends InternalMessage
}

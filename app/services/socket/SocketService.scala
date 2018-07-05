package services.socket

import java.util.UUID

import akka.actor.{Actor, ActorRef, Props}
import models.InternalMessage.{SocketStarted, SocketStopped}
import models.RequestMessage.Ping
import models.ResponseMessage
import models.ResponseMessage.{Pong, UserSettings}
import models.auth.Credentials
import util.Logging

object SocketService {
  def props(id: Option[UUID], supervisor: ActorRef, creds: Credentials, out: ActorRef, sourceAddress: String) = {
    Props(SocketService(id.getOrElse(UUID.randomUUID), supervisor, creds, out, sourceAddress))
  }
}

final case class SocketService(id: UUID, supervisor: ActorRef, creds: Credentials, out: ActorRef, sourceAddress: String) extends Actor with Logging {
  override def preStart() = {
    log.info(s"Starting connection for user [${creds.user.id}: ${creds.user.username}].")
    supervisor.tell(SocketStarted(creds, "home", id, self), self)
    out.tell(UserSettings(creds.user.id, creds.user.username, creds.user.profile.providerKey), self)
  }

  override def receive = {
    case p: Ping => out.tell(Pong(p.ts), self)
    case rm: ResponseMessage => out.tell(rm, self)
    case x => throw new IllegalArgumentException(s"Unhandled request message [${x.getClass.getSimpleName}].")
  }

  override def postStop() = {
    supervisor.tell(SocketStopped(id), self)
  }
}

package services.supervisor

import java.time.LocalDateTime
import java.util.UUID

import akka.actor.{Actor, ActorRef, ActorRefFactory, OneForOneStrategy, SupervisorStrategy}
import models.InternalMessage._
import models.{InternalMessage, ResponseMessage}
import models.ResponseMessage.ServerError
import models.supervisor.ConnectionDescription
import util.{DateUtils, Logging}

object ConnectionSupervisor {
  protected var factory: Option[ActorRefFactory] = None
  def getFactory = factory.getOrElse(throw new IllegalStateException("No PlayerSupervisor has been started."))

  final case class Broadcast(msg: ResponseMessage)
  final case class ConnectionRecord(id: UUID, userId: UUID, name: String, actorRef: ActorRef, started: LocalDateTime) {
    val desc = ConnectionDescription(id, userId, name, "connection", started)
  }
}

class ConnectionSupervisor() extends Actor with Logging {
  private[this] val connections = collection.mutable.HashMap.empty[UUID, ConnectionSupervisor.ConnectionRecord]
  private[this] def connectionById(id: UUID) = connections.get(id)

  override def preStart() = {
    ConnectionSupervisor.factory.foreach(_ => throw new IllegalStateException("Only one ConnectionSupervisor can be started."))
    log.debug(s"Connection Supervisor started for [${util.Config.projectId}].")
    ConnectionSupervisor.factory = Some(context)
  }

  override val supervisorStrategy = OneForOneStrategy() {
    case x: IllegalStateException =>
      val msg = s"Connection Actor encountered [${x.getClass.getSimpleName}]: ${x.getMessage}"
      log.error(msg, x)
      self.tell(ServerError("connection-exception", msg), self)
      SupervisorStrategy.Stop
    case x: Exception =>
      val msg = s"Connection Actor encountered [${x.getClass.getSimpleName}]: ${x.getMessage}"
      log.error(msg, x)
      SupervisorStrategy.Stop
  }

  override def receive = {
    case ss: ConnectionStarted => handleConnectionStarted(ss.id, ss.creds.user.id, ss.creds.user.username, ss.conn)
    case ss: ConnectionStopped => handleConnectionStopped(ss.id)

    case GetSystemStatus => handleGetSystemStatus()
    case sst: ConnectionTraceRequest => handleSendConnectionTrace(sst)
    case sct: ClientTraceRequest => handleSendClientTrace(sct)

    case b: ConnectionSupervisor.Broadcast => connections.foreach(_._2.actorRef.tell(b.msg, self))

    case im: InternalMessage => log.warn(s"Unhandled connection supervisor internal message [${im.getClass.getSimpleName}].")
    case x => log.warn(s"PlayerSupervisor encountered unknown message: ${x.toString}")
  }

  private[this] def handleGetSystemStatus() = sender().tell(ConnectionStatus(connections.map(_._2.desc).toSeq.sortBy(_.name)), self)

  private[this] def handleSendConnectionTrace(ct: ConnectionTraceRequest) = connectionById(ct.id) match {
    case Some(c) => c.actorRef forward ct
    case None => sender().tell(ServerError("Unknown connection", ct.id.toString), self)
  }

  private[this] def handleSendClientTrace(ct: ClientTraceRequest) = connectionById(ct.id) match {
    case Some(c) => c.actorRef forward ct
    case None => sender().tell(ServerError("Unknown connection", ct.id.toString), self)
  }

  protected[this] def handleConnectionStarted(id: UUID, userId: UUID, name: String, connection: ActorRef) = {
    log.debug(s"Connection [$id] registered to user [$userId] with path [${connection.path}].")
    connections(id) = ConnectionSupervisor.ConnectionRecord(id, userId, name, connection, DateUtils.now)
  }

  protected[this] def handleConnectionStopped(id: UUID) = {
    connections.remove(id).foreach(sock => log.debug(s"Connection [$id] [${sock.actorRef.path}] removed from Audit supervisor."))
  }
}

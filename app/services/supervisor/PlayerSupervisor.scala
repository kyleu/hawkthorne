package services.supervisor

import java.time.LocalDateTime
import java.util.UUID

import akka.actor.{Actor, ActorRef, ActorRefFactory, OneForOneStrategy, SupervisorStrategy}
import models.InternalMessage._
import models.{InternalMessage, ResponseMessage}
import models.ResponseMessage.ServerError
import models.supervisor.SocketDescription
import util.metrics.Instrumented
import util.{DateUtils, Logging}

object PlayerSupervisor {
  protected var factory: Option[ActorRefFactory] = None
  def getFactory = factory.getOrElse(throw new IllegalStateException("No PlayerSupervisor has been started."))

  case class Broadcast(msg: ResponseMessage)
  case class SocketRecord(socketId: UUID, userId: UUID, name: String, actorRef: ActorRef, started: LocalDateTime) {
    val desc = SocketDescription(socketId, userId, name, "player", started)
  }
}

class PlayerSupervisor() extends Actor with Logging {
  private[this] val sockets = collection.mutable.HashMap.empty[UUID, PlayerSupervisor.SocketRecord]
  private[this] def socketById(id: UUID) = sockets.get(id)

  /*
  private[this] lazy val metricsName = util.Config.projectId + "_player_supervisor"
  private[this] lazy val receiveHistogram = Histogram.build(metricsName + "_receive", s"Message metrics for [$metricsName]").labelNames("msg").register()
  private[this] lazy val errorCounter = Counter.build(metricsName + "_exception", s"Exception metrics for [$metricsName]").labelNames("msg", "ex").register()
  private[this] val playerCount = Gauge.build(metricsName + "_active_player_connections", "Player Supervisor active actors.").labelNames("id").register()
  */

  override def preStart() = {
    PlayerSupervisor.factory.foreach(_ => throw new IllegalStateException("Only one PlayerSupervisor can be started."))
    log.debug(s"Player Supervisor started for [${util.Config.projectId}].")
    PlayerSupervisor.factory = Some(context)
  }

  override val supervisorStrategy = OneForOneStrategy() {
    case x: IllegalStateException =>
      val msg = s"Player Actor [???] encountered [${x.getClass.getSimpleName}]: ${x.getMessage}"
      log.error(msg, x)
      self.tell(ServerError("player-exception", msg), self)
      SupervisorStrategy.Stop
    case x: Exception =>
      val msg = s"Player Actor [???] encountered [${x.getClass.getSimpleName}]: ${x.getMessage}"
      log.error(msg, x)
      SupervisorStrategy.Stop
  }

  private[this] def time(msg: Any, f: => Unit) = Instrumented.timeReceive(msg, msg.getClass.getSimpleName.stripSuffix("$"))(f)

  override def receive = {
    case ss: SocketStarted => time(ss, handleSocketStarted(ss.socketId, ss.creds.user.id, ss.creds.user.username, ss.conn))
    case ss: SocketStopped => time(ss, handleSocketStopped(ss.socketId))

    case GetSystemStatus => time(GetSystemStatus, handleGetSystemStatus())
    case sst: SendSocketTrace => time(sst, handleSendSocketTrace(sst))
    case sct: SendClientTrace => time(sct, handleSendClientTrace(sct))

    case b: PlayerSupervisor.Broadcast => time(b, sockets.foreach(_._2.actorRef.tell(b.msg, self)))

    case im: InternalMessage => log.warn(s"Unhandled internal message [${im.getClass.getSimpleName}].")
    case x => log.warn(s"PlayerSupervisor encountered unknown message: ${x.toString}")
  }

  private[this] def handleGetSystemStatus() = {
    val channelStatuses = sockets.map(_._2.desc).toSeq.sortBy(_.name)
    sender().tell(SystemStatus(channelStatuses), self)
  }

  private[this] def handleSendSocketTrace(ct: SendSocketTrace) = socketById(ct.id) match {
    case Some(c) => c.actorRef forward ct
    case None => sender().tell(ServerError("Unknown Socket", ct.id.toString), self)
  }

  private[this] def handleSendClientTrace(ct: SendClientTrace) = socketById(ct.id) match {
    case Some(c) => c.actorRef forward ct
    case None => sender().tell(ServerError("Unknown Client Socket", ct.id.toString), self)
  }

  protected[this] def handleSocketStarted(socketId: UUID, userId: UUID, name: String, socket: ActorRef) = {
    log.debug(s"Socket [player:$socketId] registered to [$userId] with path [${socket.path}].")
    sockets(socketId) = {
      PlayerSupervisor.SocketRecord(socketId, userId, name, socket, DateUtils.now)
    }
    // playerCount.inc()
  }

  protected[this] def handleSocketStopped(id: UUID) = {
    sockets.remove(id).foreach { sock =>
      log.debug(s"Connection [$id] [${sock.actorRef.path}] removed from Audit supervisor.")
    }
    // playerCount.dec()
  }
}

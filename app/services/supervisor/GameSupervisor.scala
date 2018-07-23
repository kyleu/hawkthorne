package services.supervisor

import java.time.LocalDateTime
import java.util.UUID

import akka.actor.{Actor, ActorRef, OneForOneStrategy, SupervisorStrategy}
import models.InternalMessage.{GetSystemStatus, SocketStarted, SocketStopped, SystemStatus}
import models.{InternalMessage, ResponseMessage}
import models.game.GameOptions
import models.player.PlayerDetails
import models.supervisor.SocketDescription
// import services.game.GameService
// import services.history.GameHistoryLogService
import util.metrics.Instrumented
import util.{DateUtils, Logging}

object GameSupervisor {
  final case class Broadcast(msg: ResponseMessage)
  final case class StartGame(id: UUID, options: GameOptions, playerInfo: IndexedSeq[PlayerDetails])
  final case class SocketRecord(socketId: UUID, userId: UUID, name: String, channel: String, actorRef: ActorRef, started: LocalDateTime) {
    def toDescription = SocketDescription(socketId, userId, name, channel, started)
  }
}

class GameSupervisor() extends Actor with Logging {
  private[this] val games = collection.mutable.HashMap.empty[UUID, GameSupervisor.SocketRecord]

  /*
  protected[this] lazy val metricsName = util.Config.projectId + "_game_supervisor"
  private[this] lazy val receiveHistogram = Histogram.build(metricsName + "_receive", s"Message metrics for [$metricsName]").labelNames("msg").register()
  private[this] lazy val errorCounter = Counter.build(metricsName + "_exception", s"Exception metrics for [$metricsName]").labelNames("msg", "ex").register()
  private[this] val gamesCount = Gauge.build(metricsName + "_active_games", "Game Supervisor active actors.").labelNames("id").register()
  */

  override def preStart() = {
    log.debug(s"Game Supervisor started for [${util.Config.projectId}] at path [${self.path}].")
  }

  override val supervisorStrategy = OneForOneStrategy() {
    case t: Throwable =>
      val msg = s"Game encountered uncaught [${t.getClass.getSimpleName}]: ${t.getMessage}"
      log.error(msg)
      SupervisorStrategy.Stop
  }

  private[this] def time(msg: Any, f: => Unit) = Instrumented.timeReceive(msg, msg.getClass.getSimpleName.stripSuffix("$"))(f)

  override def receive = {
    case sg: GameSupervisor.StartGame => time(sg, handleStartGame(sg.id, sg.options, sg.playerInfo))
    case ss: SocketStarted => time(ss, handleSocketStarted(ss.socketId, ss.creds.user.id, ss.creds.user.username, ss.conn))
    case ss: SocketStopped => time(ss, handleSocketStopped(ss.socketId))

    case GetSystemStatus => time(GetSystemStatus, handleGetSystemStatus())

    case b: GameSupervisor.Broadcast => time(b, games.foreach(_._2.actorRef.tell(b.msg, self)))

    case im: InternalMessage => log.warn(s"Unhandled internal message [${im.getClass.getSimpleName}].")
    case x => log.warn(s"GameSupervisor encountered unknown message: ${x.toString}")
  }

  protected[this] def handleSocketStarted(socketId: UUID, userId: UUID, name: String, socket: ActorRef) = {
    log.info(s"Socket [game:$socketId] registered with path [${socket.path}].")
    games(socketId) = GameSupervisor.SocketRecord(socketId, userId, name, "game", socket, DateUtils.now)
    // gamesCount.inc()
  }

  protected[this] def handleSocketStopped(id: UUID) = {
    games.remove(id).foreach(sock => log.info(s"Game [$id] [${sock.actorRef.path}] removed."))
    // gamesCount.dec()
  }

  private[this] def handleStartGame(id: UUID, options: GameOptions, playerInfo: IndexedSeq[PlayerDetails]): ActorRef = {
    // context.actorOf(GameService.props(id = Some(id), options = options, playerInfo = playerInfo, Some(logService)), id.toString)
    ???
  }

  private[this] def handleGetSystemStatus() = {
    val channelStatuses = games.map(x => x._2.toDescription).toSeq.sortBy(_.name)
    sender().tell(SystemStatus(channelStatuses), self)
  }
}

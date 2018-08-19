package services.supervisor

import java.time.LocalDateTime
import java.util.UUID

import akka.actor.{Actor, ActorRef, OneForOneStrategy, SupervisorStrategy}
import models.InternalMessage.{GetSystemStatus, ConnectionStarted, ConnectionStopped, SystemStatus}
import models.options.GameOptions
import models.player.Player
import models.{InternalMessage, ResponseMessage}
import models.supervisor.ConnectionDescription
import services.game.GameService
import util.metrics.Instrumented
import util.{DateUtils, Logging}

object GameSupervisor {
  final case class Broadcast(msg: ResponseMessage)
  final case class StartGame(id: UUID, options: GameOptions, playerInfo: IndexedSeq[Player])

  final case class ConnectionRecord(id: UUID, userId: UUID, name: String, channel: String, actorRef: ActorRef, started: LocalDateTime) {
    def toDescription = ConnectionDescription(id, userId, name, channel, started)
  }
}

class GameSupervisor() extends Actor with Logging {
  private[this] val games = collection.mutable.HashMap.empty[UUID, GameSupervisor.ConnectionRecord]

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
    case ss: ConnectionStarted => time(ss, handleConnectionStarted(ss.id, ss.creds.user.id, ss.creds.user.username, ss.conn))
    case ss: ConnectionStopped => time(ss, handleConnectionStopped(ss.id))

    case GetSystemStatus => time(GetSystemStatus, handleGetSystemStatus())

    case b: GameSupervisor.Broadcast => time(b, games.foreach(_._2.actorRef.tell(b.msg, self)))

    case im: InternalMessage => log.warn(s"Unhandled internal message [${im.getClass.getSimpleName}].")
    case x => log.warn(s"GameSupervisor encountered unknown message: ${x.toString}")
  }

  protected[this] def handleConnectionStarted(id: UUID, userId: UUID, name: String, connection: ActorRef) = {
    log.info(s"Connection [game:$id] registered with path [${connection.path}].")
    games(id) = GameSupervisor.ConnectionRecord(id, userId, name, "game", connection, DateUtils.now)
    // gamesCount.inc()
  }

  protected[this] def handleConnectionStopped(id: UUID) = {
    games.remove(id).foreach(sock => log.info(s"Game [$id] [${sock.actorRef.path}] removed."))
    // gamesCount.dec()
  }

  private[this] def handleStartGame(id: UUID, options: GameOptions, playerInfo: IndexedSeq[Player]): ActorRef = {
    val ref = context.actorOf(GameService.props(id = Some(id), options = options), id.toString)
    playerInfo.foreach(ref ! _)
    ref
  }

  private[this] def handleGetSystemStatus() = {
    val channelStatuses = games.map(x => x._2.toDescription).toSeq.sortBy(_.name)
    sender().tell(SystemStatus(channelStatuses), self)
  }
}

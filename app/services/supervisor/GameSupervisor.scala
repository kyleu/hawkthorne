package services.supervisor

import java.time.LocalDateTime
import java.util.UUID

import akka.actor.{Actor, ActorRef, OneForOneStrategy, SupervisorStrategy}
import models.InternalMessage.{GameStatus, GetSystemStatus}
import models.options.GameOptions
import models.player.Player
import models.supervisor.GameDescription
import models.{InternalMessage, ResponseMessage}
import services.game.GameService
import util.Logging
import util.metrics.Instrumented

object GameSupervisor {
  final case class Broadcast(msg: ResponseMessage)
  final case class StartGame(id: UUID, options: GameOptions, playerInfo: IndexedSeq[Player])

  final case class GameRecord(id: UUID, options: GameOptions, actorRef: ActorRef, started: LocalDateTime) {
    def toDescription = GameDescription(id, options, started)
  }
}

class GameSupervisor() extends Actor with Logging {
  private[this] val games = collection.mutable.HashMap.empty[UUID, GameSupervisor.GameRecord]

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

    case GetSystemStatus => time(GetSystemStatus, handleGetSystemStatus())

    case b: GameSupervisor.Broadcast => time(b, games.foreach(_._2.actorRef.tell(b.msg, self)))

    case im: InternalMessage => log.warn(s"Unhandled internal message [${im.getClass.getSimpleName}].")
    case x => log.warn(s"GameSupervisor encountered unknown message: ${x.toString}")
  }

  private[this] def handleStartGame(id: UUID, options: GameOptions, playerInfo: IndexedSeq[Player]): ActorRef = {
    val ref = context.actorOf(GameService.props(id = Some(id), options = options), id.toString)
    playerInfo.foreach(ref ! _)
    ref
  }

  private[this] def handleGetSystemStatus() = sender().tell(GameStatus(games.map(x => x._2.toDescription).toSeq), self)
}

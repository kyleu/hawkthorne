package services.supervisor

import java.time.LocalDateTime
import java.util.UUID

import akka.actor.{Actor, ActorRef, OneForOneStrategy, SupervisorStrategy}
import models.InternalMessage.{GameStatus, GameTraceRequest, GetSystemStatus}
import models.ResponseMessage.ServerError
import models.game.GameServiceMessage
import models.options.GameOptions
import models.player.Player
import models.supervisor.GameDescription
import models.{InternalMessage, ResponseMessage}
import services.game.GameService
import util.Logging

object GameSupervisor {
  final case class Broadcast(game: Option[UUID], msg: ResponseMessage)
  final case class StartGame(id: UUID, options: GameOptions, initialPlayers: Seq[(ActorRef, Player)])

  final case class GameRecord(id: UUID, options: GameOptions, actorRef: ActorRef, started: LocalDateTime = util.DateUtils.now) {
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

  override def receive = {
    case b: GameSupervisor.Broadcast => games.filter(g => b.game.forall(_ == g._1)).foreach(_._2.actorRef.tell(b.msg, self))

    case sg: GameSupervisor.StartGame => startGame(sg.id, sg.options, sg.initialPlayers)

    case GetSystemStatus => sender().tell(GameStatus(games.map(x => x._2.toDescription).toSeq), self)
    case sgt: GameTraceRequest => handleSendGameTrace(sgt)

    case im: InternalMessage => log.warn(s"Unhandled game internal message [${im.getClass.getSimpleName}]")
    case x => log.warn(s"GameSupervisor encountered unknown message: [$x]")
  }

  private[this] def startGame(id: UUID, options: GameOptions, initialPlayers: Seq[(ActorRef, Player)]) = {
    games.get(id).foreach(r => throw new IllegalStateException(s"Game start attempt for [$id], which already exists"))

    val ref = context.actorOf(GameService.props(id = Some(id), options = options, gameSupervisor = self), id.toString)
    games(id) = GameSupervisor.GameRecord(id, options, ref)

    initialPlayers.foreach(p => ref.tell(GameServiceMessage.AddPlayer(p._2, p._1), self))

    log.info(s"Game supervisor started game [$id] with [${initialPlayers.size}] players; [${games.size}] running games")
  }

  private[this] def handleSendGameTrace(sgt: GameTraceRequest) = games.get(sgt.id) match {
    case Some(c) => c.actorRef forward sgt
    case None => sender().tell(ServerError("Unknown Game", sgt.id.toString), self)
  }
}

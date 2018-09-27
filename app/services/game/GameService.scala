package services.game

import java.util.UUID

import akka.actor.{Actor, ActorRef, Props}
import models.InternalMessage.GameTraceResponse
import models.ResponseMessage.GameJoined
import models.game.GameServiceMessage
import models.game.GameServiceMessage._
import models.game.cmd.GameCommand
import models.options.GameOptions
import models.player.Player
import models.{Application, InternalMessage}
import services.ServiceRegistry
import services.map.ServerMapCache
import util.Logging

object GameService {
  val frameRate = 60
  val frameTime = scala.concurrent.duration.FiniteDuration.apply(1000L / frameRate, java.util.concurrent.TimeUnit.MILLISECONDS)

  final case class Observer(id: UUID, name: String, actor: ActorRef)
  final case class UnhandledThrowable(msg: Any, t: Throwable)

  final case class PlayerEntry(idx: Int, player: Player, userId: UUID, actor: ActorRef)

  def props(id: Option[UUID], options: GameOptions, gameSupervisor: ActorRef, app: Application, services: ServiceRegistry) = {
    Props(new GameService(id.getOrElse(UUID.randomUUID), options, gameSupervisor, app, services))
  }
}

class GameService(id: UUID, options: GameOptions, gameSupervisor: ActorRef, app: Application, services: ServiceRegistry) extends Actor with Logging {
  private[this] var playerSeq = IndexedSeq.empty[GameService.PlayerEntry]

  private[this] val history = new GameHistoryHelper(services.historyServices)

  log.debug(s"Game [$id] started with options [$options]")

  val game = GameInstanceFactory.create(
    options = options,
    nodes = ServerMapCache(options.map).nodes,
    initialPlayers = Nil,
    collision = ServerMapCache(options.map).collision,
    log = log.info(_),
    notify = log.warn(_)
  )

  override def receive = {
    case ap: GameServiceMessage.AddPlayer => addPlayer(ap.p, ap.userId, ap.ref)
    case sgt: InternalMessage.GameTraceRequest => sender().tell(GameTraceResponse(game.toDebug), self)
    case x => throw new IllegalStateException(s"Unhandled game service message [$x]")
  }

  def addPlayer(p: Player, userId: UUID, actorRef: ActorRef) = {
    val idx = playerSeq.size
    val v = GameService.PlayerEntry(idx, p, userId, actorRef)
    playerSeq = playerSeq :+ v
    val cmd = GameCommand.AddPlayer(p, options.initialSpawn)
    val msgs = game.update(0, cmd)
    // TODO Something with messages...
    actorRef.tell(JoinedGame(self, GameJoined(id, options, playerSeq.map(_.player), idx)), self)
    if (idx == 0) {
      history.writeInitialGameHistory(game, playerSeq)
    }
  }

  override def postStop() = {
    game.stop()
    log.info(s"Game [$id] stopped")
  }

}

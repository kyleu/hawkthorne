package services.game

import java.util.UUID

import akka.actor.{Actor, ActorRef, Props}
import models.InternalMessage
import models.InternalMessage.GameTraceResponse
import models.ResponseMessage.GameJoined
import models.game.GameServiceMessage
import models.game.GameServiceMessage._
import models.options.GameOptions
import models.player.Player
import services.map.ServerMapCache
import util.Logging

object GameService {
  val frameRate = 60
  val frameTime = scala.concurrent.duration.FiniteDuration.apply(1000L / frameRate, java.util.concurrent.TimeUnit.MILLISECONDS)

  final case class Observer(id: UUID, name: String, actor: ActorRef)
  final case class UnhandledThrowable(msg: Any, t: Throwable)

  def props(id: Option[UUID], options: GameOptions, gameSupervisor: ActorRef) = {
    Props(new GameService(id.getOrElse(UUID.randomUUID), options, gameSupervisor))
  }
}

class GameService(id: UUID, options: GameOptions, gameSupervisor: ActorRef) extends Actor with Logging {
  private[this] var playerMap = Map.empty[UUID, (Int, Player, ActorRef)]
  private[this] var playerSeq = IndexedSeq.empty[(Player, ActorRef)]

  log.debug(s"Game [$id] started with options [$options]")

  val game = {
    val x = ServerMapCache(options.map)
    GameInstanceFactory.create(options = options, nodes = x.nodes, initialPlayers = Nil, collision = x.collision, log = log.info(_), notify = log.warn(_))
  }

  override def receive = {
    case ap: GameServiceMessage.AddPlayer => addPlayer(ap.p, ap.ref)
    case sgt: InternalMessage.GameTraceRequest => sender().tell(GameTraceResponse(game.toDebug), self)
    case x => throw new IllegalStateException(s"Unhandled game service message [$x]")
  }

  def addPlayer(p: Player, actorRef: ActorRef) = {
    val idx = playerSeq.size
    playerMap = playerMap + (p.id -> ((idx, p, actorRef)))
    playerSeq = playerSeq :+ (p -> actorRef)
    actorRef.tell(JoinedGame(self, GameJoined(id, options, playerSeq.map(_._1), idx)), self)
  }

  override def postStop() = {
    game.stop()
    log.info(s"Game [$id] stopped")
  }
}

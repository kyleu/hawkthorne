package services.game

import java.util.UUID

import akka.actor.{Actor, ActorRef, Props}
import models.options.GameOptions
import models.player.Player

object GameService {
  val frameRate = 60
  val frameTime = scala.concurrent.duration.FiniteDuration.apply(1000L / frameRate, java.util.concurrent.TimeUnit.MILLISECONDS)

  final case class PlayerDetails(p: Player, actorRef: ActorRef, connected: Boolean)

  final case class Observer(id: UUID, name: String, actor: ActorRef)
  final case class UnhandledThrowable(msg: Any, t: Throwable)

  def props(id: Option[UUID], options: GameOptions) = Props(new GameService(id.getOrElse(UUID.randomUUID), options))
}

class GameService(id: UUID, options: GameOptions) extends Actor {
  override def receive = {
    case x => throw new IllegalStateException(s"Unhandled message [$x]")
  }
}

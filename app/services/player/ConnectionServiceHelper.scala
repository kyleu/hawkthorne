package services.player

import java.util.UUID

import akka.actor.ActorRef
import models.ResponseMessage.{GameJoined, GameNotFound, SystemReady}
import models.game.GameServiceMessage
import models.options.GameOptions
import models.player.Player
import services.supervisor.GameSupervisor
import util.Logging

trait ConnectionServiceHelper extends Logging { this: ConnectionService =>
  private[this] var player: Option[Player] = None

  protected[this] var activeGameOpt: Option[(ActorRef, GameJoined)] = None

  protected[this] def withGame(ctx: String)(f: (ActorRef, GameJoined) => Unit) = activeGameOpt match {
    case Some(g) => f(g._1, g._2)
    case None => log.warn(s"Attempted to use active game for [$ctx], but no active game.")
  }

  protected[this] def setPlayer(p: Player) = {
    if (player.isEmpty) { out.tell(SystemReady, self) }
    player = Some(p)
  }
  protected[this] def getPlayer = player.getOrElse(throw new IllegalStateException("No active player for connection service."))

  protected[this] def startGame(id: UUID, options: GameOptions) = {
    gameSupervisor.tell(GameSupervisor.StartGame(id = id, options = options), self)
  }

  protected[this] def joinGame(id: UUID) = out.tell(GameNotFound(id), self)

  protected[this] def onGameStarted(actor: ActorRef, gs: GameJoined) = {
    activeGameOpt.foreach { g =>
      log.warn(s"Starting game [${gs.id}], though game [${g._2.id}] is already active.")
      g._1.tell(GameServiceMessage.Disconnect(g._2.playerIdx, "Started new game."), self)
    }
    activeGameOpt = Some(actor -> gs)
    out.tell(gs, self)
  }

  protected[this] def onGameComplete(gf: String) = {
    activeGameOpt = None
    out.tell(gf, self)
  }
}

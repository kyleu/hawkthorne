package services.player

import java.util.UUID

import akka.actor.ActorRef
import io.circe.Json
import models.InternalMessage.ClientTraceResponse
import models.ResponseMessage.{GameJoined, GameNotFound, SendClientTrace, SystemReady}
import models.analytics.AnalyticsActionType
import models.auth.Credentials
import models.game.GameServiceMessage
import models.options.GameOptions
import models.player.Player
import services.supervisor.GameSupervisor
import util.Logging

trait ConnectionServiceHelper extends Logging { this: ConnectionService =>
  // Game
  protected[this] var activeGameOpt: Option[(ActorRef, GameJoined)] = None

  protected[this] def startGame(id: UUID, options: GameOptions) = {
    gameSupervisor.tell(GameSupervisor.StartGame(id = id, options = options, initialPlayers = Seq((self, creds.user.id, player))), self)
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

  // Players
  private[this] var playerOpt: Option[Player] = None

  protected[this] def withGame(ctx: String)(f: (ActorRef, GameJoined) => Unit) = activeGameOpt match {
    case Some(g) => f(g._1, g._2)
    case None => log.warn(s"Attempted to use active game for [$ctx], but no active game.")
  }

  protected[this] def setPlayer(p: Player) = {
    if (playerOpt.isEmpty) { out.tell(SystemReady, self) }
    playerOpt = Some(p)
  }
  protected[this] def player = playerOpt.getOrElse(throw new IllegalStateException("No active player for connection service."))

  // Trace
  private[this] var pendingTrace: Option[ActorRef] = None

  protected[this] def sendClientTrace() = {
    pendingTrace = Some(sender())
    out.tell(SendClientTrace("full"), self)
  }

  protected[this] def returnClientTrace(payload: Json) = pendingTrace match {
    case Some(a) =>
      pendingTrace = None
      a.tell(ClientTraceResponse(id, payload), self)
    case None => throw new IllegalStateException("No pending client trace")
  }

  protected[this] def analytics(creds: Credentials, t: AnalyticsActionType, json: Json) = {
    services.analyticsService.onMessage(t = t, arg = json, credentials = creds, status = "OK")
  }
}

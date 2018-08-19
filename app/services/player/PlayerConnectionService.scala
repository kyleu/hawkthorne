package services.player

import java.util.UUID

import akka.actor.{Actor, ActorRef, Props, Timers}
import io.circe.Json
import models.InternalMessage.{ConnectionStarted, ConnectionStopped}
import models.RequestMessage._
import models.{InternalMessage, RequestMessage, ResponseMessage}
import models.ResponseMessage._
import models.analytics.AnalyticsActionType
import models.auth.Credentials
import models.game.GameServiceMessage
import util.{Config, Logging, Version}
import util.JsonSerializers._

object PlayerConnectionService {
  case class Callbacks(analytics: (AnalyticsActionType, Json) => Unit)

  def props(
    id: Option[UUID], playerSupervisor: ActorRef, matchmakingService: ActorRef, creds: Credentials, out: ActorRef,
    sourceAddr: String, callbacks: Callbacks
  ) = {
    Props(new PlayerConnectionService(id.getOrElse(UUID.randomUUID), playerSupervisor, matchmakingService, creds, out, sourceAddr, callbacks))
  }
}

class PlayerConnectionService(
    id: UUID, playerSupervisor: ActorRef, matchmakingService: ActorRef, creds: Credentials, out: ActorRef,
    sourceAddr: String, callbacks: PlayerConnectionService.Callbacks
) extends Actor with Timers with Logging {
  private[this] var activeGameOpt: Option[(ActorRef, GameStarted)] = None
  private[this] def withGame(ctx: String)(f: (ActorRef, GameStarted) => Unit) = activeGameOpt match {
    case Some(g) => f(g._1, g._2)
    case None => log.warn(s"Attempted to use active game for [$ctx], but no active game.")
  }

  override def preStart() = {
    log.info(s"Starting player connection for user [${creds.user.id}: ${creds.user.username}].")
    playerSupervisor.tell(ConnectionStarted(creds, "player", id, self), self)
    out.tell(UserSettings(creds.user.id, creds.user.username, creds.user.profile.providerID), self)
    callbacks.analytics(AnalyticsActionType.Connect, Json.obj("source" -> sourceAddr.asJson, "version" -> Version.version.asJson))
  }

  override def receive = {
    // System
    case mr: MalformedRequest => log.error(s"MalformedRequest:  [${mr.reason}]: [${mr.content}].")
    case p: Ping => out.tell(Pong(p.ts), self)
    case gv: GetVersion => out.tell(VersionResponse(Config.version), self)
    case dr: DebugRequest => onDebugRequest(dr)

    // Game Service
    case jg: JoinGame => out.tell(GameNotFound(jg.id), self)
    case gj: GameServiceMessage.GameJoined => onGameStarted(gj.actor, gj.gs)
    case gc: GameServiceMessage.GameComplete => onGameComplete(gc.gf)

    // Game Requests
    case pu: PlayerUpdate => withGame("playerUpdate")((a, g) => a.tell(GameServiceMessage.Update(g.playerIdx, pu), self))

    // Analytics
    case am: AnalyticsMessage => callbacks.analytics(am.t, am.arg)

    // Responses
    case rm: ResponseMessage => out.tell(rm, self)

    // Unhandled
    case im: InternalMessage => throw new IllegalArgumentException(s"Unhandled internal message [${im.getClass.getSimpleName}].")
    case rm: RequestMessage => throw new IllegalArgumentException(s"Unhandled request message [${rm.getClass.getSimpleName}].")
    case x => throw new IllegalArgumentException(s"Unhandled message with invalid class [${x.getClass.getSimpleName}].")
  }

  private[this] def onDebugRequest(dr: DebugRequest) = dr.t match {
    case "latency" => // TODO
    case _ => withGame("debugRequest")((a, g) => a.tell(GameServiceMessage.Debug(g.playerIdx, dr.t, dr.msg), self))
  }

  private[this] def onGameStarted(actor: ActorRef, gs: GameStarted) = {
    activeGameOpt.foreach { g =>
      log.warn(s"Starting game [${gs.id}], though game [${g._2.id}] is already active.")
      g._1.tell(GameServiceMessage.Disconnect(g._2.playerIdx, "Started new game."), self)
    }
    activeGameOpt = Some(actor -> gs)
    out.tell(gs, self)
  }

  def onGameComplete(gf: String) = {
    activeGameOpt = None
    out.tell(gf, self)
  }

  override def postStop() = {
    activeGameOpt.foreach(g => g._1.tell(GameServiceMessage.Disconnect(g._2.playerIdx, "Server shutdown"), self))
    playerSupervisor.tell(ConnectionStopped(id), self)
  }
}

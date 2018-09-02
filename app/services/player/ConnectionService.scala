package services.player

import java.util.UUID

import akka.actor.{Actor, ActorRef, Props, Timers}
import io.circe.Json
import models.InternalMessage.{ConnectionStarted, ConnectionStopped, SendClientTrace, SendConnectionTrace}
import models.RequestMessage._
import models.ResponseMessage._
import models.analytics.AnalyticsActionType
import models.auth.Credentials
import models.game.GameServiceMessage
import models.{InternalMessage, RequestMessage, ResponseMessage}
import util.JsonSerializers._
import util.{Config, Version}

object ConnectionService {
  case class Callbacks(analytics: (AnalyticsActionType, Json) => Unit)

  def props(
    id: Option[UUID], connSupervisor: ActorRef, gameSupervisor: ActorRef, creds: Credentials, out: ActorRef, sourceAddr: String, callbacks: Callbacks
  ) = {
    Props(new ConnectionService(id.getOrElse(UUID.randomUUID), connSupervisor, gameSupervisor, creds, out, sourceAddr, callbacks))
  }
}

class ConnectionService(
    id: UUID, connSupervisor: ActorRef, protected val gameSupervisor: ActorRef, creds: Credentials,
    protected val out: ActorRef, sourceAddr: String, callbacks: ConnectionService.Callbacks
) extends ConnectionServiceHelper with Actor with Timers {

  override def preStart() = {
    log.info(s"Starting player connection for user [${creds.user.id}: ${creds.user.username}].")
    connSupervisor.tell(ConnectionStarted(creds, "player", id, self), self)
    out.tell(UserSettings(creds.user.id, creds.user.username, creds.user.profile.providerID), self)
    callbacks.analytics(AnalyticsActionType.Connect, Json.obj("source" -> sourceAddr.asJson, "version" -> Version.version.asJson))
  }

  override def receive = {
    // System
    case mr: MalformedRequest => log.error(s"MalformedRequest:  [${mr.reason}]: [${mr.content}].")
    case p: Ping => out.tell(Pong(p.ts), self)
    case _: GetVersion => out.tell(VersionResponse(Config.version), self)
    case dr: DebugRequest => onDebugRequest(dr)
    case sp: SetPlayer => setPlayer(sp.player)
    case sct: SendConnectionTrace => sender().tell("!!!", self)
    case sct: SendClientTrace => sender().tell("!!!", self)

    // Analytics
    case am: AnalyticsMessage => callbacks.analytics(am.t, am.arg)

    // Game Service
    case sg: StartGame => startGame(sg.id, sg.options)
    case jg: JoinGame => joinGame(jg.id)
    case gj: GameServiceMessage.JoinedGame => onGameStarted(gj.actor, gj.gj)
    case gc: GameServiceMessage.CompletedGame => onGameComplete(gc.gf)

    // Game Requests
    case pu: PlayerUpdate => withGame("playerUpdate")((a, _) => a.tell(GameServiceMessage.Update(getPlayer.idx, pu), self))

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

  override def postStop() = {
    activeGameOpt.foreach(g => g._1.tell(GameServiceMessage.Disconnect(g._2.playerIdx, "Server shutdown"), self))
    connSupervisor.tell(ConnectionStopped(id), self)
  }
}

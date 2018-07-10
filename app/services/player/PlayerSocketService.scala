package services.player

import java.util.UUID

import akka.actor.{Actor, ActorRef, Props, Timers}
import io.prometheus.client.{Counter, Histogram}
import models.InternalMessage.{SocketStarted, SocketStopped}
import models.RequestMessage._
import models.{InternalMessage, RequestMessage, ResponseMessage}
import models.ResponseMessage._
import models.auth.Credentials
import models.game.GameServiceMessage
import util.metrics.Instrumented
import util.{Config, Logging}

object PlayerSocketService {
  def props(id: Option[UUID], playerSupervisor: ActorRef, creds: Credentials, out: ActorRef, sourceAddr: String) = {
    Props(new PlayerSocketService(id.getOrElse(UUID.randomUUID), playerSupervisor, creds, out, sourceAddr))
  }

  private lazy val metricsName = util.Config.projectId + "_player_socket_service"
  private lazy val receiveHistogram = Histogram.build(metricsName + "_receive", s"Message metrics for [$metricsName]").labelNames("msg").register()
  private lazy val errorCounter = Counter.build(metricsName + "_exception", s"Exception metrics for [$metricsName]").labelNames("msg", "ex").register()
}

class PlayerSocketService(
    id: UUID, playerSupervisor: ActorRef, creds: Credentials, out: ActorRef, sourceAddr: String
) extends Actor with Timers with Logging {
  private[this] var activeGameOpt: Option[(ActorRef, GameStarted)] = None
  private[this] def withGame(ctx: String)(f: (ActorRef, GameStarted) => Unit) = activeGameOpt match {
    case Some(g) => f(g._1, g._2)
    case None => log.warn(s"Attempted to use active game for [$ctx], but no active game.")
  }

  override def preStart() = {
    log.info(s"Starting player connection for user [${creds.user.id}: ${creds.user.username}].")
    playerSupervisor.tell(SocketStarted(creds, "player", id, self), self)
    out.tell(UserSettings(creds.user.id, creds.user.username, creds.user.profile.providerID), self)
  }

  private[this] def time(msg: Any, f: => Unit) = Instrumented.timeReceive(msg, msg.getClass.getSimpleName.stripSuffix("$"))(f)

  override def receive = {
    // System
    case mr: MalformedRequest => time(mr, log.error(s"MalformedRequest:  [${mr.reason}]: [${mr.content}]."))
    case p: Ping => time(p, out.tell(Pong(p.ts), self))
    case gv: GetVersion => time(gv, out.tell(VersionResponse(Config.version), self))
    case dr: DebugRequest => time(dr, onDebugRequest(dr))

    // Game Service
    case jg: JoinGame => time(jg, out.tell(GameNotFound(jg.id), self))
    case gj: GameServiceMessage.GameJoined => time(gj, onGameStarted(gj.actor, gj.gs))
    case gc: GameServiceMessage.GameComplete => time(gc, onGameComplete(gc.gf))

    // Game Requests
    case pu: PlayerUpdate => time(pu, withGame("playerUpdate")((a, g) => a.tell(GameServiceMessage.Update(g.playerIdx, pu), self)))

    // Responses
    case rm: ResponseMessage => time(rm, out.tell(rm, self))

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

  def onGameComplete(gf: GameFinished) = {
    activeGameOpt = None
    out.tell(gf, self)
  }

  override def postStop() = {
    activeGameOpt.foreach(g => g._1.tell(GameServiceMessage.Disconnect(g._2.playerIdx, "Socket disconnect."), self))
    playerSupervisor.tell(SocketStopped(id), self)
  }
}

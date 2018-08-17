package services.supervisor

import java.util.UUID

import akka.actor.{Actor, ActorRef, Props, Timers}
import models.InternalMessage.GetSystemStatus
import models.ResponseMessage.MatchmakingStatus
import models.RequestMessage.RegisterMatchmaking
import models.options.GameOptions
import models.player.Player
import models.supervisor.MatchmakingMessage
import services.supervisor.GameSupervisor.StartGame
import util.Logging

import scala.util.Random

object MatchmakingService {
  def props(gameSupervisor: ActorRef) = Props(new MatchmakingService(gameSupervisor))
  case class MatchmakingConnection(sessionTicket: UUID, player: Player, actorRef: ActorRef, msg: RegisterMatchmaking)

  case object Flush
}

class MatchmakingService(gameSupervisor: ActorRef) extends Actor with Timers with Logging {
  private[this] val tickets = collection.mutable.HashMap.empty[UUID, MatchmakingService.MatchmakingConnection]
  private[this] val registered = collection.mutable.HashMap.empty[GameOptions, collection.mutable.ArrayBuffer[MatchmakingService.MatchmakingConnection]]

  override def preStart() = {
    log.info(s"Starting matchmaking service.")
    val timeout = scala.concurrent.duration.FiniteDuration.apply(10L, java.util.concurrent.TimeUnit.SECONDS)
    timers.startPeriodicTimer(MatchmakingService.Flush, MatchmakingService.Flush, timeout)
  }

  private[this] def onRegister(player: Player, actorRef: ActorRef, msg: RegisterMatchmaking) = {
    log.info(s"Registering user [$player] for matchmaking with options [${msg.options}].")
    val sessionTicket = UUID.randomUUID
    //registered.find(_.userId == userId).foreach(x => throw new IllegalStateException(s"User [$userId] already registered for [$x]."))
    val current = registered.getOrElseUpdate(msg.options, collection.mutable.ArrayBuffer.empty[MatchmakingService.MatchmakingConnection])
    current += MatchmakingService.MatchmakingConnection(sessionTicket, player, actorRef, msg)

    if (current.size >= msg.minPlayers) {
      val players = current.take(msg.minPlayers)
      players.foreach(x => current.remove(current.indexOf(x)))
      startGame(UUID.randomUUID, msg.options, players)
    } else {
      actorRef.tell(MatchmakingStatus(sessionTicket, msg.options, current.map(_.player)), self)
    }
  }

  private[this] def onDeregister(playerId: UUID, sessionTicket: UUID) = tickets.get(sessionTicket) match {
    case Some(t) =>
      val reg = registered.getOrElse(t.msg.options, collection.mutable.ArrayBuffer.empty)
      reg.find(_.sessionTicket == sessionTicket) match {
        case Some(x) => reg.remove(reg.indexOf(x))
        case None => log.info(s"No session ticket [$sessionTicket] found in [${t.msg.options}].")
      }
    case None => log.info(s"Deregister request received for untracked session ticket [$sessionTicket].")
  }

  private[this] def flush() = registered.foreach(g => g._2.foreach { r =>
    r.actorRef.tell(MatchmakingStatus(r.sessionTicket, g._1, g._2.map(_.player)), self)
  })

  override def receive = {
    case MatchmakingService.Flush => flush()
    case GetSystemStatus => sender().tell(registered.mapValues(_.toSeq).toSeq, self)
    case reg: MatchmakingMessage.Register => onRegister(reg.player, reg.actorRef, reg.msg)
    case dereg: MatchmakingMessage.Deregister => onDeregister(dereg.playerId, dereg.sessionTicket)
    case x => log.info(s"Received unhandled matchmaking request [$x].")
  }

  def startGame(id: UUID, options: GameOptions, conns: Seq[MatchmakingService.MatchmakingConnection]) = {
    log.info(s"Starting game [$id] on map [${options.map.value}] and [${conns.size}] players.")

    val playerSet = Random.shuffle(conns.map(_.player)).toIndexedSeq

    gameSupervisor.tell(StartGame(id = id, options = options, playerInfo = playerSet), self)
  }
}

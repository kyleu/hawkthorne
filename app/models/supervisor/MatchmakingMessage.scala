package models.supervisor

import java.util.UUID

import akka.actor.ActorRef
import enumeratum.{CirceEnum, Enum, EnumEntry}
import models.RequestMessage.RegisterMatchmaking
import models.player.Player

sealed trait MatchmakingMessage extends EnumEntry

object MatchmakingMessage extends Enum[MatchmakingMessage] with CirceEnum[MatchmakingMessage] {
  case class Register(player: Player, actorRef: ActorRef, msg: RegisterMatchmaking) extends MatchmakingMessage
  case class Deregister(playerId: UUID, sessionTicket: UUID) extends MatchmakingMessage

  override val values = findValues
}

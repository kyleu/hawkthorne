package models.game

import akka.actor.ActorRef
import enumeratum.{CirceEnum, Enum, EnumEntry}
import models.RequestMessage.PlayerUpdate
import models.ResponseMessage.GameStarted
import models.player.Player

sealed trait GameServiceMessage extends EnumEntry

object GameServiceMessage extends Enum[GameServiceMessage] with CirceEnum[GameServiceMessage] {
  // Const
  case object Tick extends GameServiceMessage

  // In
  final case class AddPlayer(idx: Int, p: Player, ref: ActorRef)
  final case class Update(idx: Int, pu: PlayerUpdate) extends GameServiceMessage
  final case class Disconnect(idx: Int, msg: String) extends GameServiceMessage
  final case class Debug(playerIdx: Int, t: String, msg: String)

  // Out
  final case class GameJoined(actor: ActorRef, gs: GameStarted)
  final case class GameComplete(gf: String)

  override val values = findValues
}

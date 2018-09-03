package models.game

import akka.actor.ActorRef
import enumeratum.{CirceEnum, Enum, EnumEntry}
import io.circe.Json
import models.RequestMessage.PlayerUpdate
import models.ResponseMessage.GameJoined
import models.player.Player

sealed trait GameServiceMessage extends EnumEntry

object GameServiceMessage extends Enum[GameServiceMessage] with CirceEnum[GameServiceMessage] {
  // Const
  case object Tick extends GameServiceMessage

  // In
  final case class AddPlayer(p: Player, ref: ActorRef)
  final case class Update(idx: Int, pu: PlayerUpdate) extends GameServiceMessage
  final case class Disconnect(idx: Int, msg: String) extends GameServiceMessage
  final case class Debug(playerIdx: Int, t: String, payload: Json)

  // Out
  final case class JoinedGame(actor: ActorRef, gj: GameJoined)
  final case class CompletedGame(gf: String)

  override val values = findValues
}

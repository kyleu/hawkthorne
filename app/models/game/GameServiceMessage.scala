package models.game

import akka.actor.ActorRef
import enumeratum.{CirceEnum, Enum, EnumEntry}
import models.RequestMessage.PlayerUpdate
import models.ResponseMessage.{GameFinished, GameStarted}

sealed trait GameServiceMessage extends EnumEntry

object GameServiceMessage extends Enum[GameServiceMessage] with CirceEnum[GameServiceMessage] {
  // Const
  case object Tick extends GameServiceMessage

  // In
  case class Update(idx: Int, pu: PlayerUpdate) extends GameServiceMessage
  case class Disconnect(idx: Int, msg: String) extends GameServiceMessage
  case class Debug(playerIdx: Int, t: String, msg: String)

  // Out
  case class GameJoined(actor: ActorRef, gs: GameStarted)
  case class GameComplete(gf: GameFinished)

  override val values = findValues
}

package models.game

import java.util.UUID

import enumeratum.{CirceEnum, Enum, EnumEntry}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}
import models.player.Player

sealed trait GameMessage extends EnumEntry

object GameMessage extends Enum[GameMessage] with CirceEnum[GameMessage] {
  final case class PlayerAdded(idx: Int, player: Player) extends GameMessage
  final case class PlayerRemoved(idx: Int, id: UUID) extends GameMessage

  sealed trait PlayerMessage extends GameMessage {
    def idx: Int
  }

  final case class PlayerAnimationUpdated(override val idx: Int, anim: String) extends PlayerMessage
  final case class PlayerLocationUpdated(override val idx: Int, x: Double, y: Double) extends PlayerMessage

  final case class LeaveMap(idx: Int, src: String, dest: String) extends PlayerMessage

  final case class Notify(player: Option[Int], t: String, msgs: Seq[String]) extends GameMessage

  final case class Debug(t: String, msg: String) extends GameMessage

  implicit val jsonEncoder: Encoder[GameMessage] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameMessage] = deriveDecoder

  override val values = findValues
}


package models.game

import java.util.UUID

import enumeratum.{CirceEnum, Enum, EnumEntry}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}
import models.player.Player

sealed trait GameMessage extends EnumEntry

object GameMessage extends Enum[GameMessage] with CirceEnum[GameMessage] {
  sealed trait PlayerMessage extends GameMessage {
    def idx: Int
  }

  final case class PlayerAdded(idx: Int, player: Player) extends PlayerMessage
  final case class PlayerRemoved(idx: Int, id: UUID) extends PlayerMessage

  final case class PlayerAnimationUpdated(idx: Int, anim: String) extends PlayerMessage
  final case class PlayerLocationUpdated(idx: Int, x: Double, y: Double) extends PlayerMessage

  final case class Debug(id: UUID = UUID.randomUUID, t: String = "debug", msg: String = "") extends GameMessage

  implicit val jsonEncoder: Encoder[GameMessage] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameMessage] = deriveDecoder

  override val values = findValues
}


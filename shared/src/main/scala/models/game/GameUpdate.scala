package models.game

import java.util.UUID

import enumeratum.{CirceEnum, Enum, EnumEntry}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}
import models.input.InputCommand
import models.player.Player

sealed trait GameUpdate extends EnumEntry

object GameUpdate extends Enum[GameUpdate] with CirceEnum[GameUpdate] {
  sealed trait PlayerMessage extends GameUpdate { def idx: Int }
  final case class AddPlayer(override val idx: Int, player: Player) extends PlayerMessage
  final case class RemovePlayer(override val idx: Int, id: UUID) extends PlayerMessage
  final case class PlayerInput(override val idx: Int, x: Double, y: Double, commands: Seq[InputCommand]) extends PlayerMessage

  final case class Debug(id: UUID = UUID.randomUUID, t: String = "debug", msg: String = "") extends GameUpdate

  implicit val jsonEncoder: Encoder[GameUpdate] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameUpdate] = deriveDecoder

  override val values = findValues
}

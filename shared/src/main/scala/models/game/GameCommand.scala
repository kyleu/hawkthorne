package models.game

import java.util.UUID

import enumeratum.{CirceEnum, Enum, EnumEntry}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}
import models.input.InputCommand
import models.player.Player

sealed trait GameCommand extends EnumEntry

object GameCommand extends Enum[GameCommand] with CirceEnum[GameCommand] {
  final case class AddPlayer(player: Player) extends GameCommand
  final case class RemovePlayer(id: UUID) extends GameCommand

  sealed trait PlayerMessage extends GameCommand { def idx: Int }
  final case class PlayerInput(override val idx: Int, x: Double, y: Double, commands: Seq[InputCommand]) extends PlayerMessage

  final case class Debug(id: UUID = UUID.randomUUID, t: String = "debug", msg: String = "") extends GameCommand

  implicit val jsonEncoder: Encoder[GameCommand] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameCommand] = deriveDecoder

  override val values = findValues
}

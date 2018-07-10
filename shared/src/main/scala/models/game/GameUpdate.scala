package models.game

import java.util.UUID

import enumeratum.{CirceEnum, Enum, EnumEntry}
import io.circe.generic.semiauto.{deriveDecoder, deriveEncoder}
import io.circe.{Decoder, Encoder}

sealed trait GameUpdate extends EnumEntry

object GameUpdate extends Enum[GameUpdate] with CirceEnum[GameUpdate] {
  sealed trait PlayerMessage extends GameUpdate { def idx: Int }
  case class PlayerTest(override val idx: Int) extends PlayerMessage

  case class Debug(id: UUID = UUID.randomUUID, t: String = "debug", msg: String = "") extends GameUpdate

  implicit val jsonEncoder: Encoder[GameUpdate] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameUpdate] = deriveDecoder

  override val values = findValues
}

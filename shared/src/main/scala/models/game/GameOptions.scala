package models.game

import java.util.UUID
import util.JsonSerializers._

object GameOptions {
  implicit val jsonEncoder: Encoder[GameOptions] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameOptions] = deriveDecoder
}

case class GameOptions(
    id: UUID = UUID.randomUUID,
    maxPlayers: Int = 1,
    offline: Boolean = true
)

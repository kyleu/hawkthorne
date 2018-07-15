package models.game

import java.util.UUID

import models.data.map.TiledMap
import util.JsonSerializers._

object GameOptions {
  implicit val jsonEncoder: Encoder[GameOptions] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameOptions] = deriveDecoder
}

case class GameOptions(
    id: UUID = UUID.randomUUID,
    map: TiledMap,
    scenario: String,
    maxPlayers: Int = 1,
    offline: Boolean = true
)

package models.options

import models.data.map.TiledMap
import util.JsonSerializers._

object GameOptions {
  implicit val jsonEncoder: Encoder[GameOptions] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameOptions] = deriveDecoder
}

final case class GameOptions(
    map: TiledMap = TiledMap.StudyRoom,
    maxPlayers: Int = 1,
    hardcore: Boolean = false,
    offline: Boolean = true,
    debug: Boolean = true
)

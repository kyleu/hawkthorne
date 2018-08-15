package models.player

import util.JsonSerializers._

object PlayerAttributes {
  implicit val jsonEncoder: Encoder[PlayerAttributes] = deriveEncoder
  implicit val jsonDecoder: Decoder[PlayerAttributes] = deriveDecoder
}

case class PlayerAttributes(
    var health: Int = 100,
    var maxHealth: Int = 100,
    var connected: Boolean = false
)

package models.game

import util.JsonSerializers._

object GameObject {
  implicit val jsonEncoder: Encoder[GameObject] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameObject] = deriveDecoder
}

final case class GameObject(
    t: String,
    id: Int,
    n: String,
    var x: Double,
    var y: Double,
    var w: Int,
    var h: Int
)

package models.game.obj

import util.JsonSerializers._

object GameObject {
  implicit val jsonEncoder: Encoder[GameObject] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameObject] = deriveDecoder
}

case class GameObject(
    t: String,
    id: Int,
    n: String,
    var x: Int,
    var y: Int,
    var w: Int,
    var h: Int
)

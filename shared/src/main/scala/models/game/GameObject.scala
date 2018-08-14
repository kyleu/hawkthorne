package models.game

import util.JsonSerializers._

object GameObject {
  implicit val jsonEncoder: Encoder[GameObject] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameObject] = deriveDecoder
}

final case class GameObject(
    t: GameObjectType,
    id: Int,
    n: String,
    var x: Double,
    var y: Double,
    var w: Int,
    var h: Int,
    var vis: Boolean,
    src: String
)

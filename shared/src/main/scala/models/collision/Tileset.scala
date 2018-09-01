package models.collision

import util.JsonSerializers._

object Tileset {
  implicit val jsonEncoder: Encoder[Tileset] = deriveEncoder
  implicit val jsonDecoder: Decoder[Tileset] = deriveDecoder
}

case class Tileset(name: String, img: String, firstId: Int)

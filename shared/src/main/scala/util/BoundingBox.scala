package util

import util.JsonSerializers._

object BoundingBox {
  implicit val jsonEncoder: Encoder[BoundingBox] = deriveEncoder
  implicit val jsonDecoder: Decoder[BoundingBox] = deriveDecoder
}

final case class BoundingBox(width: Int, height: Int, duckHeight: Int, x: Int, y: Int)

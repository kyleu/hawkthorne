package util

import util.JsonSerializers._

object Point {
  implicit val jsonEncoder: Encoder[Point] = deriveEncoder
  implicit val jsonDecoder: Decoder[Point] = deriveDecoder
}

case class Point(x: Int, y: Int)

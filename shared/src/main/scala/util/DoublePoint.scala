package util

import util.JsonSerializers._

object DoublePoint {
  implicit val jsonEncoder: Encoder[DoublePoint] = deriveEncoder
  implicit val jsonDecoder: Decoder[DoublePoint] = deriveDecoder
}

final case class DoublePoint(x: Double, y: Double) {
  override def toString = s"($x, $y)"
}

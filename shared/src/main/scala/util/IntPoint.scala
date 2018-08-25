package util

import util.JsonSerializers._

object IntPoint {
  implicit val jsonEncoder: Encoder[IntPoint] = deriveEncoder
  implicit val jsonDecoder: Decoder[IntPoint] = deriveDecoder
}

final case class IntPoint(x: Int, y: Int) {
  def toDoublePoint = DoublePoint(x.toDouble, y.toDouble)
  def tupled = x -> y
}

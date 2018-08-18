package util

import util.JsonSerializers._

object BoundingBox {
  implicit val jsonEncoder: Encoder[BoundingBox] = deriveEncoder
  implicit val jsonDecoder: Decoder[BoundingBox] = deriveDecoder
}

final case class BoundingBox(width: Int, height: Int, duckHeight: Int, x: Int, y: Int) {
  def at(xx: Double, yy: Double, isDucking: Boolean) = (if (isDucking) { rectangle } else { duckRectangle }).at(xx, yy)

  val rectangle = Rectangle(x.toDouble, y.toDouble, width, height)
  val duckRectangle = Rectangle(x.toDouble, y.toDouble, width, duckHeight)
}

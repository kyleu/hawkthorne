package util

import util.JsonSerializers._

object Rectangle {
  implicit val jsonEncoder: Encoder[Rectangle] = deriveEncoder
  implicit val jsonDecoder: Decoder[Rectangle] = deriveDecoder
}

case class Rectangle(x: Double, y: Double, w: Int, h: Int) {
  def right = x + w
  def bottom = y + h
  def empty = w == 0 || h == 0

  def at(xDelta: Double, yDelta: Double) = Rectangle.apply(x + xDelta, y + yDelta, w, h)

  def intersects(r: Rectangle) = if (empty || r.empty) {
    false
  } else {
    !(right < r.x || bottom < r.y || x > r.right || y > r.bottom)
  }

  override def toString = s"$x,$y/${w}x$h"
}

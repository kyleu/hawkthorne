package models.game.obj

import util.JsonSerializers._
import util.Rectangle

object GameObject {
  implicit val jsonEncoder: Encoder[GameObject] = GameObjectEncoder.jsonEncoder
  implicit val jsonDecoder: Decoder[GameObject] = GameObjectDecoder.jsonDecoder
}

abstract class GameObject(val t: String) {
  def id: Int
  def n: String
  def loc: Rectangle
  def vis: Boolean
}

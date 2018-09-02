package models.node

import models.asset.Asset
import models.game.obj.{GameObject, WorkInProgress}
import util.JsonSerializers._

object Node {
  implicit val jsonEncoder: Encoder[Node] = NodeEncoder.jsonEncoder
  implicit val jsonDecoder: Decoder[Node] = NodeDecoder.jsonDecoder
}

abstract class Node(val t: String) {
  def id: Int
  def name: String
  def x: Int
  def y: Int
  def width: Int
  def height: Int
  def rotation: Int
  def visible: Boolean

  def assets = Seq.empty[Asset]
  def update(deltaMs: Double) = {}

  def actualName = if (name.trim.isEmpty) { id.toString } else { name }

  def actualX = x
  def actualY = y
  def pos = actualX -> actualY

  def actualWidth = width
  def actualHeight = height
  def size = actualWidth -> actualHeight

  def asLocation = util.Rectangle(x = actualX.toDouble, y = actualY.toDouble, w = actualWidth, h = actualHeight)

  def asNewGameObject: Seq[GameObject] = Seq.empty[GameObject]
}

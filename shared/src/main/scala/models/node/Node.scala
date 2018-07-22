package models.node

import models.asset.Asset
import models.game.GameObject
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

  def actualWidth = width
  def actualHeight = height

  def asNewGameObject = GameObject(t = getClass.getSimpleName, id = id, n = name, x = actualX.toDouble, y = actualY.toDouble, w = actualWidth, h = actualHeight)
}

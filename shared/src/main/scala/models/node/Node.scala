package models.node

import models.asset.Asset
import util.JsonSerializers._

object Node {
  object Point {
    implicit val jsonEncoder: Encoder[Point] = deriveEncoder
    implicit val jsonDecoder: Decoder[Point] = deriveDecoder
  }

  case class Point(x: Int, y: Int)

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

  def actualName = if (name.trim.isEmpty) { s"$t.$id" } else { name }

  def actualX = x
  def actualY = y

  def actualWidth = width
  def actualHeight = height
}

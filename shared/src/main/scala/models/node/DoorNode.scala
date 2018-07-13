package models.node

import util.JsonSerializers._

object DoorNode {
  val key = "door"
  implicit val jsonEncoder: Encoder[DoorNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[DoorNode] = deriveDecoder
}

case class DoorNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0,
    visible: Boolean
) extends Node(DoorNode.key, x, y, width, height)

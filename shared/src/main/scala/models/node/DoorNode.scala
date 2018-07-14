package models.node

import util.JsonSerializers._

object DoorNode {
  val key = "door"
  implicit val jsonEncoder: Encoder[DoorNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[DoorNode] = deriveDecoder
}

case class DoorNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    visible: Boolean
) extends Node(DoorNode.key)

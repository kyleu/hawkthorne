package models.node

import util.JsonSerializers._

object CowNode {
  val key = "cow"
  implicit val jsonEncoder: Encoder[CowNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[CowNode] = deriveDecoder
}

case class CowNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(CowNode.key, x, y, width, height)

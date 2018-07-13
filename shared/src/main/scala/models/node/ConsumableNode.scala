package models.node

import util.JsonSerializers._

object ConsumableNode {
  val key = "consumable"
  implicit val jsonEncoder: Encoder[ConsumableNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[ConsumableNode] = deriveDecoder
}

case class ConsumableNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(ConsumableNode.key, x, y, width, height)

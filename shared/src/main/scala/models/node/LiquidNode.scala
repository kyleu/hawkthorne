package models.node

import util.JsonSerializers._

object LiquidNode {
  val key = "liquid"
  implicit val jsonEncoder: Encoder[LiquidNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[LiquidNode] = deriveDecoder
}

case class LiquidNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0,
    visible: Boolean
) extends Node(LiquidNode.key, x, y, width, height)

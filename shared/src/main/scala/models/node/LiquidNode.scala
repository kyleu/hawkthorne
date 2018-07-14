package models.node

import util.JsonSerializers._

object LiquidNode {
  val key = "liquid"
  implicit val jsonEncoder: Encoder[LiquidNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[LiquidNode] = deriveDecoder
}

case class LiquidNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    visible: Boolean
) extends Node(LiquidNode.key)

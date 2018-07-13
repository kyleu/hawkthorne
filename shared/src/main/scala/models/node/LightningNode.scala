package models.node

import util.JsonSerializers._

object LightningNode {
  val key = "lightning"
  implicit val jsonEncoder: Encoder[LightningNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[LightningNode] = deriveDecoder
}

case class LightningNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(LightningNode.key, x, y, width, height)

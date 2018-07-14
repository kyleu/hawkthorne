package models.node

import util.JsonSerializers._

object LightningNode {
  val key = "lightning"
  implicit val jsonEncoder: Encoder[LightningNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[LightningNode] = deriveDecoder
}

case class LightningNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(LightningNode.key)

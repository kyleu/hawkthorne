package models.node

import util.JsonSerializers._

object HSpriteNode {
  val key = "h_sprite"
  implicit val jsonEncoder: Encoder[HSpriteNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[HSpriteNode] = deriveDecoder
}

case class HSpriteNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(HSpriteNode.key)

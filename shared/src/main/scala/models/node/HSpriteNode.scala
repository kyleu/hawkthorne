package models.node

import util.JsonSerializers._

object HSpriteNode {
  val key = "h_sprite"
  implicit val jsonEncoder: Encoder[HSpriteNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[HSpriteNode] = deriveDecoder
}

case class HSpriteNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(HSpriteNode.key, x, y, width, height)

package models.node

import util.JsonSerializers._

object SpriteNode {
  val key = "sprite"
  implicit val jsonEncoder: Encoder[SpriteNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SpriteNode] = deriveDecoder
}

case class SpriteNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(SpriteNode.key, x, y, width, height)

package models.node

import util.JsonSerializers._

object KeyNode {
  val key = "key"
  implicit val jsonEncoder: Encoder[KeyNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[KeyNode] = deriveDecoder
}

case class KeyNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(KeyNode.key, x, y, width, height)

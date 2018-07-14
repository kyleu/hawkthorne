package models.node

import util.JsonSerializers._

object KeyNode {
  val key = "key"
  implicit val jsonEncoder: Encoder[KeyNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[KeyNode] = deriveDecoder
}

case class KeyNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(KeyNode.key)

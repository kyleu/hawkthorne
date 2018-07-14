package models.node

import util.JsonSerializers._

object SimpleNode {
  val key = "simple"
  implicit val jsonEncoder: Encoder[SimpleNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SimpleNode] = deriveDecoder
}

case class SimpleNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(SimpleNode.key)

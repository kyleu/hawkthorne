package models.node

import util.JsonSerializers._

object SimpleNode {
  val key = "simple"
  implicit val jsonEncoder: Encoder[SimpleNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SimpleNode] = deriveDecoder
}

case class SimpleNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(SimpleNode.key, x, y, width, height)

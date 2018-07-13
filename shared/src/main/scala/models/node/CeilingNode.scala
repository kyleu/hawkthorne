package models.node

import util.JsonSerializers._

object CeilingNode {
  val key = "ceiling"
  implicit val jsonEncoder: Encoder[CeilingNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[CeilingNode] = deriveDecoder
}

case class CeilingNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(CeilingNode.key, x, y, width, height)

package models.node

import util.JsonSerializers._

object CeilingHippyNode {
  val key = "ceiling_hippy"
  implicit val jsonEncoder: Encoder[CeilingHippyNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[CeilingHippyNode] = deriveDecoder
}

case class CeilingHippyNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(CeilingHippyNode.key, x, y, width, height)

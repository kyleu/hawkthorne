package models.node

import util.JsonSerializers._

object CeilingHippyNode {
  val key = "ceiling_hippy"
  implicit val jsonEncoder: Encoder[CeilingHippyNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[CeilingHippyNode] = deriveDecoder
}

case class CeilingHippyNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(CeilingHippyNode.key)

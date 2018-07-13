package models.node

import util.JsonSerializers._

object SplatNode {
  val key = "splat"
  implicit val jsonEncoder: Encoder[SplatNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SplatNode] = deriveDecoder
}

case class SplatNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(SplatNode.key, x, y, width, height)

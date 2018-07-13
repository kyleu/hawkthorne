package models.node

import util.JsonSerializers._

object CauldronNode {
  val key = "cauldron"
  implicit val jsonEncoder: Encoder[CauldronNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[CauldronNode] = deriveDecoder
}

case class CauldronNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(CauldronNode.key, x, y, width, height)

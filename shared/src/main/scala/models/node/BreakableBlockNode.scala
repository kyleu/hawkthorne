package models.node

import util.JsonSerializers._

object BreakableBlockNode {
  val key = "breakable_block"
  implicit val jsonEncoder: Encoder[BreakableBlockNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[BreakableBlockNode] = deriveDecoder
}

case class BreakableBlockNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(BreakableBlockNode.key, x, y, width, height)

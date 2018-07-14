package models.node

import util.JsonSerializers._

object BreakableBlockNode {
  val key = "breakable_block"
  implicit val jsonEncoder: Encoder[BreakableBlockNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[BreakableBlockNode] = deriveDecoder
}

case class BreakableBlockNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(BreakableBlockNode.key)

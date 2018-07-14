package models.node

import util.JsonSerializers._

object CauldronNode {
  val key = "cauldron"
  implicit val jsonEncoder: Encoder[CauldronNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[CauldronNode] = deriveDecoder
}

case class CauldronNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(CauldronNode.key)

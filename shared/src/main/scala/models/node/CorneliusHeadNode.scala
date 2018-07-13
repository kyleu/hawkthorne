package models.node

import util.JsonSerializers._

object CorneliusHeadNode {
  val key = "cornelius_head"
  implicit val jsonEncoder: Encoder[CorneliusHeadNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[CorneliusHeadNode] = deriveDecoder
}

case class CorneliusHeadNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(CorneliusHeadNode.key, x, y, width, height)

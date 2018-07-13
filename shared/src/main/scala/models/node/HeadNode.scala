package models.node

import util.JsonSerializers._

object HeadNode {
  val key = "head"
  implicit val jsonEncoder: Encoder[HeadNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[HeadNode] = deriveDecoder
}

case class HeadNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(HeadNode.key, x, y, width, height)

package models.node

import util.JsonSerializers._

object HeadNode {
  val key = "head"
  implicit val jsonEncoder: Encoder[HeadNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[HeadNode] = deriveDecoder
}

case class HeadNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(HeadNode.key)

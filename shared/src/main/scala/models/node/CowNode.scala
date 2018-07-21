package models.node

import util.JsonSerializers._

object CowNode {
  val key = "cow"
  implicit val jsonEncoder: Encoder[CowNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[CowNode] = deriveDecoder
}

case class CowNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean
) extends Node(CowNode.key)

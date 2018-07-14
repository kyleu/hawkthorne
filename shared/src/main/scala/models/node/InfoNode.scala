package models.node

import util.JsonSerializers._

object InfoNode {
  val key = "info"
  implicit val jsonEncoder: Encoder[InfoNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[InfoNode] = deriveDecoder
}

case class InfoNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(InfoNode.key)

package models.node

import util.JsonSerializers._

object InfoNode {
  val key = "info"
  implicit val jsonEncoder: Encoder[InfoNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[InfoNode] = deriveDecoder
}

case class InfoNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(InfoNode.key, x, y, width, height)

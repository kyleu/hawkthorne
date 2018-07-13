package models.node

import util.JsonSerializers._

object DetailNode {
  val key = "detail"
  implicit val jsonEncoder: Encoder[DetailNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[DetailNode] = deriveDecoder
}

case class DetailNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(DetailNode.key, x, y, width, height)

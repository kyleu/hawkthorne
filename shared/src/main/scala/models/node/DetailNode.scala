package models.node

import util.JsonSerializers._

object DetailNode {
  val key = "detail"
  implicit val jsonEncoder: Encoder[DetailNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[DetailNode] = deriveDecoder
}

case class DetailNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(DetailNode.key)

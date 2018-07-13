package models.node

import util.JsonSerializers._

object DealerNode {
  val key = "dealer"
  implicit val jsonEncoder: Encoder[DealerNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[DealerNode] = deriveDecoder
}

case class DealerNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(DealerNode.key, x, y, width, height)

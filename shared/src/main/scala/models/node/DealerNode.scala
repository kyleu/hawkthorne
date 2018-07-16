package models.node

import util.JsonSerializers._

object DealerNode {
  val key = "dealer"
  implicit val jsonEncoder: Encoder[DealerNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[DealerNode] = deriveDecoder
}

case class DealerNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Option[Int],
    override val visible: Option[Boolean]
) extends Node(DealerNode.key)

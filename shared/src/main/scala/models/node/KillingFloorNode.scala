package models.node

import util.JsonSerializers._

object KillingFloorNode {
  val key = "killing_floor"
  implicit val jsonEncoder: Encoder[KillingFloorNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[KillingFloorNode] = deriveDecoder
}

case class KillingFloorNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(KillingFloorNode.key, x, y, width, height)

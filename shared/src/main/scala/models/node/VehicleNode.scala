package models.node

import util.JsonSerializers._

object VehicleNode {
  val key = "vehicle"
  implicit val jsonEncoder: Encoder[VehicleNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[VehicleNode] = deriveDecoder
}

case class VehicleNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(VehicleNode.key, x, y, width, height)

package models.node

import util.JsonSerializers._

object VehicleNode {
  val key = "vehicle"
  implicit val jsonEncoder: Encoder[VehicleNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[VehicleNode] = deriveDecoder
}

case class VehicleNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(VehicleNode.key)

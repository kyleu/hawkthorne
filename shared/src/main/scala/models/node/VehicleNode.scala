package models.node

import models.asset.Asset
import models.template.vehicle.VehicleTemplate
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
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean
) extends Node(VehicleNode.key) {
  val template = VehicleTemplate.withKey(actualName)
  override val assets = Seq(
    Asset.Spritesheet(s"vehicle.$actualName", s"images/vehicles/$actualName.png", template.width, template.height)
  )
}


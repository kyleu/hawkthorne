package models.node

import models.game.obj.KillingFloor
import util.JsonSerializers._

object KillingFloorNode {
  val key = "killing_floor"
  implicit val jsonEncoder: Encoder[KillingFloorNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[KillingFloorNode] = deriveDecoder
}

final case class KillingFloorNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean
) extends Node(KillingFloorNode.key) {
  override def asNewGameObject = Seq(KillingFloor(id = id, n = actualName, loc = asLocation, vis = visible))
}

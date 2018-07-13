package models.node

import util.JsonSerializers._

object WeaponNode {
  val key = "weapon"
  implicit val jsonEncoder: Encoder[WeaponNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[WeaponNode] = deriveDecoder
}

case class WeaponNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(WeaponNode.key, x, y, width, height)

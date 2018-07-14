package models.node

import util.JsonSerializers._

object WeaponNode {
  val key = "weapon"
  implicit val jsonEncoder: Encoder[WeaponNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[WeaponNode] = deriveDecoder
}

case class WeaponNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(WeaponNode.key)

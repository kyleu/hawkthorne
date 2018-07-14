package models.node

import util.JsonSerializers._

object ProjectileNode {
  val key = "projectile"
  implicit val jsonEncoder: Encoder[ProjectileNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[ProjectileNode] = deriveDecoder
}

case class ProjectileNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(ProjectileNode.key)

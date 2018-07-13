package models.node

import util.JsonSerializers._

object ProjectileNode {
  val key = "projectile"
  implicit val jsonEncoder: Encoder[ProjectileNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[ProjectileNode] = deriveDecoder
}

case class ProjectileNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(ProjectileNode.key, x, y, width, height)

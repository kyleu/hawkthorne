package models.node

import util.JsonSerializers._

object ProjectileNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(
      direction: Option[String],
      persistent: Option[String],
      foreground: Option[String]
  )

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
    override val height: Int,
    override val rotation: Option[Int],
    override val visible: Option[Boolean],
    properties: ProjectileNode.Props
) extends Node(ProjectileNode.key)

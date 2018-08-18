package models.node

import models.asset.Asset
import models.game.obj.Projectile
import models.template.projectile.ProjectileListing
import util.JsonSerializers._

object ProjectileNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  final case class Props(
      direction: Option[String],
      persistent: Option[String],
      foreground: Option[String]
  )

  val key = "projectile"
  implicit val jsonEncoder: Encoder[ProjectileNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[ProjectileNode] = deriveDecoder
}

final case class ProjectileNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: ProjectileNode.Props
) extends Node(ProjectileNode.key) {
  if (name.isEmpty) { throw new NotImplementedError() }
  val template = ProjectileListing.withKey(name)
  override val assets = Seq(Asset.Spritesheet(s"$t.$name", s"images/weapons/$name.png", template.width, template.height))
  override def asNewGameObject = Seq(Projectile(id = id, n = actualName, loc = asLocation, vis = visible))
}

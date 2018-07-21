package models.node

import models.asset.Asset
import util.JsonSerializers._

object ProjectileNode {
  def widthFor(name: String) = name match {
    case "baseball" => 9
    case _ => throw new IllegalStateException(s"Unhandled projectile [$name]")
  }

  def heightFor(name: String) = name match {
    case _ => widthFor(name)
  }

  def framesFor(name: String) = name match {
    case _ => 2
  }

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
    override val rotation: Int,
    override val visible: Boolean,
    properties: ProjectileNode.Props
) extends Node(ProjectileNode.key) {
  if (name.isEmpty) { throw new NotImplementedError() }
  override val assets = Seq(Asset.Spritesheet(s"projectile.$name", s"images/weapons/$name.png", ProjectileNode.widthFor(name), ProjectileNode.heightFor(name)))
}

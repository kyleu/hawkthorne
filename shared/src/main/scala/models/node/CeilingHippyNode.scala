package models.node

import models.asset.Asset
import util.JsonSerializers._

object CeilingHippyNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(delay: Option[String], prob: Option[String], proximity: Option[String])

  val key = "ceiling_hippy"
  implicit val jsonEncoder: Encoder[CeilingHippyNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[CeilingHippyNode] = deriveDecoder
}

case class CeilingHippyNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: Option[CeilingHippyNode.Props]
) extends Node(CeilingHippyNode.key) {
  override def assets = Seq(
    Asset.Image(s"hippy.open.ceiling", s"images/sprites/greendale/open_ceiling.png"),
    Asset.Image(s"hippy.broken.tiles", s"images/sprites/greendale/broken_tiles.png"),
    Asset.Spritesheet(s"enemy.ceiling.hippy", s"images/enemies/hippy.png", 48, 48),
    Asset.sfx(s"hippy_enter")
  )
}

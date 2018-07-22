package models.node

import models.asset.Asset
import models.template.weapon.WeaponTemplate
import util.JsonSerializers._

object WeaponNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(direction: Option[String], flipY: Option[String], foreground: Option[String], sprite: Option[String])

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
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: Option[WeaponNode.Props]
) extends Node(WeaponNode.key) {
  val template = WeaponTemplate.withKey(actualName)
  override val assets = Seq(Asset.Spritesheet(s"weapon.$actualName", s"images/weapons/$actualName.png", template.width, template.height)) ++
    template.hitAudioClip.map(Asset.sfx) ++
    template.swingAudioClip.map(Asset.sfx) ++
    template.unuseAudioClip.map(Asset.sfx)
}

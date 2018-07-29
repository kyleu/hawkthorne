package models.node

import models.asset.Asset
import util.JsonSerializers._

object MovingPlatformNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  final case class Props(
      anim_speed: Option[String],
      animation: Option[String],
      chain: Option[String],
      direction: Option[String],
      drop: Option[String],
      height: Option[String],
      line: String,
      mode: Option[String],
      noise_radius: Option[String],
      offscreen: Option[String],
      offset_x: Option[String],
      offset_y: Option[String],
      restart: Option[String],
      sfx: Option[String],
      singleuse: Option[String],
      speed: Option[String],
      sprite: String,
      start: Option[String],
      touchstart: Option[String],
      width: Option[String]

  )

  val key = "movingplatform"
  implicit val jsonEncoder: Encoder[MovingPlatformNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[MovingPlatformNode] = deriveDecoder
}

final case class MovingPlatformNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: MovingPlatformNode.Props
) extends Node(MovingPlatformNode.key) {
  override def actualName = if (name.isEmpty) { properties.sprite.substring(properties.sprite.lastIndexOf('/') + 1).stripSuffix(".png") } else { name }
  val sheetKey = "sprite." + actualName
  override lazy val assets = Seq(Asset.Image(sheetKey, properties.sprite))
}

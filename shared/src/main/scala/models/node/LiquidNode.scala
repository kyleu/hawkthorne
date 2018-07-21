package models.node

import models.asset.Asset
import util.JsonSerializers._

object LiquidNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(
      death: Option[String],
      drag: Option[String],
      drown: Option[String],
      foreground: Option[String],
      injure: Option[String],
      mask: Option[String],
      mode: Option[String],
      opacity: Option[String],
      oscillating: Option[String],
      speed: Option[String],
      sprite: String,
      uniform: Option[String]
  )

  val key = "liquid"
  implicit val jsonEncoder: Encoder[LiquidNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[LiquidNode] = deriveDecoder
}

case class LiquidNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: LiquidNode.Props
) extends Node(LiquidNode.key) {
  val sheetKey = "sprite." + properties.sprite.substring(properties.sprite.lastIndexOf('/') + 1).stripSuffix(".png")

  val topFrames = 0 until width / 24
  val bottomFrames = (width / 24) until (width / 24 * 2)
  val opacityDouble = properties.opacity.map(_.toDouble).getOrElse(1.0)

  override lazy val assets = Seq(Asset.Spritesheet(sheetKey, properties.sprite, 24, 24))
}

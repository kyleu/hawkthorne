package models.node

import models.animation.{Animation, AnimationCoords}
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
    override val rotation: Option[Int],
    override val visible: Option[Boolean],
    properties: LiquidNode.Props
) extends Node(LiquidNode.key) {
  val sheetKey = "sprite." + properties.sprite.substring(properties.sprite.lastIndexOf('/') + 1).stripSuffix(".png")

  val topAnimation = Animation(id = s"anim.$id", frames = IndexedSeq(0, 1, 2), delay = properties.speed.map(_.toDouble).getOrElse(1.0), loop = true)
  val bottomAnimation = Animation(id = s"anim.$id", frames = IndexedSeq(3, 4, 5), delay = properties.speed.map(_.toDouble).getOrElse(1.0), loop = true)

  override lazy val assets = Seq(Asset.Spritesheet(sheetKey, properties.sprite, 24, 24))
}

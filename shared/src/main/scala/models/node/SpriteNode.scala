package models.node

import models.animation.Animation
import models.asset.Asset
import util.JsonSerializers._

object SpriteNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(
      animation: Option[String],
      random: Option[String],
      speed: Option[String],
      depth: Option[String],
      direction: Option[String],
      sheet: String
  )

  val key = "sprite"
  implicit val jsonEncoder: Encoder[SpriteNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SpriteNode] = deriveDecoder
}

case class SpriteNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    rotation: Int,
    visible: Boolean,
    properties: SpriteNode.Props
) extends Node(SpriteNode.key) {
  val sheetKey = "sprite." + properties.sheet.substring(properties.sheet.lastIndexOf('/') + 1).stripSuffix(".png")
  val animation = properties.animation.map { a =>
    Animation(s"anim.$id", IndexedSeq(0, 1, 2, 3, 4, 5, 6, 7), 0.1)
  }

  override lazy val assets = Seq(Asset.Spritesheet(sheetKey, properties.sheet, width, height))
}

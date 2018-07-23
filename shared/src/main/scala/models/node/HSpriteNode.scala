package models.node

import models.animation.Animation
import models.asset.Asset
import util.JsonSerializers._

object HSpriteNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(
      animation: String,
      height: Option[String],
      sheet: String,
      speed: Option[String],
      width: Option[String]
  )

  val key = "h_sprite"
  implicit val jsonEncoder: Encoder[HSpriteNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[HSpriteNode] = deriveDecoder
}

case class HSpriteNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: HSpriteNode.Props
) extends Node(HSpriteNode.key) {
  val sheetKey = "hsprite." + properties.sheet.substring(properties.sheet.lastIndexOf('/') + 1).stripSuffix(".png")
  val animation = Animation.fromString(id = actualName, s = properties.animation, speed = 0.1, loop = false)

  override def actualName = if (name.trim.isEmpty) { s"$sheetKey.$id" } else { name }

  override lazy val assets = Seq(Asset.Spritesheet(sheetKey, properties.sheet, actualWidth, actualHeight))
}

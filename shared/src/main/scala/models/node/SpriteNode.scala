package models.node

import util.JsonSerializers._

object SpriteNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(depth: Option[String], direction: Option[String], sheet: String)

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
}

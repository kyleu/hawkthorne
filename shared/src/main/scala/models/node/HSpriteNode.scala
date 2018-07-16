package models.node

import util.JsonSerializers._

object HSpriteNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(
      animation: Option[String],
      height: Option[String],
      sheet: Option[String],
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
    override val rotation: Option[Int],
    override val visible: Option[Boolean],
    properties: HSpriteNode.Props
) extends Node(HSpriteNode.key)

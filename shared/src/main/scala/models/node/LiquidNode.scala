package models.node

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
      sprite: Option[String],
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
) extends Node(LiquidNode.key)

package models.node

import util.JsonSerializers._

object HiddenDoorTriggerNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(
      height: Option[String],
      message: Option[String],
      needKey: Option[String],
      sprite: Option[String],
      target: Option[String],
      width: Option[String]
  )

  val key = "hiddendoortrigger"
  implicit val jsonEncoder: Encoder[HiddenDoorTriggerNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[HiddenDoorTriggerNode] = deriveDecoder
}

case class HiddenDoorTriggerNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Option[Int],
    override val visible: Option[Boolean],
    properties: HiddenDoorTriggerNode.Props
) extends Node(HiddenDoorTriggerNode.key)

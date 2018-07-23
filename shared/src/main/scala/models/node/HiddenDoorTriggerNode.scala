package models.node

import models.asset.Asset
import util.JsonSerializers._

object HiddenDoorTriggerNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  final case class Props(
      height: Option[String],
      message: Option[String],
      needKey: Option[String],
      sprite: String,
      target: Option[String],
      width: Option[String]
  )

  val key = "hiddendoortrigger"
  implicit val jsonEncoder: Encoder[HiddenDoorTriggerNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[HiddenDoorTriggerNode] = deriveDecoder
}

final case class HiddenDoorTriggerNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: HiddenDoorTriggerNode.Props
) extends Node(HiddenDoorTriggerNode.key) {
  override lazy val assets = Seq(Asset.Image("hidden.door." + properties.sprite, s"images/hiddendoor/${properties.sprite}.png"))
}

package models.node

import models.asset.Asset
import util.JsonSerializers._

object DoorNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  final case class Props(
      aniframes: Option[String],
      aniframes2: Option[String],
      animode: Option[String],
      anispeed: Option[String],
      anispeed2: Option[String],
      button: Option[String],
      closedinfo: Option[String],
      depth: Option[String],
      hideable: Option[String],
      info: Option[String],
      instant: Option[String],
      inventory: Option[String],
      level: Option[String],
      key: Option[String],
      minesDoor: Option[String],
      movetime: Option[String],
      obstruct: Option[String],
      offset_hidden_x: Option[String],
      offset_hidden_y: Option[String],
      offset_shown_x: Option[String],
      offset_shown_y: Option[String],
      quest: Option[String],
      show_sfx: Option[String],
      sound: Option[String],
      sprite: Option[String],
      sprite_height: Option[String],
      sprite_width: Option[String],
      to: Option[String],
      trigger: Option[String]
  )

  val key = "door"
  implicit val jsonEncoder: Encoder[DoorNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[DoorNode] = deriveDecoder
}

final case class DoorNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: Option[DoorNode.Props]
) extends Node(DoorNode.key) {
  override val assets = properties.flatMap(_.sound).map(Asset.sfx).toSeq ++ properties.flatMap(_.show_sfx).map(Asset.sfx)
}

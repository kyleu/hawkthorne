package models.node

import models.asset.Asset
import util.JsonSerializers._

object FireAlarmNode {
  val key = "firealarm"
  implicit val jsonEncoder: Encoder[FireAlarmNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[FireAlarmNode] = deriveDecoder
}

case class FireAlarmNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean
) extends Node(FireAlarmNode.key) {
  override val assets = Seq(
    Asset.Spritesheet("fire.alarm", "images/sprites/greendale/firealarm.png", 24, 72),
    Asset.Audio(s"sfx.spray", s"audio/sfx/spray.ogg"),
    Asset.Audio(s"sfx.alarmswitch", s"audio/sfx/alarmswitch.ogg")
  )
}

package models.node

import models.asset.Asset
import util.JsonSerializers._

object SplatNode {
  val key = "splat"
  implicit val jsonEncoder: Encoder[SplatNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SplatNode] = deriveDecoder
}

case class SplatNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean
) extends Node(SplatNode.key) {

  override val actualWidth = 300
  override val actualHeight = 250

  override val assets = Seq(Asset.Spritesheet(s"splat", s"images/splatters.png", actualWidth, actualWidth))
}

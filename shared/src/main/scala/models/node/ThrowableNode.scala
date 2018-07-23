package models.node

import models.asset.Asset
import util.JsonSerializers._

object ThrowableNode {
  val key = "throwable"
  implicit val jsonEncoder: Encoder[ThrowableNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[ThrowableNode] = deriveDecoder
}

final case class ThrowableNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean
) extends Node(ThrowableNode.key) {
  override val assets = Seq(
    Asset.Image(s"throwable.$actualName", s"images/throwables/$actualName.png")
  )
}

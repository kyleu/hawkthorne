package models.node

import util.JsonSerializers._

object BouncerNode {
  val key = "bouncer"
  implicit val jsonEncoder: Encoder[BouncerNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[BouncerNode] = deriveDecoder
}

case class BouncerNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(BouncerNode.key, x, y, width, height)

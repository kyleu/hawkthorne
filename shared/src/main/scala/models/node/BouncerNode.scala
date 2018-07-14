package models.node

import util.JsonSerializers._

object BouncerNode {
  val key = "bouncer"
  implicit val jsonEncoder: Encoder[BouncerNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[BouncerNode] = deriveDecoder
}

case class BouncerNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(BouncerNode.key)

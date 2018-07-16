package models.node

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
    override val rotation: Option[Int],
    override val visible: Option[Boolean]
) extends Node(SplatNode.key)

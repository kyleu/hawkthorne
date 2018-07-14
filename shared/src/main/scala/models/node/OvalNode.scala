package models.node

import util.JsonSerializers._

object OvalNode {
  val key = "oval"
  implicit val jsonEncoder: Encoder[OvalNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[OvalNode] = deriveDecoder
}

case class OvalNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(OvalNode.key)

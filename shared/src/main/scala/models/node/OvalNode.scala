package models.node

import util.JsonSerializers._

object OvalNode {
  val key = "oval"
  implicit val jsonEncoder: Encoder[OvalNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[OvalNode] = deriveDecoder
}

case class OvalNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(OvalNode.key, x, y, width, height)

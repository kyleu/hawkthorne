package models.node

import util.JsonSerializers._

object MaterialNode {
  val key = "material"
  implicit val jsonEncoder: Encoder[MaterialNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[MaterialNode] = deriveDecoder
}

case class MaterialNode(
    override val x: Int,
    override val y: Int,
    override val width: Int = 0,
    override val height: Int = 0
) extends Node(MaterialNode.key, x, y, width, height)

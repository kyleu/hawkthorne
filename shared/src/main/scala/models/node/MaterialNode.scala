package models.node

import util.JsonSerializers._

object MaterialNode {
  val key = "material"
  implicit val jsonEncoder: Encoder[MaterialNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[MaterialNode] = deriveDecoder
}

case class MaterialNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(MaterialNode.key)

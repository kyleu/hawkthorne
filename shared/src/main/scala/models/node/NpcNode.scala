package models.node

import util.JsonSerializers._

object NpcNode {
  val key = "npc"
  implicit val jsonEncoder: Encoder[NpcNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[NpcNode] = deriveDecoder
}

case class NpcNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int
) extends Node(NpcNode.key)

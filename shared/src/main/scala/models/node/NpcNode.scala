package models.node

import util.JsonSerializers._

object NpcNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(foreground: String)

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
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: Option[NpcNode.Props]
) extends Node(NpcNode.key)

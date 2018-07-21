package models.node

import util.JsonSerializers._

object TrampolineNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(dbadd: String, dbval: String)

  val key = "trampoline"
  implicit val jsonEncoder: Encoder[TrampolineNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[TrampolineNode] = deriveDecoder
}

case class TrampolineNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: TrampolineNode.Props
) extends Node(TrampolineNode.key)

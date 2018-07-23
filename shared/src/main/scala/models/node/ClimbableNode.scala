package models.node

import util.JsonSerializers._

object ClimbableNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  final case class Props(blockTop: String)

  val key = "climbable"
  implicit val jsonEncoder: Encoder[ClimbableNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[ClimbableNode] = deriveDecoder
}

final case class ClimbableNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: Option[ClimbableNode.Props]
) extends Node(ClimbableNode.key)

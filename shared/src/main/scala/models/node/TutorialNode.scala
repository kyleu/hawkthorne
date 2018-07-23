package models.node

import util.JsonSerializers._

object TutorialNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  final case class Props(`type`: String)

  val key = "tutorial"
  implicit val jsonEncoder: Encoder[TutorialNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[TutorialNode] = deriveDecoder
}

final case class TutorialNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: TutorialNode.Props
) extends Node(TutorialNode.key)

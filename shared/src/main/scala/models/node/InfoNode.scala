package models.node

import models.game.obj.Info
import util.JsonSerializers._

object InfoNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  final case class Props(info: String, sprite: Option[String])

  val key = "info"
  implicit val jsonEncoder: Encoder[InfoNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[InfoNode] = deriveDecoder
}

final case class InfoNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: InfoNode.Props
) extends Node(InfoNode.key) {
  override def asNewGameObject = Seq(Info(id = id, n = actualName, loc = asLocation, vis = visible, content = properties.info))
}

package models.node

import models.asset.Asset
import models.template.npc.NpcTemplate
import util.JsonSerializers._

object NpcNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  final case class Props(foreground: String)

  val key = "npc"
  implicit val jsonEncoder: Encoder[NpcNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[NpcNode] = deriveDecoder
}

final case class NpcNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: Option[NpcNode.Props]
) extends Node(NpcNode.key) {
  val template = NpcTemplate.withKey(actualName)
  override val assets = Seq(
    Asset.Spritesheet(s"$t.$actualName", s"images/npc/$actualName.png", template.width, template.height)
  )
}

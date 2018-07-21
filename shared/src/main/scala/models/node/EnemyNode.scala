package models.node

import models.asset.Asset
import util.JsonSerializers._

object EnemyNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(
      direction: Option[String],
      displacement: Option[String],
      drop: Option[String],
      enemytype: Option[String],
      quest: Option[String],
      sheet: Option[String]
  )

  val key = "enemy"
  implicit val jsonEncoder: Encoder[EnemyNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[EnemyNode] = deriveDecoder

  def widthFor(name: String) = name match {
    case "x" => 0
    case _ => throw new IllegalStateException(s"Unhandled npc [$name]")
  }

  def heightFor(name: String) = name match {
    case "x" => 0
    case _ => widthFor(name)
  }
}

case class EnemyNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    override val rotation: Int,
    override val visible: Boolean,
    properties: EnemyNode.Props
) extends Node(EnemyNode.key) {
  override val assets = Seq(
    Asset.Spritesheet(s"npc.$nameWithDefault", s"images/npc/$nameWithDefault.png", EnemyNode.widthFor(name), EnemyNode.heightFor(name))
  )
}

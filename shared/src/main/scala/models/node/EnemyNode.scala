package models.node

import models.asset.Asset
import models.template.enemy.EnemyListing
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

  override val actualName = if (name.isEmpty) {
    properties.enemytype.getOrElse(throw new IllegalStateException(s"No enemy name for [$id]."))
  } else {
    name
  }

  val sheet = properties.sheet.getOrElse(actualName)

  val template = EnemyListing.withKey(actualName)

  override val assets = Seq(Asset.Spritesheet(s"enemy.$sheet", s"images/enemies/$sheet.png", template.width, template.height)) ++
    template.sounds.map(k => Asset.Audio(s"sfx.$k", s"audio/sfx/$k.ogg")) ++
    template.passiveSound.map(k => Asset.Audio(s"sfx.$k", s"audio/sfx/$k.ogg")) ++
    template.attackSounds.map(k => Asset.Audio(s"sfx.$k", s"audio/sfx/$k.ogg")) ++
    template.dieSound.map(k => Asset.Audio(s"sfx.$k", s"audio/sfx/$k.ogg"))
}

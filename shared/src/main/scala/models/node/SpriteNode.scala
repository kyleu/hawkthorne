package models.node

import models.animation.{Animation, AnimationCoords}
import models.asset.Asset
import util.JsonSerializers._

import scala.util.Random

object SpriteNode {
  object Props {
    implicit val jsonEncoder: Encoder[Props] = deriveEncoder
    implicit val jsonDecoder: Decoder[Props] = deriveDecoder
  }

  case class Props(
      animation: Option[String],
      random: Option[String],
      speed: Option[String],
      depth: Option[String],
      direction: Option[String],
      sheet: String
  )

  val key = "sprite"
  implicit val jsonEncoder: Encoder[SpriteNode] = deriveEncoder
  implicit val jsonDecoder: Decoder[SpriteNode] = deriveDecoder
}

case class SpriteNode(
    override val id: Int,
    override val name: String,
    override val x: Int,
    override val y: Int,
    override val width: Int,
    override val height: Int,
    rotation: Int,
    visible: Boolean,
    properties: SpriteNode.Props
) extends Node(SpriteNode.key) {
  val sheetKey = "sprite." + properties.sheet.substring(properties.sheet.lastIndexOf('/') + 1).stripSuffix(".png")
  val animation = properties.animation.map { a =>
    val coords = AnimationCoords.fromString(a)
    val stride = coords.map(_._1).max + 1
    val frames = coords.map(c => c._1 + (c._2 * stride))
    val speed = properties.speed.map(_.toDouble).getOrElse(1.0)
    val anim = Animation(id = s"anim.$id", frames = frames, delay = 0.1, loop = true)
    if (properties.random.contains("true")) {
      anim.nextFrame(Random.nextDouble() * 1000)
    }
    anim
  }

  override lazy val assets = Seq(Asset.Spritesheet(sheetKey, properties.sheet, width, height))
}

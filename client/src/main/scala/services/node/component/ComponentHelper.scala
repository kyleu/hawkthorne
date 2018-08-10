package services.node.component

import com.definitelyscala.phaserce._
import com.definitelyscala.phasercepixi.Texture
import models.animation.Animation
import models.component
import models.component._
import models.node.{LiquidNode, Node}
import models.options.SystemOptions

import scala.scalajs.js

object ComponentHelper {
  def sprite(game: Game, group: Group, node: Node, key: Option[String] = None, flip: Boolean = false) = {
    val s = StaticSprite(game = game, group = group, name = node.actualName, key = key.getOrElse(s"${node.t}.${node.actualName}"), flip = flip)
    s.setPositionInt(node.actualX, node.actualY)
    Seq(s)
  }

  private[this] val cropRect = new Rectangle(0, 0, SystemOptions.tileSize.toDouble, SystemOptions.tileSize.toDouble)
  def cropped(game: Game, group: Group, node: Node, key: Option[String] = None) = {
    val seq = sprite(game, group, node, key)
    seq.foreach { s =>
      s.sprite.cropRect = cropRect
      s.sprite.updateCrop()
    }
    seq
  }

  def anim(
    game: Game, group: Group, node: Node, anims: Map[String, Animation], defAnim: String = "default", key: Option[String] = None, flip: Boolean = false
  ) = {
    val k = key.getOrElse(s"${node.t}.${node.actualName}")
    val a = anims.mapValues(_.newCopy)
    val s = AnimatedSprite(game = game, group = group, name = node.actualName, key = k, flip = flip, animations = a, defAnim = Some(defAnim))
    s.setPositionInt(node.actualX, node.actualY)
    Seq(s)
  }

  def animSingle(game: Game, group: Group, node: Node, a: Animation, key: Option[String] = None, flip: Boolean = false) = {
    anim(game = game, group = group, node = node, anims = Map(a.id -> a), defAnim = a.id, key = key, flip = flip)
  }

  def liquid(game: Game, group: Group, node: LiquidNode) = {
    val l = Liquid(
      game = game,
      group = group,
      name = "liquid." + node.actualName,
      key = node.sheetKey,
      opacity = node.opacityDouble,
      speed = node.properties.speed.map(_.toDouble).getOrElse(0.2),
      width = node.actualWidth / SystemOptions.tileSize,
      height = node.actualHeight / SystemOptions.tileSize
    )
    l.setPositionInt(node.actualX, node.actualY)
    Seq(l)
  }

  def outline(game: Game, group: Group, node: Node, color: Int, visible: Boolean) = {
    val i = outlineGraphics(game, group, node, color, visible)
    i.setPositionInt(node.pos._1, node.pos._2, if (visible) { None } else { Some(false) })
    Seq(i)
  }

  private[this] def outlineGraphics(game: Game, group: Group, node: Node, color: Int, visible: Boolean) = {
    val g = new Graphics(game = game)
    g.beginFill(color.toDouble)
    g.drawRect(0, 0, node.size._1.toDouble, node.size._2.toDouble)
    val t = g.generateTexture().asInstanceOf[Texture]
    StaticImage(game = game, group = group, name = node.t + "." + node.actualName, tex = t)
  }
}

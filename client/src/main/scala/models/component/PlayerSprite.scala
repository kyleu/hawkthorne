package models.component

import com.definitelyscala.phaserce.{Game, Graphics, Group}
import com.definitelyscala.phasercepixi.Texture
import models.data.character.CharacterAnimation
import models.player.Player

object PlayerSprite {
  val animations = CharacterAnimation.values.flatMap(a => Seq(a.leftAnim, a.rightAnim)).map(a => a.id -> a).toMap
}

class PlayerSprite(
    override val game: Game, mapGroup: Group, idx: Int, player: Player, initialLoc: (Int, Int), initialBounds: (Int, Int)
) extends SimpleComponent {
  override val name = s"player.$idx"

  private[this] val playerGroup = new Group(game, mapGroup, name)

  private[this] val as = AnimatedSprite(
    game = game, group = playerGroup, name = name + ".sprite",
    key = s"${player.templateKey}.${player.costume.key}", animations = PlayerSprite.animations.mapValues(_.newCopy), defAnim = Some("idle.right")
  )
  override def comp = playerGroup
  playerGroup.x = initialLoc._1.toDouble
  playerGroup.y = initialLoc._2.toDouble

  def setScale(s: Double) = playerGroup.scale.set(s, s)
  def setFrame(i: Int) = as.sprite.frame = i
  def setAnimation(x: Option[String]) = as.setAnimation(x)
  def bringToTop() = mapGroup.bringToTop(playerGroup)

  as.sprite.name = s"$idx.${player.templateKey}.${player.costume.key}"
  as.sprite.anchor.set(0.5, 1.0)

  override def update(deltaMs: Double) = as.update(deltaMs)

  def displayBounds(rect: util.Rectangle) = {
    val g = new Graphics(game)
    g.beginFill(0x00ff00)
    g.drawRect(rect.x, rect.y, rect.w.toDouble, rect.h.toDouble)
    g.endFill()

    val t = g.generateTexture().asInstanceOf[Texture]
    val i = StaticImage(game = game, group = playerGroup, name = s"player.$idx.bounds.debug", tex = t)
    i.setPosition(-rect.w.toDouble / 2, -rect.h.toDouble)
  }

  override def toString = s"PlayerSprite[$idx@$x/$y]: $player"
}

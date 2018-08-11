package models.component

import com.definitelyscala.phaserce.{Game, Group}
import models.data.character.CharacterAnimation
import models.game.GameUpdate
import models.input.PlayerInputHandler
import models.player.Player

object PlayerSprite {
  val animations = CharacterAnimation.values.flatMap(a => Seq(a.leftAnim, a.rightAnim)).map(a => a.id -> a).toMap
}

class PlayerSprite(override val game: Game, group: Group, idx: Int, player: Player, initialLoc: (Int, Int), initialBounds: (Int, Int)) extends SimpleComponent {

  override val name = s"player.$idx"

  private[this] val as = AnimatedSprite(
    game = game, group = group, name = s"player.$idx",
    key = s"${player.templateKey}.${player.costume.key}", animations = PlayerSprite.animations.mapValues(_.newCopy), defAnim = Some("idle.right")
  )
  override def comp = as.sprite
  as.x = initialLoc._1.toDouble
  as.y = initialLoc._2.toDouble

  def setScale(s: Double) = as.sprite.scale.set(s, s)
  def setFrame(i: Int) = as.sprite.frame = i
  def setAnimation(x: Option[String]) = as.setAnimation(x)
  def bringToTop() = as.sprite.bringToTop()

  private[this] val input = new PlayerInputHandler(maxX = initialBounds._1, maxY = initialBounds._2, s => util.Logging.info(s))

  def processInput(delta: Double, playerInput: GameUpdate.PlayerInput) = {
    val (anim, loc) = input.process(delta = delta, currentX = x, currentY = y, input = playerInput)
    anim.foreach(x => setAnimation(Some(x)))
    loc.foreach { l =>
      x = l._1
      y = l._2
    }
  }

  as.sprite.name = s"$idx.${player.templateKey}.${player.costume.key}"
  as.sprite.anchor.set(0.5, 0.5)

  override def update(deltaMs: Double) = as.update(deltaMs)
}

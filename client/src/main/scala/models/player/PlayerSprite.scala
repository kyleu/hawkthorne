package models.player

import com.definitelyscala.phaserce.Physics.Arcade.Body
import com.definitelyscala.phaserce.{Game, Group, Point}
import models.component.{AnimatedSprite, BaseComponent}
import models.data.character.CharacterAnimation
import services.input.PlayerInputHandler

object PlayerSprite {
  val animations = CharacterAnimation.values.flatMap(a => Seq(a.leftAnim, a.rightAnim)).map(a => a.id -> a).toMap
}

class PlayerSprite(
    override val game: Game, group: Group, player: Player, initialX: Int, initialY: Int, scaled: Boolean = true, physics: Boolean = true
) extends BaseComponent {
  override val name = s"player.${player.idx}"

  val as = AnimatedSprite(
    game = game, group = group, name = s"player.${player.idx}", x = initialX, y = initialY,
    key = s"${player.templateKey}.${player.costume.key}", animations = PlayerSprite.animations.mapValues(_.newCopy), defAnim = Some("idle.right")
  )

  override def x: Int = as.x
  override def y: Int = as.y

  private[this] val input = new PlayerInputHandler(this)

  def processInput(delta: Double, velocity: (Double, Double), actions: Seq[String]) = {
    input.process(delta = delta, velocity = velocity, events = actions)
  }

  as.sprite.name = s"${player.templateKey}.${player.costume.key}"
  as.sprite.anchor = util.PhaserUtils.centerPoint

  if (physics) {
    game.physics.arcade.enable(as.sprite)
    val body = as.sprite.body.asInstanceOf[Body]
    body.gravity.y = 100
    body.bounce.y = 0
    body.collideWorldBounds = true
  }

  override def update(deltaMs: Double) = as.update(deltaMs)
}

package models.player

import com.definitelyscala.phaserce.Physics.Arcade.Body
import com.definitelyscala.phaserce.{Game, Group, Point}
import models.component.AnimatedSprite
import models.data.character.CharacterAnimation
import services.input.PlayerInputHandler

object PlayerSprite {
  val animations = CharacterAnimation.values.flatMap(a => Seq(a.leftAnim, a.rightAnim)).map(a => a.id -> a).toMap
}

class PlayerSprite(
    game: Game, group: Group, player: Player, initialX: Int, initialY: Int, scaled: Boolean = true, physics: Boolean = true
) extends AnimatedSprite(
  game = game, group = group, name = s"player.${player.idx}", x = initialX, y = initialY,
  key = s"${player.templateKey}.${player.costume.key}", animations = PlayerSprite.animations, defAnim = Some("idle.right")
) {
  private[this] val input = new PlayerInputHandler(this)

  def processInput(delta: Double, velocity: (Double, Double), actions: Seq[String]) = {
    input.process(delta = delta, velocity = velocity, events = actions)
  }

  sprite.name = s"${player.templateKey}.${player.costume.key}"
  sprite.anchor = new Point(0.5, 0.5)

  if (physics) {
    game.physics.arcade.enable(sprite)
    val body = sprite.body.asInstanceOf[Body]
    body.gravity.y = 700
    body.bounce.y = 0
    body.collideWorldBounds = true
  }
}

package models.player

import com.definitelyscala.phaserce.{Game, Group, Point}
import models.component.AnimatedSprite
import models.data.character.CharacterAnimation
import services.input.PlayerInputHandler
import services.map.MapService

object PlayerSprite {
  val animations = CharacterAnimation.values.flatMap(a => Seq(a.leftAnim, a.rightAnim)).map(a => a.id -> a).toMap
}

class PlayerSprite(game: Game, group: Group, player: Player, var x: Int, var y: Int) extends AnimatedSprite(
  game = game, group = group, offsetX = x, offsetY = y, key = s"${player.templateKey}.${player.costume.key}", PlayerSprite.animations
) {
  private[this] val input = new PlayerInputHandler(this)

  def setFaceRight(bool: Boolean) = if (bool) { setAnimation(Some("idle.right")) } else { setAnimation(Some("idle.left")) }

  def processInput(elapsed: Double, velocity: (Double, Double), actions: Seq[String]) = input.process(elapsed, velocity, actions)

  setAnimation(Some("idle.right"))
  sprite.name = s"${player.templateKey}.${player.costume.key}"
  sprite.scale = MapService.scalePoint
  sprite.anchor = new Point(0.5, 0.5)
}

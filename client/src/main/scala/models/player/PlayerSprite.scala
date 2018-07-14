package models.player

import com.definitelyscala.phaserce.{Game, Group, Point}
import models.data.character.CharacterAnimation
import models.phaser.AnimatedSprite

object PlayerSprite {
  val animations = CharacterAnimation.values.flatMap(a => Seq(a.leftAnim, a.rightAnim)).map(a => a.id -> a).toMap
}

class PlayerSprite(game: Game, group: Group, player: Player, var x: Int, var y: Int) extends AnimatedSprite(
  game = game, group = group, offsetX = x, offsetY = y, key = s"${player.templateKey}.${player.costume.key}", PlayerSprite.animations
) {
  sprite.name = s"${player.templateKey}.${player.costume.key}"
  sprite.anchor = new Point(0.5, 0.5)
}

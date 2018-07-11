package models.player

import com.definitelyscala.phaserce.Game
import models.data.character.CharacterAnimation
import models.phaser.AnimatedSprite

object PlayerSprite {
  val animations = CharacterAnimation.values.flatMap(a => Seq(a.leftAnim, a.rightAnim))
}

class PlayerSprite(player: Player, var x: Int, var y: Int, game: Game) extends AnimatedSprite(
  game = game, offsetX = x, offsetY = y, key = s"${player.templateKey}.${player.costume.key}", PlayerSprite.animations: _*
) {
  sprite.name = s"${player.templateKey}.${player.costume.key}"
  game.add.existing(sprite)
}

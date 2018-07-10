package models.player

import com.definitelyscala.phaserce.{Game, Sprite}
import models.character.{CharacterTemplate, Costume}
import models.data.character.CharacterAnimation
import models.phaser.AnimatedSprite

object Player {
  val animations = CharacterAnimation.values.flatMap(a => Seq(a.leftAnim, a.rightAnim))
}

class Player(actor: CharacterTemplate, costume: Costume, x: Int, y: Int, game: Game) extends AnimatedSprite(
  game = game, offsetX = x, offsetY = y, key = s"${actor.id}.${costume.key}", Player.animations: _*
) {
  sprite.name = s"${actor.id}.${costume.key}"
  game.add.existing(sprite)
}

package services.state

import com.definitelyscala.phaserce.Game
import models.data.character.Abed
import models.player.Player

object TestState {
  def load(phaser: Game) = new LoadingState(
    next = new TestState(phaser),
    spritesheets = Seq(("abed.base", "images/character/abed/base.png", 48, 48)),
    phaser = phaser
  )
}

class TestState(phaser: Game) extends GameState("test", phaser) {
  lazy val player = new Player(Abed.template, Abed.costumes.head, game.width.toInt / 2, game.height.toInt / 2, game)
  lazy val cursors = game.input.keyboard.createCursorKeys()

  override def create(game: Game) = {
    player.toString
    cursors.toString
  }

  override def update(game: Game) = {
    if (cursors.left.isDown) {
      player.sprite.x -= 4
    } else if (cursors.right.isDown) {
      player.sprite.x += 4
    }

    if (cursors.up.isDown) {
      player.sprite.y -= 4
    } else if (cursors.down.isDown) {
      player.sprite.y += 4
    }
  }
}

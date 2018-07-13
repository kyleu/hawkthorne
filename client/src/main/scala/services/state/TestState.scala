package services.state

import com.definitelyscala.phaserce.Game
import models.player.{Player, PlayerSprite}
import services.input.{InputHandler, InputService}

object TestState {
  def load(phaser: Game) = new LoadingState(
    next = new TestState(phaser),
    phaser = phaser,
    spritesheets = Seq(Player.default.spritesheet)
  )
}

class TestState(phaser: Game) extends GameState("test", phaser) {
  private[this] lazy val player = new PlayerSprite(Player.default, game.width.toInt / 2, game.height.toInt / 2, game)
  private[this] lazy val cursors = game.input.keyboard.createCursorKeys()
  private[this] var input: Option[InputService] = None

  override def create(game: Game) = {
    player.toString
    cursors.toString
    input = Some(new InputService(phaser, player.sprite, new InputHandler()))
  }

  override def update(game: Game) = {
    input.foreach(_.update(0L))
  }
}

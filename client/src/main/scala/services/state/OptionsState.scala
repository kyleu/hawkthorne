package services.state

import com.definitelyscala.phaserce.Game
import models.font.Font

object OptionsState {
  def load(phaser: Game, debug: Boolean) = new LoadingState(next = new OptionsState(phaser = phaser, debug = debug), phaser = phaser, assets = {
    Font.assets
  })
}

class OptionsState(phaser: Game, debug: Boolean) extends GameState("test", phaser) {
  override def create(game: Game) = {
    Font.reset()
    val f = Font.getFont("courier", game)
    val i1 = f.renderToImage(s"test.all", Font.chars.tail, game, 10, 10)
    val i2 = f.renderToImage(s"test.phrase", "Hello, world! The quick brown fox jumped over the lazy dog.", game, 10, 60)

    game.add.existing(i1)
    game.add.existing(i2)
  }
}

package services.state

import com.definitelyscala.phaserce.Game
import models.font.Font

object TestState {
  def load(phaser: Game) = new LoadingState(next = new TestState(phaser), phaser = phaser, assets = Font.assets)
}

class TestState(phaser: Game) extends GameState("test", phaser) {
  override def create(game: Game) = {
    Font.fonts.map(Font.getFont(_, game)).zipWithIndex.foreach {
      case (f, idx) =>
        val i1 = f.renderToImage(s"test.$idx.all", Font.chars.tail, game, 10, 10 + (idx * 100.0))
        val i2 = f.renderToImage(s"test.$idx.phrase", "Hello, world! The quick brown fox jumped over the lazy dog.", game, 10, 60 + (idx * 100.0))

        game.add.existing(i1)
        game.add.existing(i2)
    }
  }
}

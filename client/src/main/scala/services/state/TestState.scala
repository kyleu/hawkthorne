package services.state

import com.definitelyscala.phaserce.Game
import models.component.ConsoleLog
import models.font.Font

object TestState {
  def load(phaser: Game) = new LoadingState(next = new TestState(phaser), phaser = phaser, assets = Font.assets)
}

class TestState(phaser: Game) extends GameState("test", phaser) {
  override def create(game: Game) = {
    val consoleLog = ConsoleLog(game = game)

    Font.fonts.map(Font.getFont(_, game)).zipWithIndex.foreach {
      case (f, idx) =>
        // val tex = f.renderToTexture("Hello, world! The quick brown fox jumped over the lazy dog.", game)
        val i = f.renderToImage(s"test.$idx", "Hello, world! The quick brown fox jumped over the lazy dog.", game, 10, 10 + (idx * 100.0))
        game.add.existing(i)
    }

  }
}

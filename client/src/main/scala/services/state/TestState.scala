package services.state

import com.definitelyscala.phaserce.Game

object TestState {
  def load(phaser: Game) = new LoadingState(
    next = new TestState(phaser),
    phaser = phaser,
    assets = Nil
  )
}

class TestState(phaser: Game) extends GameState("test", phaser) {
  override def create(game: Game) = {
  }

  override def update(game: Game) = {
  }
}

package services.state

import com.definitelyscala.phaserce.Game
import services.input.InputService

class MainMenuState(phaser: Game) extends GameState("mainmenu", phaser) {
  override def create(game: Game) = {
    game.add.group(name = s"mainmenu.group")
    new InputService(phaser, IndexedSeq.empty)
  }

  override def update(game: Game) = {
  }
}

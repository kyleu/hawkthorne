package services.state

import com.definitelyscala.phaserce.Game

object TestState {
  def load(phaser: Game) = {
    new LoadingState(
      next = new TestState(phaser),
      phaser = phaser,
      tilemaps = Seq("map.adminhallway" -> "/assets/game/json/admin-hallway.json")
    )
  }
}

class TestState(phaser: Game) extends GameState("test", phaser) {
  override def create(game: Game) = {
    game.add.tilemap("map")
  }
}

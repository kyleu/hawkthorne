package services.state

import com.definitelyscala.phaserce.Game

object TestState {
  def load() = {
    new LoadingState(
      next = new TestState(),
      tilemaps = Seq("map.adminhallway" -> "/assets/game/json/admin-hallway.json")
    )
  }
}

class TestState() extends GameState("test") {
  override def create(game: Game) = {
    game.add.tilemap("map")
  }
}

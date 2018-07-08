package services.state

import com.definitelyscala.phaserce.Game
import models.phaser.TiledMap

object TestState {
  val map = TiledMap.WomensBathroom

  def load(phaser: Game) = {
    new LoadingState(
      next = new TestState(phaser),
      phaser = phaser,
      images = map.imageKeys,
      tilemaps = Seq(map.tilemap)
    )
  }
}

class TestState(phaser: Game) extends GameState("test", phaser) {
  override def create(game: Game) = {
    TestState.map.create(phaser)
  }
}

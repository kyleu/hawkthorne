package services.state

import com.definitelyscala.phaserce.Game
import models.component.BaseComponent
import models.data.map.TiledMap
import services.map.MapService
import services.node.NodeLoader

object MapTestState {
  def load(phaser: Game, map: TiledMap) = new LoadingState(next = new MapTestState(phaser, map), phaser = phaser, assets = MapService.assetsFor(map))
}

class MapTestState(phaser: Game, map: TiledMap) extends GameState(map.value, phaser) {
  private[this] val components = collection.mutable.ArrayBuffer.empty[BaseComponent]

  override def create(game: Game) = {
    val mapSvc = new MapService(game, map, playMusic = true)
    new NodeLoader(game, mapSvc.group).load(nodes = mapSvc.nodes, onComplete = newComponents => components ++= newComponents)
  }

  override def update(game: Game) = {
    val dt = game.time.physicsElapsed
    components.foreach(_.update(dt))
  }
}

package services.state

import com.definitelyscala.phaserce.Game
import models.data.map.TiledMap
import services.map.MapService
import services.node.NodeLoader

object MapState {
  def load(phaser: Game, map: TiledMap) = new LoadingState(next = new MapState(phaser, map), phaser = phaser, assets = MapService.assetsFor(map))
}

class MapState(phaser: Game, map: TiledMap) extends GameState(map.value, phaser) {
  override def create(game: Game) = {
    val mapSvc = new MapService(game, map, playMusic = true)
    new NodeLoader(game, mapSvc.group).load(nodes = mapSvc.nodes)
  }
}

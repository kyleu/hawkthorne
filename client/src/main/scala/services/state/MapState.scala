package services.state

import com.definitelyscala.phaserce.Game
import models.data.map.TiledMap

object MapState {
  def load(phaser: Game, map: TiledMap) = new LoadingState(
    next = new MapState(phaser, map),
    phaser = phaser,
    images = map.images.map(i => i -> s"images/tileset/$i.png"),
    tilemaps = Seq("map.test" -> s"maps/${map.value}.json")
  )
}

class MapState(phaser: Game, map: TiledMap) extends GameState(map.value, phaser) {
  override def create(game: Game) = {
    val tilemap = phaser.add.tilemap("map.test")
    map.images.foreach(i => tilemap.addTilesetImage(i))
    map -> map.layers.map(l => tilemap.createLayer(l))
  }
}

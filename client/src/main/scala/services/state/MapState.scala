package services.state

import com.definitelyscala.phaserce.Game
import models.data.map.TiledMap
import models.phaser.NodeLoader
import services.map.MapService

object MapState {
  def load(phaser: Game, map: TiledMap) = new LoadingState(
    next = new MapState(phaser, map),
    phaser = phaser,
    assets = LoadingState.Assets(
      audio = Seq(s"music.${map.soundtrack}" -> s"audio/music/${map.soundtrack}.ogg"),
      images = map.images.map(i => i -> s"images/tileset/$i.png"),
      tilemaps = Seq(s"map.${map.value}" -> s"maps/${map.value}.json")
    )
  )
}

class MapState(phaser: Game, map: TiledMap) extends GameState(map.value, phaser) {
  override def create(game: Game) = {
    val mapSvc = new MapService(game, map, playMusic = true)
    new NodeLoader(game, mapSvc.group).load(nodes = mapSvc.nodes)
  }
}

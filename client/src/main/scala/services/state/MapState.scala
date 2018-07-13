package services.state

import com.definitelyscala.phaserce.Game
import models.data.map.TiledMap
import services.map.MapService

object MapState {
  def load(phaser: Game, map: TiledMap) = new LoadingState(
    next = new MapState(phaser, map),
    phaser = phaser,
    audio = map.soundtrack.map(s => s"music.$s" -> s"audio/music/$s.ogg").toSeq,
    images = map.images.map(i => i -> s"images/tileset/$i.png"),
    tilemaps = Seq(s"map.${map.value}" -> s"maps/${map.value}.json")
  )
}

class MapState(phaser: Game, map: TiledMap) extends GameState(map.value, phaser) {
  override def create(game: Game) = new MapService(game, map, playMusic = true)
}

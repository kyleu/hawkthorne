package services.state

import com.definitelyscala.phaserce.{Game, TilemapLayer}
import models.data.map.TiledMap

object MapState {
  def load(phaser: Game, map: TiledMap) = new LoadingState(
    next = new MapState(phaser, map),
    phaser = phaser,
    audio = map.soundtrack.map(s => s"music.$s" -> s"audio/music/$s.ogg").toSeq,
    images = map.images.map(i => i -> s"images/tileset/$i.png"),
    tilemaps = Seq("map.test" -> s"maps/${map.value}.json")
  )
}

class MapState(phaser: Game, map: TiledMap) extends GameState(map.value, phaser) {
  private[this] var layers: Seq[(String, TilemapLayer)] = Nil

  def layer(key: String) = layers.find(_._1 == key).map(_._2)

  override def create(game: Game) = {
    game.stage.backgroundColor = "#FFFFFF" // TODO WTF?
    val tilemap = phaser.add.tilemap("map.test")
    map.images.foreach(i => tilemap.addTilesetImage(i))
    map.soundtrack.foreach(s => game.add.audio(s"music.$s").play(loop = true))
    layers = map.layers.map(l => l -> tilemap.createLayer(l))
    layer("collision").foreach(_.visible = false)
  }
}

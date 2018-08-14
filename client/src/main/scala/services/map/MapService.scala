package services.map

import com.definitelyscala.phaserce._
import models.asset.Asset
import models.data.map.TiledMap
import models.options.SystemOptions
import services.audio.MusicService
import util.PhaserUtils

import scala.scalajs.js

object MapService {
  def assetsFor(map: TiledMap) = Seq(
    MusicService.asset(map.soundtrack),
    Asset.Tilemap(s"map.${map.value}", s"maps/${map.value}.json")
  ) ++ map.images.map(i => Asset.Image(i._1, s"images/tilesets/${i._2}.png"))
}

class MapService(game: Game, val map: TiledMap, playMusic: Boolean) {
  val group = game.add.group(name = s"map.${map.value}")

  val tilemap = new Tilemap(game, s"map.${map.value}")
  map.images.foreach(i => tilemap.addTilesetImage(tileset = i._1))

  val backdrop = PhaserUtils.makeBackdrop(game = game, width = tilemap.widthInPixels, height = tilemap.heightInPixels, color = map.color)
  group.add(backdrop)

  MusicService.play(map.soundtrack, loop = true)

  val mapPxWidth = map.width * SystemOptions.tileSize
  val mapPxHeight = map.height * SystemOptions.tileSize

  val layers = tilemap.layers.map(_.asInstanceOf[js.Dynamic].name.toString).map { k =>
    val l = tilemap.createLayer(k)
    l.resize(mapPxWidth.toDouble, mapPxHeight.toDouble)
    k -> l
  }
  layers.foreach(l => group.add(l._2))

  def layer(key: String) = layers.find(_._1 == key).map(_._2)
  val collisionLayer = layer("collision")
  collisionLayer.foreach { c =>
    c.visible = false
    c.resizeWorld()
  }
}

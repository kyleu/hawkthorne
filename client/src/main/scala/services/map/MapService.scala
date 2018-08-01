package services.map

import com.definitelyscala.phaserce._
import models.asset.Asset
import models.data.map.TiledMap
import services.audio.MusicService
import util.PhaserUtils

import scala.scalajs.js

object MapService {
  def assetsFor(map: TiledMap) = Seq(
    MusicService.asset(map.soundtrack),
    Asset.Tilemap(s"map.${map.value}", s"maps/${map.value}.json")
  ) ++ map.images.toSeq.map(i => Asset.Image(i._1, s"images/tilesets/${i._2}.png"))
}

class MapService(game: Game, val map: TiledMap, playMusic: Boolean) {
  val group = game.add.group(name = s"map.${map.value}")

  val tilemap = new Tilemap(game, "map." + map.value)
  map.images.foreach(i => tilemap.addTilesetImage(i._1))

  val backdrop = PhaserUtils.makeBackdrop(game = game, width = tilemap.widthInPixels, height = tilemap.heightInPixels, color = map.color)
  group.add(backdrop)

  MusicService.play(map.soundtrack, loop = true)

  val layers = tilemap.layers.map(_.asInstanceOf[js.Dynamic].name.toString).map(l => l -> tilemap.createLayer(l))
  layers.foreach(l => group.add(l._2))

  val mapPxWidth = map.width * 24
  game.world.width = mapPxWidth.toDouble

  val mapPxHeight = map.height * 24
  game.world.height = mapPxHeight.toDouble

  def layer(key: String) = layers.find(_._1 == key).map(_._2)
  val collisionLayer = layer("collision")
  collisionLayer.foreach { c =>
    tilemap.setCollisionByExclusion(indexes = js.Array(Nil), collides = true, layer = c)
    c.visible = false
  }

  game.world.setBounds(0, 0, tilemap.widthInPixels, tilemap.heightInPixels)
}

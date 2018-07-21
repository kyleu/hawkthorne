package services.map

import com.definitelyscala.phaserce._
import models.asset.Asset
import models.data.map.TiledMap
import org.scalajs.dom.ext.Color

import scala.scalajs.js

object MapService {
  def assetsFor(map: TiledMap) = Seq(
    Asset.Audio(s"music.${map.soundtrack}", s"audio/music/${map.soundtrack}.ogg"),
    Asset.Tilemap(s"map.${map.value}", s"maps/${map.value}.json")
  ) ++ map.images.map(i => Asset.Image(i, s"images/tileset/$i.png"))
}

class MapService(game: Game, val map: TiledMap, playMusic: Boolean) {
  val group = game.add.group(name = s"map.${map.value}")

  val tilemap = new Tilemap(game, "map." + map.value)
  map.images.foreach(i => tilemap.addTilesetImage(i))

  val backdrop = {
    val bgData = game.make.bitmapData(1, 1)
    val color = Color(map.color)
    bgData.fill(color.r.toDouble, color.g.toDouble, color.b.toDouble)

    val s = new Sprite(game, 0, 0, bgData)
    s.name = "backdrop"
    s.width = tilemap.widthInPixels
    s.height = tilemap.heightInPixels
    group.add(s)
    s
  }

  val music = game.add.audio(s"music.${map.soundtrack}")
  if (playMusic) { music.play(loop = true) }

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
}

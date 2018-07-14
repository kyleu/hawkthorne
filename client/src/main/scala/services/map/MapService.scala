package services.map

import com.definitelyscala.phaserce.{Game, Point, Sprite, Tilemap}
import models.data.map.TiledMap
import models.node.Node
import org.scalajs.dom.ext.Color
import util.Logging

import scala.scalajs.js
import scala.util.control.NonFatal

object MapService {
  val scale = 4.0
  val scalePoint = new Point(scale, scale)
}

class MapService(game: Game, map: TiledMap, playMusic: Boolean) {
  private[this] val startNanos = System.nanoTime

  val pixelRatio = org.scalajs.dom.window.devicePixelRatio

  val group = game.add.group(name = s"map.${map.value}")
  group.scale = {
    val zoom = 1.0 * pixelRatio
    new Point(zoom, zoom)
  }

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
  layers.foreach { l =>
    l._2.scale = MapService.scalePoint
    group.add(l._2)
  }
  def layer(key: String) = layers.find(_._1 == key).map(_._2)

  layer("collision").foreach(_.visible = false)

  val objects = {
    val tilemapJson = game.cache.getTilemapData("map." + map.value)
    val tilemapLayers = tilemapJson.data.layers.asInstanceOf[js.Array[js.Dictionary[js.Any]]].toSeq.filter(_.apply("type").toString == "objectgroup")
    tilemapLayers.flatMap(_.apply("objects").asInstanceOf[js.Array[js.Any]].toSeq)
  }
  val nodes: Seq[Node] = objects.map(o => try {
    io.circe.scalajs.decodeJs[Node](o) match {
      case Right(x) => x
      case Left(x) => throw x
    }
  } catch {
    case NonFatal(x) =>
      Logging.warn("Error deserializing node:")
      Logging.logJs(o)
      throw x
  })

  Logging.info(s"Map [${map.value}] loaded in [${((System.nanoTime - startNanos).toDouble / 1000000).toString.take(8)}ms].")
  nodes.groupBy(_.getClass).map(x => x._1.getSimpleName.stripSuffix("$") + ": " + x._2.size).foreach(s => Logging.info("  - " + s))
}

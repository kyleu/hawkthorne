package services.map

import com.definitelyscala.phaserce.{Game, Point, Tilemap}
import models.data.map.TiledMap
import models.node.Node
import util.Logging

import scala.scalajs.js
import scala.util.control.NonFatal

class MapService(game: Game, map: TiledMap, playMusic: Boolean) {
  val pixelRatio = org.scalajs.dom.window.devicePixelRatio
  private[this] val startNanos = System.nanoTime

  val group = game.add.group(name = s"map.${map.value}")
  group.scale = {
    val zoom = 3.0 * pixelRatio
    new Point(zoom, zoom)
  }

  game.stage.backgroundColor = map.color // TODO WTF?
  val tilemap = new Tilemap(game, "map." + map.value)
  map.images.foreach(i => tilemap.addTilesetImage(i))

  val music = game.add.audio(s"music.${map.soundtrack}")
  if (playMusic) { music.play(loop = true) }

  val layers = tilemap.layers.map(_.asInstanceOf[js.Dynamic].name.toString).map(l => l -> tilemap.createLayer(l))
  layers.foreach(l => group.add(l._2))
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
}

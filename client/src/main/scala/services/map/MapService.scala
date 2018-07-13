package services.map

import com.definitelyscala.phaserce.Game
import models.data.map.TiledMap
import models.node.Node
import util.Logging

import scala.scalajs.js
import scala.scalajs.js.JSON

class MapService(game: Game, map: TiledMap, playMusic: Boolean) {
  private[this] val startNanos = System.nanoTime

  game.stage.backgroundColor = map.color // TODO WTF?
  val tilemap = game.add.tilemap("map." + map.value)
  map.images.foreach(i => tilemap.addTilesetImage(i))

  val music = game.add.audio(s"music.${map.soundtrack}")
  if (playMusic) { music.play(loop = true) }

  val layers = tilemap.layers.map(_.asInstanceOf[js.Dynamic].name.toString).map(l => l -> tilemap.createLayer(l))
  def layer(key: String) = layers.find(_._1 == key).map(_._2)

  layer("collision").foreach(_.visible = false)
  val objects = tilemap.objects.asInstanceOf[js.Dictionary[js.Any]].values.flatMap(_.asInstanceOf[js.Array[js.Any]].toSeq).map(x => JSON.stringify(x)).toSeq
  val nodes: Seq[Node] = objects.map(Node.parseString)

  Logging.info(s"Map [${map.value}] loaded in [${((System.nanoTime - startNanos).toDouble / 1000000).toString.take(8)}ms].")
}

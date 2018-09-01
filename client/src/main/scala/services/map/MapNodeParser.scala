package services.map

import models.collision.{CollisionGrid, CollisionPoly}
import models.data.map.TiledMap
import models.node.Node
import services.collision.CollisionService
import util.Logging

import scala.scalajs.js
import scala.util.control.NonFatal

object MapNodeParser {
  def parse(m: TiledMap, o: js.Dynamic): (Seq[Node], CollisionService.Collision) = {
    val startNanos = System.nanoTime

    val layers = o.data.layers.asInstanceOf[js.Array[js.Dictionary[js.Any]]].toSeq

    val objectLayers = layers.filter(_.apply("type").toString == "objectgroup")
    val objects = objectLayers.flatMap(_.apply("objects").asInstanceOf[js.Array[js.Any]].toSeq)
    val nodes = objects.map(o => try {
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

    val collision = layers.find(_.apply("name").toString == "collision") match {
      case Some(layer) =>
        val firstTileId = m.tilesets.find(_.name == "collisions").getOrElse(throw new IllegalStateException("No [collisions] tileset")).firstId
        Right(CollisionGrid.forJson(io.circe.scalajs.convertJsToJson(layer).right.get, firstTileId))
      case None => Left(CollisionPoly.fromNodes(m.value, nodes))
    }

    Logging.debug(s"Loaded [${nodes.size}] nodes in [${((System.nanoTime - startNanos).toDouble / 1000000).toString.take(8)}ms].")
    nodes.groupBy(_.getClass).map(x => x._1.getSimpleName.stripSuffix("$") + ": " + x._2.size).toSeq.sorted.foreach(s => Logging.debug("  - " + s))
    nodes.reverse -> collision
  }
}

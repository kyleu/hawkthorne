package services.map

import models.collision.{CollisionGrid, CollisionPoly}
import models.node.{Node, SimpleNode}
import util.Logging

import scala.scalajs.js
import scala.util.control.NonFatal

object MapNodeParser {
  def parse(key: String, o: js.Dynamic): (Seq[Node], Either[CollisionPoly, CollisionGrid]) = {
    val startNanos = System.nanoTime

    val layers = o.data.layers.asInstanceOf[js.Array[js.Dictionary[js.Any]]].toSeq

    val objectLayers = layers.filter(_.apply("type").toString == "objectgroup")
    val objects = objectLayers.flatMap(_.apply("objects").asInstanceOf[js.Array[js.Any]].toSeq)
    val objs = objects.map(o => try {
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
      case Some(layer) => Right(CollisionGrid.forJson(io.circe.scalajs.convertJsToJson(layer).right.get))
      case None => Left(CollisionPoly(objs.collectFirst {
        case s: SimpleNode if s.primary => s.polygon.getOrElse(throw new IllegalStateException(s"No polygon for primary [$key] node"))
      }.getOrElse(throw new IllegalStateException(s"No primary node or collision layer for [$key]")).toIndexedSeq))
    }

    Logging.debug(s"Loaded [${objs.size}] nodes in [${((System.nanoTime - startNanos).toDouble / 1000000).toString.take(8)}ms].")
    objs.groupBy(_.getClass).map(x => x._1.getSimpleName.stripSuffix("$") + ": " + x._2.size).toSeq.sorted.foreach(s => Logging.debug("  - " + s))
    objs -> collision
  }
}

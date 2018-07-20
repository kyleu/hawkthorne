package services.map

import models.node.Node
import util.Logging

import scala.scalajs.js
import scala.util.control.NonFatal

object MapNodeParser {
  def parse(o: js.Dynamic): Seq[Node] = {
    val startNanos = System.nanoTime

    val tilemapLayers = o.data.layers.asInstanceOf[js.Array[js.Dictionary[js.Any]]].toSeq.filter(_.apply("type").toString == "objectgroup")
    val objects = tilemapLayers.flatMap(_.apply("objects").asInstanceOf[js.Array[js.Any]].toSeq)
    val ret = objects.map(o => try {
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

    val time = ((System.nanoTime - startNanos).toDouble / 1000000).toString.take(8)
    Logging.info(s"Loaded [${ret.size}] nodes in [${time}ms].")
    ret.groupBy(_.getClass).map(x => x._1.getSimpleName.stripSuffix("$") + ": " + x._2.size).toSeq.sorted.foreach(s => Logging.info("  - " + s))
    ret
  }
}

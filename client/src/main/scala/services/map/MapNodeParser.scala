package services.map

import models.node.Node
import util.Logging

import scala.scalajs.js
import scala.util.control.NonFatal

object MapNodeParser {
  def parse(o: js.Dynamic): Seq[Node] = {
    val tilemapLayers = o.data.layers.asInstanceOf[js.Array[js.Dictionary[js.Any]]].toSeq.filter(_.apply("type").toString == "objectgroup")
    val objects = tilemapLayers.flatMap(_.apply("objects").asInstanceOf[js.Array[js.Any]].toSeq)
    objects.map(o => try {
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
  }
}

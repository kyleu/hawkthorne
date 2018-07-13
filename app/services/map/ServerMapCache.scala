package services.map

import models.map.ServerMap
import models.node.Node
import util.Logging
import util.JsonSerializers._

object ServerMapCache extends Logging {
  private[this] val cache = collection.mutable.HashMap.empty[String, ServerMap]

  def apply(key: String) = cache.getOrElseUpdate(key, {
    val startNanos = System.nanoTime
    val path = s"public/game/maps/$key.json"
    val is = Option(getClass.getClassLoader.getResourceAsStream(path)).getOrElse(throw new IllegalStateException(s"Cannot load [$path]."))
    val json = parseJson(scala.io.Source.fromInputStream(is).mkString).right.get
    val ret = fromJson(key, json)
    log.info(s"Loaded map [$key] in [${((System.nanoTime - startNanos) / 1000000).toString.take(8)}ms],")
    ret
  })

  private[this] def fromJson(key: String, json: Json) = {
    val layerObjects = json.asObject.get.apply("layers").get.asArray.get.map(_.asObject.get)

    val (tileLayers, objectGroups) = layerObjects.partition(l => l.apply("type").get.asString.get match {
      case "tilelayer" => true
      case "objectgroup" => false
      case x => throw new IllegalStateException(s"Unhandled type [$x]")
    })

    val layers = tileLayers.map(_.apply("name").get.asString.get)
    val nodes = objectGroups.flatMap { g =>
      g.apply("objects").get.asArray.get.map(_.as[Node].right.get)
    }
    ServerMap(key = key, layers = layers, nodes = nodes)
  }
}

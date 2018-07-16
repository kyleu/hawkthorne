package services.map

import io.circe.{Json, JsonObject}
import models.map.ServerMap
import models.node.Node
import util.Logging
import util.JsonSerializers._

object ServerMapCache extends Logging {
  private[this] val cache = collection.mutable.HashMap.empty[String, ServerMap]

  private[this] val debug = true
  val unusedFields = collection.mutable.HashMap.empty[String, Set[String]]
  val unusedProperties = collection.mutable.HashMap.empty[String, Set[String]]

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

    val nodeArray = objectGroups.flatMap(g => g.apply("objects").get.asArray.get)
    val nodes = nodeArray.map(json => json.as[Node] match {
      case Right(n) => n
      case Left(x) => throw new IllegalStateException(s"Error parsing node json: ${x.getMessage}\n${json.spaces2}", x)
    })

    if (debug) {
      nodes.zip(nodeArray).foreach { x =>
        val src = x._2.asObject.get
        val tgt = x._1.asJson.asObject.get

        val srcKeys = src.keys.filterNot(_ == "propertytypes").toSet
        val tgtKeys = tgt.keys.toSet
        val unused = srcKeys.filterNot(tgtKeys.apply)
        unusedFields(x._1.t) = unusedFields.getOrElse(x._1.t, Set.empty) ++ unused

        if (tgtKeys("properties")) {
          val srcProps = src("properties").map(_.asObject.getOrElse(JsonObject.empty)).getOrElse(JsonObject.empty)
          val tgtProps = tgt("properties").map(_.asObject.getOrElse(JsonObject.empty)).getOrElse(JsonObject.empty)

          val srcPropsKeys = srcProps.keys.filterNot(_.isEmpty).toSet
          val tgtPropsKeys = tgtProps.keys.toSet
          val unusedProps = srcPropsKeys.filterNot(tgtPropsKeys.apply)
          unusedProperties(x._1.t) = unusedProperties.getOrElse(x._1.t, Set.empty) ++ unusedProps
        }
      }
    }

    ServerMap(key = key, layers = layers, nodes = nodes)
  }
}

package services.map

import io.circe.{Json, JsonObject}
import models.collision.CollisionGrid
import models.data.map.TiledMap
import models.map.ServerMap
import models.node.Node
import util.Logging
import util.JsonSerializers._

object ServerMapCache extends Logging {
  private[this] val cache = collection.mutable.HashMap.empty[String, ServerMap]

  private[this] val debug = true
  private[this] val unusedFields = collection.mutable.HashMap.empty[String, Set[String]]
  private[this] val unusedProperties = collection.mutable.HashMap.empty[String, Set[String]]

  lazy val unused = (all, unusedFields.toMap, unusedProperties.toMap)

  def all = TiledMap.values.map(apply)

  def apply(map: TiledMap) = cache.getOrElseUpdate(map.value, synchronized {
    val startNanos = System.nanoTime
    val path = s"public/game/maps/${map.value}.json"
    val is = Option(getClass.getClassLoader.getResourceAsStream(path)).getOrElse(throw new IllegalStateException(s"Cannot load [$path]."))
    val json = parseJson(scala.io.Source.fromInputStream(is).mkString)
    val ret = fromJson(map.value, json)
    log.debug(s"Loaded map [${map.value}] in [${((System.nanoTime - startNanos) / 1000000).toString.take(8)}ms],")
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

    val collisionOption = tileLayers.find(_.apply("name").contains("collision".asJson)).map(c => CollisionGrid.forJson(c.asJson))

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

    ServerMap(key = key, layers = layers, nodes = nodes, collisionGrid = collisionOption)
  }
}

package models.map

import models.data.map.TiledMap
import models.node.Node
import util.JsonSerializers._

object ServerMap {
  implicit val jsonEncoder: Encoder[ServerMap] = deriveEncoder
  implicit val jsonDecoder: Decoder[ServerMap] = deriveDecoder
}

final case class ServerMap(key: String, layers: Seq[String], nodes: Seq[Node]) {
  lazy val tiled = TiledMap.withValue(key)
}

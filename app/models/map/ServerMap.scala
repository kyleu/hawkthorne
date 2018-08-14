package models.map

import models.collision.{CollisionGrid, CollisionPoly}
import models.data.map.TiledMap
import models.node.{Node, SimpleNode}
import util.JsonSerializers._
import util.Logging

object ServerMap {
  implicit val jsonEncoder: Encoder[ServerMap] = deriveEncoder
  implicit val jsonDecoder: Decoder[ServerMap] = deriveDecoder
}

final case class ServerMap(key: String, layers: Seq[String], nodes: Seq[Node], collisionGrid: Option[CollisionGrid]) extends Logging {
  lazy val tiled = TiledMap.withValue(key)

  lazy val collision = collisionGrid match {
    case Some(grid) => Right(grid)
    case None => Left(CollisionPoly(nodes.collectFirst {
      case s: SimpleNode if s.primary => s.polygon.getOrElse(throw new IllegalStateException("No polygon for primary [$key] node")).toIndexedSeq
    }.getOrElse(throw new IllegalStateException(s"No primary node or collision layer for [$key]"))))
  }

  lazy val collisionSummary = collision match {
    case Right(grid) => s"Grid containing [${grid.tiles.size} of ${tiled.width * tiled.height}] tiles"
    case Left(poly) => s"Poly containing [${poly.points.size}] points"
  }
}

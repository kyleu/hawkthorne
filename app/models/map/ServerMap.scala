package models.map

import models.collision.{CollisionGrid, CollisionPoly}
import models.data.map.TiledMap
import models.node.Node
import util.JsonSerializers._
import util.Logging

object ServerMap {
  implicit val jsonEncoder: Encoder[ServerMap] = deriveEncoder
  implicit val jsonDecoder: Decoder[ServerMap] = deriveDecoder
}

final case class ServerMap(tiled: TiledMap, nodes: Seq[Node], collisionGrid: Option[CollisionGrid]) extends Logging {
  lazy val collision = collisionGrid match {
    case Some(grid) => Right(grid)
    case None => Left(CollisionPoly.fromNodes(tiled.value, nodes))
  }

  lazy val collisionSummary = collision match {
    case Right(grid) => s"Grid containing [${grid.tiles.size} of ${tiled.width * tiled.height}] tiles"
    case Left(poly) => s"Poly containing [${poly.polygon.points.size}] points and [${poly.blockers.size}] blockers"
  }
}

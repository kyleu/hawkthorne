package models.collision

import models.node.{Node, SimpleNode}
import util.JsonSerializers._
import util.Polygon

object CollisionPoly {
  implicit val jsonEncoder: Encoder[CollisionPoly] = deriveEncoder
  implicit val jsonDecoder: Decoder[CollisionPoly] = deriveDecoder

  def fromNodes(key: String, nodes: Seq[Node]) = {
    val primary = nodes.collectFirst {
      case s: SimpleNode if s.primary => s.polygonObj.getOrElse(throw new IllegalStateException(s"No polygon for primary [$key] node"))
    }.getOrElse(throw new IllegalStateException(s"No primary node or collision layer for [$key]"))

    val blockers = nodes.collect {
      case s: SimpleNode if s.polygon.isDefined && !s.primary => s.polygonObj.getOrElse(throw new IllegalStateException(s"No polygon for [$key] node"))
    }.toIndexedSeq

    CollisionPoly(polygon = primary, blockers = blockers)
  }
}

case class CollisionPoly(polygon: Polygon, blockers: IndexedSeq[Polygon])

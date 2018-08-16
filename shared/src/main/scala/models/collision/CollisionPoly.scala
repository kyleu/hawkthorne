package models.collision

import models.node.{Node, SimpleNode}
import util.JsonSerializers._

object CollisionPoly {
  implicit val jsonEncoder: Encoder[CollisionPoly] = deriveEncoder
  implicit val jsonDecoder: Decoder[CollisionPoly] = deriveDecoder

  def fromNodes(key: String, nodes: Seq[Node]) = {
    val points = nodes.collectFirst {
      case s: SimpleNode if s.primary => s.polygon.getOrElse(throw new IllegalStateException(s"No polygon for primary [$key] node")).toIndexedSeq
    }.getOrElse(throw new IllegalStateException(s"No primary node or collision layer for [$key]"))
    val blockers = nodes.collect {
      case s: SimpleNode if s.polygon.isDefined && !s.primary =>
        s.polygon.getOrElse(throw new IllegalStateException(s"No polygon for [$key] node")).toIndexedSeq
    }.toIndexedSeq
    CollisionPoly(points = points, blockers = blockers)
  }
}

case class CollisionPoly(points: IndexedSeq[util.Point], blockers: IndexedSeq[IndexedSeq[util.Point]])

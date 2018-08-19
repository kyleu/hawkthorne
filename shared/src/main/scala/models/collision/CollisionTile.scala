package models.collision

import util.JsonSerializers._

object CollisionTile {
  implicit val jsonEncoder: Encoder[CollisionTile] = deriveEncoder
  implicit val jsonDecoder: Decoder[CollisionTile] = deriveDecoder
}

case class CollisionTile(x: Int, y: Int, tile: Int, h: Boolean, v: Boolean, d: Boolean) {
  lazy val collisionBlockType = CollisionBlockType.fromInt(tile)
  lazy val slopeEdges = CollisionBlockType.slopeEdges(tile)
  lazy val special = CollisionBlockType.special(tile)
}

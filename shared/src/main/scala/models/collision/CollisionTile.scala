package models.collision

import util.JsonSerializers._

object CollisionTile {
  implicit val jsonEncoder: Encoder[CollisionTile] = deriveEncoder
  implicit val jsonDecoder: Decoder[CollisionTile] = deriveDecoder

  private[this] val FLAG_FLIP_HORIZONTALLY = 0x80000000
  private[this] val FLAG_FLIP_VERTICALLY = 0x40000000
  private[this] val FLAG_FLIP_DIAGONALLY = 0x20000000
  private[this] val MASK_CLEAR = 0xE0000000

  def fromInts(index: Int, width: Int, z: Int) = {
    val h = (z & FLAG_FLIP_HORIZONTALLY) != 0
    val v = (z & FLAG_FLIP_VERTICALLY) != 0
    val d = (z & FLAG_FLIP_DIAGONALLY) != 0
    val t = z & ~MASK_CLEAR
    if (t == 0) {
      None
    } else {
      Some(CollisionTile(x = index % width, y = index / width, tile = t, h = h, v = v, d = d))
    }
  }
}

case class CollisionTile(x: Int, y: Int, tile: Int, h: Boolean = false, v: Boolean = false, d: Boolean = false) {
  lazy val collisionBlockType = CollisionBlockType.fromInt(tile)
  lazy val slopeEdges = CollisionBlockType.slopeEdges(tile)
  lazy val special = CollisionBlockType.special(tile)
}

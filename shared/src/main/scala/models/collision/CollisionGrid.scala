package models.collision

import java.util.Base64

import io.circe.Json
import util.JsonSerializers._

object CollisionGrid {
  private[this] def unsignedByteToInt(b: Byte) = b & 0xFF
  private[this] val FLAG_FLIP_HORIZONTALLY = 0x80000000
  private[this] val FLAG_FLIP_VERTICALLY = 0x40000000
  private[this] val FLAG_FLIP_DIAGONALLY = 0x20000000
  private[this] val MASK_CLEAR = 0xE0000000

  implicit val jsonEncoder: Encoder[CollisionGrid] = deriveEncoder
  implicit val jsonDecoder: Decoder[CollisionGrid] = deriveDecoder

  def forJson(json: Json) = CollisionGrid(getTileData(json))

  private[this] def getTileData(json: Json) = {
    val o = json.asObject.getOrElse(throw new IllegalStateException("Not an object"))

    if (!o("encoding").get.as[String].contains("base64")) {
      throw new IllegalStateException("Requires Base64 encoding.")
    }

    val name = jsonToObj[String](o("name").get)
    val height = jsonToObj[Int](o("height").get)
    val width = jsonToObj[Int](o("width").get)
    val data = jsonToObj[String](o("data").get)

    val decoded = Base64.getDecoder.decode(data)

    if ((decoded.length / 4) != (width * height)) {
      throw new IllegalStateException(s"Decoded: ${decoded.length} / 4) != ($width * $height)")
    }

    val nums = decoded.grouped(4).map { group =>
      unsignedByteToInt(group(0)) | unsignedByteToInt(group(1)) << 8 | unsignedByteToInt(group(2)) << 16 | unsignedByteToInt(group(3)) << 24
    }.toIndexedSeq

    nums.zipWithIndex.flatMap {
      case n if n._1 == 0 => None
      case n =>
        val h = (n._1 & FLAG_FLIP_HORIZONTALLY) != 0
        val v = (n._1 & FLAG_FLIP_VERTICALLY) != 0
        val d = (n._1 & FLAG_FLIP_DIAGONALLY) != 0
        Some(CollisionTile(x = n._2 % width, y = n._2 / width, tile = n._1 & ~MASK_CLEAR, h = h, v = v, d = d))
    }.sortBy(t => t.y -> t.x)
  }
}

case class CollisionGrid(tiles: Seq[CollisionTile]) {
  private[this] val map = tiles.map(t => (t.x, t.y) -> t).toMap

  def forCoords(coords: (Int, Int)) = map.get(coords)
}

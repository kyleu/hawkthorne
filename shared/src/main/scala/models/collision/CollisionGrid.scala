package models.collision

import java.util.Base64

import io.circe.{Json, JsonObject}
import util.JsonSerializers._

object CollisionGrid {
  private[this] def unsignedByteToInt(b: Byte) = b & 0xFF

  implicit val jsonEncoder: Encoder[CollisionGrid] = deriveEncoder
  implicit val jsonDecoder: Decoder[CollisionGrid] = deriveDecoder

  def forJson(json: Json, firstTileId: Int) = CollisionGrid(getTileData(json, firstTileId))

  private[this] def getTileData(json: Json, firstTileId: Int) = {
    val o = json.asObject.getOrElse(throw new IllegalStateException("Not an object"))

    val height = jsonToObj[Int](o("height").get)
    val width = jsonToObj[Int](o("width").get)

    o("encoding") match {
      case Some(encoding) if encoding.asString.contains("base64") => decodeBase64Layer(o, width, height, firstTileId)
      case Some(encoding) => throw new IllegalStateException(s"Unhandled encoding [$encoding]")
      case None => o("data") match {
        case Some(data) => data.asArray.get.map {
          case x if x.isNumber => jsonToObj[Int](x)
          case x if x.isNull => 0
          case x => throw new IllegalStateException(s"Unhandled data [$x]")
        }.zipWithIndex.flatMap(n => CollisionTile.fromInts(index = n._2, width = width, z = n._1 - firstTileId))
        case None => throw new IllegalStateException("Requires data with optional Base64 encoding")
      }
    }
  }

  private[this] def decodeBase64Layer(o: JsonObject, width: Int, height: Int, firstTileId: Int) = {
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
      case n => CollisionTile.fromInts(index = n._2, width = width, z = n._1 - firstTileId)
    }.sortBy(t => t.y -> t.x)
  }
}

case class CollisionGrid(tiles: Seq[CollisionTile]) {
  private[this] val map = tiles.map(t => (t.x, t.y) -> t).toMap

  def forCoords(coords: (Int, Int)) = map.get(coords)
}

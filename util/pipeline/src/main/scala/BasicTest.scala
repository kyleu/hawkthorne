import java.util.Base64

import better.files._
import util.JsonSerializers._

object BasicTest {
  private val FLAG_FLIP_HORIZONTALLY = 0x80000000
  private val FLAG_FLIP_VERTICALLY = 0x40000000
  private val FLAG_FLIP_DIAGONALLY = 0x20000000
  private val MASK_CLEAR = 0xE0000000 // TODO

  protected def unsignedByteToInt(b: Byte) = b & 0xFF

  def foo(): Unit = {
    val f = "./data/test/acschool-collision-layer.json".toFile
    val js = f.contentAsString
    val j = parseJson(js)
    val o = j.asObject.getOrElse(throw new IllegalStateException("Not an object"))

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

    val ids = decoded.grouped(4).map { group =>
      unsignedByteToInt(group(0)) | unsignedByteToInt(group(1)) << 8 | unsignedByteToInt(group(2)) << 16 | unsignedByteToInt(group(3)) << 24
    }.toIndexedSeq

    if (ids.length != (width * height)) {
      throw new IllegalStateException(s"Ids: ${ids.length} / 4) != ($width * $height)")
    }

    println(ids)
  }
}

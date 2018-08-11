package models.font

import com.definitelyscala.phaserce._
import models.asset.Asset

object Font {
  val fonts = Seq("arial", "big", "courier", "small")
  val assets = fonts.map(f => Asset.Image(s"font.$f", s"images/fonts/$f.png"))

  val chars = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,!?-+/\\:;%&`'*#=\"$()<>{}áíóúñ¿¡éü^"
  val charMap = chars.zipWithIndex.toMap

  private[this] val fontMap = collection.mutable.HashMap.empty[String, Font]

  def getFont(key: String, game: Game) = fontMap.getOrElseUpdate(key, load(game, key))
  def reset() = fontMap.clear()

  case class CharLocation(char: Char, startIndex: Int, width: Int, height: Int) {
    val area = new Rectangle(startIndex.toDouble, 0, width.toDouble, height.toDouble)
  }

  private[this] def load(game: Game, key: String) = {
    val img = new Image(game, 0, 0, s"font.$key")
    val height = img.height.toInt
    val data = game.add.bitmapData(img.width, img.height, s"font.$key.data")
    data.draw(img, 0, 0)
    data.update()
    val charStartIndexes = collection.mutable.ArrayBuffer.empty[(Int, Int)]
    var currentStartIndex = -1

    (0 until data.width.toInt).foreach { x =>
      val top = data.getPixel(x.toDouble, 4)
      if (top.r.toString == "255" && top.g.toString == "255" && top.b.toString == "0") {
        if (currentStartIndex > -1) {
          charStartIndexes += currentStartIndex -> (x - currentStartIndex)
          currentStartIndex = -1
        }
      } else {
        if (currentStartIndex == -1) {
          currentStartIndex = x
        }
      }
    }
    if (charStartIndexes.size != chars.length) {
      util.Logging.warn(s"Font [$key] expected [${chars.length}] chars, found [${charStartIndexes.size}].")
    }
    new Font(key, img, charStartIndexes.zip(chars).map(x => CharLocation(x._2, x._1._1, x._1._2, height)))
  }
}

class Font(val key: String, val img: Image, val chars: IndexedSeq[Font.CharLocation]) {
  val textureKey = s"font.$key"
  val height = img.height
  val padding = if (height < 10) { 1 } else { 2 }

  def render(name: String, text: String, game: Game, x: Double = 0.0, y: Double = 0.0, color: Option[Int] = None) = {
    new FontText(game = game, name = name, font = this, text = text, x = x, y = y, color = color)
  }

  private[this] val sprites = Font.chars.map { c =>
    val location = chars(Font.charMap(c))
    val i = new Sprite(game = img.game, x = 0, y = 0, key = textureKey)
    i.cropRect = location.area
    i.updateCrop()
    i
  }

  def spriteCopyFor(char: Char, x: Double = 0, y: Double = 0, color: Int = 0xffffff) = {
    val proto = sprites(Font.charMap(char))
    val i = new Sprite(game = img.game, x = x, y = y, key = textureKey)
    i.cropRect = proto.cropRect
    i.updateCrop()
    i.tint = color.toDouble
    i
  }
}

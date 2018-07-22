package models.font

import com.definitelyscala.phaserce._
import models.asset.Asset

object Font {
  val fonts = Seq("arial", "big", "courier", "small")
  val assets = fonts.map(f => Asset.Image(s"font.$f", s"images/fonts/$f.png"))

  val chars = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,!?-+/\\:;%&`'*#=\"$()<>{}áíóúñ¿¡éü^"
  private val charMap = chars.zipWithIndex.toMap
  private[this] val fontMap = collection.mutable.HashMap.empty[String, Font]

  def getFont(key: String, game: Game) = fontMap.getOrElseUpdate(key, load(game, key))

  private case class CharLocation(char: Char, startIndex: Int, width: Int, height: Int) {
    val area = new Rectangle(startIndex.toDouble, 0, width.toDouble, height.toDouble)
  }

  private[this] def load(game: Game, key: String) = {
    val startMs = System.currentTimeMillis
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
    val font = new Font(key, img, charStartIndexes.zip(chars).map(x => CharLocation(x._2, x._1._1, x._1._2, height)))
    // util.Logging.info(s"Loaded font [$key] in [${System.currentTimeMillis - startMs}ms]: $font")
    font
  }
}

class Font(val key: String, img: Image, chars: IndexedSeq[Font.CharLocation]) {
  val height = img.height
  val padding = if (height < 10) { 1 } else { 2 }
  def renderToTexture(s: String, game: Game) = {
    val locations = s.map(c => chars(Font.charMap(c)))
    val pxWidth = locations.map(_.width).sum.toDouble + (locations.size * padding)
    val tex = game.make.bitmapData(pxWidth, height)
    var currX = 0
    locations.foreach { l =>
      tex.copyRect(img, l.area, currX.toDouble)
      currX += (l.width + padding)
    }
    tex
  }

  def renderToImage(name: String, s: String, game: Game, x: Double = 0.0, y: Double = 0.0, color: Option[String] = None) = {
    val tex = renderToTexture(s, game)
    val image = new Image(game, x, y, tex)
    image.name = name
    color.foreach(c => image.tint = Color.hexToRGB(c))
    image
  }
}

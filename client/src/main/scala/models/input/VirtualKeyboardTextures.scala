package models.input

import com.definitelyscala.phaserce.{Game, Graphics, RenderTexture}
import models.input.VirtualKeyboardKeys._

class VirtualKeyboardTextures(game: Game) {
  private[this] def keyTexture(width: Double) = {
    val w = width * keySize + ((width - 1) * padding)
    val g = new Graphics(game)
    g.beginFill(0x3ebe0f)
    g.drawRoundedRect(0, 0, w, keySize, 4)
    g.endFill()
    g.beginFill(0x1c530e)
    g.drawRoundedRect(1, 1, w - 2, keySize - 2, 4)
    g.endFill()
    g.generateTexture().asInstanceOf[RenderTexture]
  }

  private[this] val keyTextureSizeOne = keyTexture(1)
  private[this] val keyTextureSizeTwo = keyTexture(2)
  private[this] val keyTextureSizeThree = keyTexture(3)
  private[this] val keyTextureSizeSeven = keyTexture(7)

  def forSize(charSize: Int) = charSize match {
    case 1 => keyTextureSizeOne
    case 2 => keyTextureSizeTwo
    case 3 => keyTextureSizeThree
    case 7 => keyTextureSizeSeven
    case x => throw new IllegalStateException(s"Missing texture for width [$x].")
  }
}

package services.ui

import com.definitelyscala.phaserce.Game

class FontService(game: Game) {
  private[this] val charMap = " abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789.,!?-+/\\:;%&`'*#=\"$()<>{}áíóúñ¿¡éü^"

  private[this] def newSmallFont() = game.make.retroFont(
    font = "font",
    characterWidth = 11,
    characterHeight = 18,
    chars = charMap,
    charsPerRow = charMap.length.toDouble,
    xSpacing = 2,
    ySpacing = 0,
    xOffset = 1,
    yOffset = 0
  )

  def renderSmall(s: String) = {
    val font = newSmallFont()
    font.setText(s)
    font
  }
}

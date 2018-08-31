package models.font

import com.definitelyscala.phaserce.Game

class MultilineText(
    game: Game, override val name: String, font: Font, override val text: String, maxWidth: Int, x: Double = 0.0, y: Double = 0.0
) extends FontText(game = game, name = name, font = font, text = text, x = x, y = y) {
  private[this] var activeColor = 0xffffff
  private[this] var runningTotalX = 0
  private[this] var offsetY = 0

  commands.foreach {
    case Left(tint) => activeColor = tint.toInt
    case Right(msg) => msg.foreach { c =>
      val loc = font.location(c)
      val i = font.spriteCopyFor(char = c, x = runningTotalX.toDouble, y = offsetY.toDouble, color = activeColor)
      runningTotalX += i.width.toInt + font.padding
      group.add(i)
    }
  }

  val lines = 1
}

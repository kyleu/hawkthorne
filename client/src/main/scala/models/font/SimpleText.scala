package models.font

import com.definitelyscala.phaserce.Game

class SimpleText(
    game: Game, override val name: String, font: Font, override val text: String, x: Double = 0.0, y: Double = 0.0, color: Option[Int] = None
) extends FontText(game = game, name = name, font = font, text = text, x = x, y = y, color = color) {
  private[this] var activeColor = color.getOrElse(0xffffff)
  private[this] var runningTotalX = 0

  commands.foreach {
    case Left(tint) => activeColor = tint.toInt
    case Right(msg) => msg.foreach { c =>
      val i = font.spriteCopyFor(char = c, x = runningTotalX.toDouble, color = activeColor)
      runningTotalX += i.width.toInt + font.padding
      group.add(i)
    }
  }
}

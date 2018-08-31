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

    case Right(msg) =>
      var acc = ""
      var words = Seq.empty[String]
      msg.foreach {
        case ' ' =>
          words = words :+ (acc + ' ')
          acc = ""
        case c => acc += c
      }
      if (acc.nonEmpty) { words = words :+ acc }

      words.foreach { word =>
        val wordLength = word.foldLeft(0)((size, c) => font.location(c).width + size)
        if (wordLength + runningTotalX > maxWidth) {
          offsetY = offsetY + font.lineHeight
          runningTotalX = 0
        }

        word.foreach { c =>
          val i = font.spriteCopyFor(char = c, x = runningTotalX.toDouble, y = offsetY.toDouble, color = activeColor)
          runningTotalX += i.width.toInt + font.padding
          group.add(i)
        }
      }
  }

  lazy val lines = (offsetY / font.lineHeight) + 1
}

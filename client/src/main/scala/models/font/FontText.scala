package models.font

import com.definitelyscala.phaserce.{Game, Group}
import util.ColorUtils

class FontText(game: Game, val name: String, font: Font, val text: String, x: Double = 0, y: Double = 0, color: Option[Int] = None) {
  val group = new Group(game = game, name = name, addToStage = false)
  group.position.set(x, y)
  var runningTotal = 0

  var bracketDepth = 0
  var acc = ""

  val commands = text.toSeq.flatMap {
    case '{' =>
      bracketDepth += 1
      if (acc.nonEmpty) {
        val ret = Some(Right(acc))
        acc = ""
        ret
      } else {
        None
      }
    case '}' =>
      bracketDepth -= 1
      if (acc.nonEmpty) {
        val ret = Some(Left(ColorUtils.textColors.getOrElse(acc, throw new IllegalStateException(s"Invalid color [$acc] in string [$text]."))))
        acc = ""
        ret
      } else {
        None
      }
    case c if bracketDepth == 2 || bracketDepth == 0 =>
      acc += c
      None
    case c => throw new IllegalStateException(s"Unhandled character [$c] at depth [$bracketDepth] in string [$text].")
  } ++ (if (acc.isEmpty) { Nil } else { Seq(Right(acc)) })

  var activeColor = color.getOrElse(0xffffff)

  commands.foreach {
    case Left(tint) => activeColor = tint.toInt
    case Right(msg) => msg.foreach { c =>
      val i = font.spriteCopyFor(char = c, x = runningTotal.toDouble, color = activeColor)
      runningTotal += i.width.toInt + font.padding
      group.add(i)
    }
  }

  def destroy() = group.destroy()
}

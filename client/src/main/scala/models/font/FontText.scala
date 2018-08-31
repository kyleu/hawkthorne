package models.font

import com.definitelyscala.phaserce.{Game, Group}
import util.ColorUtils

abstract class FontText(game: Game, val name: String, font: Font, val text: String, x: Double = 0, y: Double = 0, color: Option[Int] = None) {
  val group = new Group(game = game, name = name, addToStage = false)
  group.position.set(x, y)

  private[this] var bracketDepth = 0
  private[this] var acc = ""

  val commands = text.toSeq.flatMap {
    case '{' =>
      bracketDepth += 1
      if (acc.nonEmpty) {
        val ret = Right(acc)
        acc = ""
        Seq(ret)
      } else {
        Nil
      }
    case '}' =>
      bracketDepth -= 1
      if (acc.nonEmpty) {
        val ret = Left(ColorUtils.textColors.getOrElse(acc, throw new IllegalStateException(s"Invalid color [$acc] in string [$text].")))
        acc = ""
        Seq(ret)
      } else {
        Nil
      }
    case c if bracketDepth == 2 || bracketDepth == 0 =>
      acc += c
      Nil
    case c => throw new IllegalStateException(s"Unhandled character [$c] at depth [$bracketDepth] in string [$text].")
  } ++ (if (acc.isEmpty) { Nil } else { Seq(Right(acc)) })

  def destroy() = group.destroy()
}

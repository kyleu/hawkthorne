package models.component

import com.definitelyscala.phaserce._
import models.font.Font

final case class ConsoleLog(
    override val game: Game, override val x: Int = 120, override val y: Int = 10
) extends BaseComponent with BaseComponent.Resizable {
  override val name = "ui.console"

  val group = new Group(game, name = "console.log")
  group.x = x.toDouble
  group.y = y.toDouble

  val font = Font.getFont("arial", game)

  val image = font.renderToImage("test.text", "This is a test of the emergency broadcast system. This is only a test!", game)
  group.add(image)

  game.stage.add(group)

  override def resize(width: Int, height: Int) = {
    //group.scale = new Point(2.0, 2.0)
  }
}


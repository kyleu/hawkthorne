package models.component

import com.definitelyscala.phaserce._
import models.component.BaseComponent.Resizable
import models.font.Font

case class ConsoleLog(game: Game) extends BaseComponent with Resizable {
  override val name = "console"

  val group = new Group(game, name = "console.log")

  val font = Font.getFont("arial", game)

  val image = font.renderToImage("test.text", "This is a test of the emergency broadcast system. This is only a test!", game, 120.0, 10.0)
  group.add(image)

  resize(game.width, game.height)
  game.stage.add(group)

  override def resize(width: Double, height: Double) = {
    //group.scale = new Point(2.0, 2.0)
  }
}


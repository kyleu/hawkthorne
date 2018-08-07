package models.gui

import com.definitelyscala.phaserce.{Game, Group}
import models.component.{BaseComponent, SimpleComponent}
import models.font.Font

final case class ConsoleLog(override val game: Game) extends SimpleComponent with BaseComponent.Resizable {
  override val name = "ui.console"

  val group = new Group(game, name = "console.log")
  override def comp = group

  group.x = 120
  group.y = 10

  val font = Font.getFont("arial", game)

  val image = font.renderToImage("test.text", "This is a test of the emergency broadcast system. This is only a test!", game)
  group.add(image)

  game.stage.add(group)

  override def resize(width: Int, height: Int) = {}
}

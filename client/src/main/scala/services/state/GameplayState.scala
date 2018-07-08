package services.state

import com.definitelyscala.phaserce.{Game, PhaserTextStyle, Point}
import util.JavaScriptUtils

import scala.scalajs.js

object GameplayState {
  def load(phaser: Game) = new LoadingState(next = new GameplayState(phaser), phaser = phaser)
}

class GameplayState(phaser: Game) extends GameState("gameplay", phaser) {
  override def create(game: Game) = {
    println("Hawkthore started.")
    val style = JavaScriptUtils.as[PhaserTextStyle](js.Dynamic.literal(font = "bold 32px Arial", fill = "#fff"))
    val t = game.add.text(game.width / 2, game.height / 2, "TODO", style)
    t.colors = js.Array("#fff")
    t.anchor = new Point(0.5, 0.5)
  }
}

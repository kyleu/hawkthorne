package services.state

import com.definitelyscala.datgui.{GUI, GUIParams}
import com.definitelyscala.phaserce.Game
import models.character.{CharacterTemplate, Characters, Costume}
import models.player.Player
import util.JavaScriptUtils

class SandboxState() extends GameState("initial") {
  override def create(game: Game) = {
    val players = Characters.allCostumes.zipWithIndex.map {
      case (c, idx) => new Player(c._1, c._2, (idx % 28) * 48.0, (idx / 28) * 48.0, game)
    }
    println("Sandbox started.")

    val params = JavaScriptUtils.as[GUIParams](scalajs.js.Dynamic.literal())
    val gui = new GUI(params)
    val f = gui.addFolder("Player 0")
    f.add(players.head, "x", 0, 2000.0)
    f.add(players.head, "y", 0, 2000.0)
  }
}

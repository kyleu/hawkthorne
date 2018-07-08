package services.state

import com.definitelyscala.datgui.{GUI, GUIParams}
import com.definitelyscala.phaserce.Game
import models.character.Characters
import models.player.Player
import util.JavaScriptUtils

object SandboxState {
  def load(phaser: Game) = {
    new LoadingState(
      next = new SandboxState(phaser),
      phaser = phaser,
      audio = Seq("music.daybreak" -> s"audio/music/daybreak.ogg"),
      spritesheets = Characters.allCostumes.map { c =>
        (s"${c._1.id}.${c._2.key}", s"images/character/${c._1.id}/${c._2.key}.png", 48, 48)
      }
    )
  }
}

class SandboxState(phaser: Game) extends GameState("sandbox", phaser) {
  override def create(game: Game) = {
    val players = Characters.allCostumes.zipWithIndex.map {
      case (c, idx) => new Player(c._1, c._2, (idx % 28) * 48.0, (idx / 28) * 48.0, game)
    }
    val bg = game.add.audio("music.daybreak").play(loop = true)
    println("Sandbox started.")

    val params = JavaScriptUtils.as[GUIParams](scalajs.js.Dynamic.literal())
    val gui = new GUI(params)
    val f = gui.addFolder("Player 0")
    f.add(players.head, "x", 0, 2000.0)
    f.add(players.head, "y", 0, 2000.0)
  }
}

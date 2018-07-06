package services.state

import com.definitelyscala.datgui.{GUI, GUIParams}
import com.definitelyscala.phaserce.Game
import models.character.{CharacterTemplate, Characters, Costume}
import models.player.Player
import util.JavaScriptUtils

class SandboxState() extends GameState("initial") {
  private[this] var characters: Seq[(CharacterTemplate, Costume)] = Characters.all.flatMap(c => c.costumes.map(c -> _))

  override def preload(game: Game) = {
    val urls = characters.map(c => s"${c._1.id}.${c._2.key}" -> s"/assets/game/images/character/${c._1.id}/${c._2.key}.png")
    urls.foreach(url => game.load.spritesheet(url._1, url._2, 48, 48))
  }

  override def create(game: Game) = {
    val players = characters.zipWithIndex.map { case (c, idx) => new Player(c._1, c._2, (idx % 28) * 48.0, (idx / 28) * 48.0, game) }
    println("Sandbox started.")

    val params = JavaScriptUtils.as[GUIParams](scalajs.js.Dynamic.literal())
    val gui = new GUI(params)
    val f = gui.addFolder("Player 0")
    f.add(players.head, "x", 0, 2000.0)
    f.add(players.head, "y", 0, 2000.0)
  }
}

package services.state

import com.definitelyscala.datgui.{GUI, GUIParams}
import com.definitelyscala.phaserce.Game
import models.character.Characters
import models.player.{Player, PlayerSprite}
import util.JavaScriptUtils

import scala.util.Random

object SandboxState {
  def load(phaser: Game) = {
    new LoadingState(
      next = new SandboxState(phaser),
      phaser = phaser,
      assets = LoadingState.Assets(
        audio = Seq("music.daybreak" -> s"audio/music/daybreak.ogg"),
        spritesheets = Characters.allCostumes.map(c => (s"${c._1.key}.${c._2.key}", s"images/character/${c._1.key}/${c._2.key}.png", 48, 48))
      )
    )
  }
}

class SandboxState(phaser: Game) extends GameState("sandbox", phaser) {
  private[this] lazy val group = game.add.group(name = s"test.group")

  lazy val players = Characters.allCostumes.zipWithIndex.map {
    case (c, idx) => new PlayerSprite(game, group, Player(c._1.key, c._2.key), (idx % 28) * 48, (idx / 28) * 48)
  }

  override def create(game: Game) = {
    players.toString

    val bgAudio = game.add.audio("music.daybreak").play(loop = true)
    println("Sandbox started.")

    val params = JavaScriptUtils.as[GUIParams](scalajs.js.Dynamic.literal())
    val gui = new GUI(params)
    val f = gui.addFolder("Player 0")
    f.add(players.head.sprite, "x", 0, 2000.0)
    f.add(players.head.sprite, "y", 0, 2000.0)
  }

  override def update(game: Game) = players.foreach {
    case p if Random.nextInt(30) == 0 => p.sprite.frame = Random.nextInt(12 * 16)
    case _ => // noop
  }
}

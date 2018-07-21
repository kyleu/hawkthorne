package services.state

import com.definitelyscala.datgui.{GUI, GUIParams}
import com.definitelyscala.phaserce.{Game, Point}
import models.asset.Asset
import models.player.CharacterTemplate
import models.player.{Player, PlayerSprite}
import util.JavaScriptUtils

import scala.util.Random

object SandboxState {
  def load(phaser: Game) = {
    new LoadingState(
      next = new SandboxState(phaser),
      phaser = phaser,
      assets = Asset.Audio("music.daybreak", s"audio/music/daybreak.ogg") +: CharacterTemplate.allCostumes.map { c =>
        Asset.Spritesheet(s"${c._1.key}.${c._2.key}", s"images/character/${c._1.key}/${c._2.key}.png", 48, 48)
      }
    )
  }
}

class SandboxState(phaser: Game) extends GameState("sandbox", phaser) {
  private[this] lazy val group = game.add.group(name = s"test.group")

  lazy val players = CharacterTemplate.allCostumes.zipWithIndex.map {
    case (c, idx) => new PlayerSprite(
      game = game,
      group = group,
      player = Player(templateKey = c._1.key, costumeKey = c._2.key),
      initialX = 32 + ((idx % 28) * 48),
      initialY = 32 + ((idx / 28) * 48),
      physics = false
    )
  }

  override def create(game: Game) = {
    players.toString

    game.add.audio("music.daybreak").play(loop = true)

    val params = JavaScriptUtils.as[GUIParams](scalajs.js.Dynamic.literal())
    val gui = new GUI(params)
    val f = gui.addFolder("Player 0")
    f.add(players.head.sprite, "x", 0, 2000.0)
    f.add(players.head.sprite, "y", 0, 2000.0)
    players.foreach(_.sprite.scale = new Point(1.0, 1.0))
  }

  override def update(game: Game) = players.foreach {
    case p if Random.nextInt(30) == 0 => p.sprite.frame = Random.nextInt(12 * 16)
    case _ => // noop
  }
}

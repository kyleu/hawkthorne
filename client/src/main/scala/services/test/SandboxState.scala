package services.test

import com.definitelyscala.datgui.{GUI, GUIParams}
import com.definitelyscala.phaserce.{Game, Point}
import models.asset.Asset
import models.component.PlayerSprite
import models.player.Player
import models.template.character.CharacterListing
import services.audio.MusicService
import services.state.{GameState, LoadingState}
import util.JavaScriptUtils

import scala.util.Random

object SandboxState {
  def load(phaser: Game) = {
    new LoadingState(
      next = new SandboxState(phaser),
      phaser = phaser,
      assets = MusicService.asset("daybreak") +: CharacterListing.allCostumes.map { c =>
        Asset.Spritesheet(s"${c._1.key}.${c._2.key}", s"images/characters/${c._1.key}/${c._2.key}.png", 48, 48)
      }
    )
  }
}

class SandboxState(phaser: Game) extends GameState("sandbox", phaser) {
  private[this] lazy val group = game.add.group(name = s"test.group")

  lazy val players = CharacterListing.allCostumes.zipWithIndex.map {
    case (c, idx) => new PlayerSprite(
      game = game,
      group = group,
      idx = 0,
      player = Player(templateKey = c._1.key, costumeKey = c._2.key),
      initialX = 32 + ((idx % 28) * 48),
      initialY = 32 + ((idx / 28) * 48)
    )
  }

  override def create(game: Game) = {
    players.toString

    MusicService.play("daybreak", loop = true)

    val params = JavaScriptUtils.as[GUIParams](scalajs.js.Dynamic.literal())
    val gui = new GUI(params)
    val f = gui.addFolder("Player 0")
    f.add(players.head.as.sprite, "x", 0, 2000.0)
    f.add(players.head.as.sprite, "y", 0, 2000.0)
    players.foreach(_.as.sprite.scale.set(1.0, 1.0))
  }

  override def update(game: Game) = players.foreach {
    case p if Random.nextInt(30) == 0 => p.as.sprite.frame = Random.nextInt(12 * 16)
    case _ => // noop
  }
}

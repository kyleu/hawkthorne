package services.test

import java.util.UUID

import com.definitelyscala.phaserce.Game
import models.asset.Asset
import models.component.PlayerSprite
import models.player.Player
import models.template.character.CharacterListing
import services.audio.MusicService
import services.state.{GameState, LoadingState}

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
      player = Player(id = UUID.randomUUID, idx = 0, templateKey = c._1.key, costumeKey = c._2.key),
      initialLoc = (32 + ((idx % 28) * 48), 32 + ((idx / 28) * 48)),
      initialBounds = (0, 0)
    )
  }

  override def create(game: Game) = {
    MusicService.play("daybreak", loop = true)
    players.foreach(_.setScale(1.0))
  }

  override def update(game: Game) = players.foreach {
    case p if Random.nextInt(30) == 0 => p.setFrame(Random.nextInt(12 * 16))
    case _ => // noop
  }
}

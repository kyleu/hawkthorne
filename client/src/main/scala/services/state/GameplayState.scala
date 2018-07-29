package services.state

import com.definitelyscala.phaserce.{Game, PhysicsObj}
import models.asset._
import models.component.HudOverlay
import models.font.Font
import models.game.GameOptions
import models.phaser.PhaserGame
import models.player.Player
import services.audio.SoundEffectService
import services.game.GameplayService
import services.map.MapService

object GameplayState {
  def load(phaser: PhaserGame, options: GameOptions, player: Player) = new LoadingState(
    next = new GameplayState(phaser, options, player),
    phaser = phaser,
    assets = SoundEffectService.gameplayAssets ++ MapService.assetsFor(options.map) ++
      HudOverlay.assets ++ Font.assets ++ Seq(Asset.spritesheetFromTuple(player.spritesheet))
  )
}

class GameplayState(phaser: PhaserGame, options: GameOptions, player: Player) extends GameState(s"game", phaser) {
  private[this] var svc: Option[GameplayService] = None
  private[this] def service = svc.getOrElse(throw new IllegalStateException("Not initialized"))

  override def create(game: Game) = svc = {
    game.physics.startSystem(PhysicsObj.ARCADE)
    Some(new GameplayService(phaser, options, player))
  }

  override def update(game: Game) = service.update()

  override def onResize(width: Int, height: Int) = service.resize(width, height)
}

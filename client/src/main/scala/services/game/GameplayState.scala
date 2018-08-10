package services.game

import com.definitelyscala.phaserce.Game
import models.asset._
import models.font.Font
import models.gui.HudOverlay
import models.options.GameOptions
import models.player.Player
import services.audio.SoundEffectService
import services.input.InputService
import services.map.MapService
import services.state.{GameState, LoadingState}

object GameplayState {
  def load(phaser: Game, input: InputService, options: GameOptions, player: Player) = new LoadingState(
    next = new GameplayState(phaser = phaser, inputService = input, options = options, player = player),
    phaser = phaser,
    assets = SoundEffectService.gameplayAssets ++ MapService.assetsFor(options.map) ++
      HudOverlay.assets ++ Font.assets ++ Seq(Asset.spritesheetFromTuple(player.spritesheet))
  )
}

class GameplayState(phaser: Game, inputService: InputService, options: GameOptions, player: Player) extends GameState(s"game", phaser) {
  private[this] var svc: Option[GameplayService] = None
  private[this] def service = svc.getOrElse(throw new IllegalStateException("Not initialized"))

  override def create(game: Game) = svc = {
    Some(new GameplayService(game = game, inputService = inputService, options = options, player = player))
  }

  override def update(game: Game) = service.update()

  override def onResize(width: Int, height: Int) = service.resize(width, height)

  override def shutdown(game: Game) = {
    inputService.menuHandler.setCallback(None)
    super.shutdown(game)
  }
}

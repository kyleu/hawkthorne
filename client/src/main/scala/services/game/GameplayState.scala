package services.game

import com.definitelyscala.phaserce.Game
import models.asset._
import models.gui.GuiAssets
import models.options.GameOptions
import models.player.Player
import services.audio.SoundEffectService
import services.input.InputService
import services.map.MapService
import services.state.{GameState, LoadingState}

object GameplayState {
  def load(phaser: Game, input: InputService, options: GameOptions, players: IndexedSeq[Player]) = new LoadingState(
    next = new GameplayState(phaser = phaser, inputService = input, options = options, players = players),
    phaser = phaser,
    assets = SoundEffectService.gameplayAssets ++ GuiAssets.assets ++ MapService.assetsFor(options.map) ++ players.map(p => Asset.fromTuple(p.spritesheet))
  )
}

class GameplayState(phaser: Game, inputService: InputService, options: GameOptions, players: IndexedSeq[Player]) extends GameState(s"game", phaser) {
  private[this] var svc: Option[GameplayService] = None
  private[this] def service = svc.getOrElse(throw new IllegalStateException("Gameplay service not initialized."))

  override def create(game: Game) = svc = {
    Some(new GameplayService(game = game, inputService = inputService, options = options, initialPlayers = players))
  }

  override def update(game: Game) = service.update()

  override def onResize(width: Int, height: Int) = service.resize(width, height)

  override def shutdown(game: Game) = {
    inputService.menuHandler.setCallback(None)
    service.shutdown()
    super.shutdown(game)
  }
}

package services.state

import com.definitelyscala.phaserce.Game
import models.asset._
import models.component.HudOverlay
import models.game.GameOptions
import models.player.Player
import services.GameplayService
import services.map.MapService

object GameplayState {
  def load(phaser: Game, options: GameOptions, player: Player) = new LoadingState(
    next = new GameplayState(phaser, options, player),
    phaser = phaser,
    assets = (MapService.assetsFor(options.map) ++ HudOverlay.assets) :+ Asset.spritesheetFromTuple(player.spritesheet)
  )
}

class GameplayState(phaser: Game, options: GameOptions, player: Player) extends GameState(s"game", phaser) {
  private[this] var svc: Option[GameplayService] = None
  private[this] def service = svc.getOrElse(throw new IllegalStateException("Not initialized"))

  override def create(game: Game) = svc = Some(new GameplayService(game, options, player))

  override def update(game: Game) = service.update()

  override def resize(width: Double, height: Double) = service.resize(width, height)
}

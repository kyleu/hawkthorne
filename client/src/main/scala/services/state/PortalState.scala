package services.state

import com.definitelyscala.phaserce.Game
import models.component.Portal
import models.data.character.Abed
import models.font.Font
import models.player.Player
import services.input.InputService

object PortalState {
  val tempCostume = Abed.randomCostume

  def load(phaser: Game, inputService: InputService, debug: Boolean) = new LoadingState(
    next = new PortalState(phaser = phaser, inputService = inputService, debug = debug), phaser = phaser,
    assets = Portal.assets("abed", tempCostume.key)
  )
}

class PortalState(phaser: Game, inputService: InputService, debug: Boolean) extends GameState("test", phaser) {
  private[this] var portal: Option[Portal] = None

  override def create(game: Game) = {
    Font.reset()
    portal = Some(new Portal(game, Player(templateKey = "abed", costumeKey = PortalState.tempCostume.key)))
    inputService.menuHandler.setCallback(Some(s => ()))
  }

  override def update(game: Game) = {
    val dt = game.time.physicsElapsed
    portal.foreach(_.update(dt))
    inputService.update(dt)
  }

  override def shutdown(game: Game) = {
    inputService.menuHandler.setCallback(None)
    super.shutdown(game)
  }
}

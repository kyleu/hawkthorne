package services.state

import com.definitelyscala.phaserce.Game
import models.asset.Asset
import models.font.Font
import models.input.{MenuAction, PointerAction}
import services.input.InputService

object CreditsState {
  val assets = Font.assets ++ Seq(Asset.music("daybreak"))

  def load(phaser: Game, inputService: InputService, debug: Boolean) = new LoadingState(
    next = new CreditsState(phaser = phaser, inputService = inputService, debug = debug), phaser = phaser, assets = assets
  )
}

class CreditsState(phaser: Game, inputService: InputService, debug: Boolean) extends GameState("test", phaser) {
  override def create(game: Game) = {
    inputService.setPointerEventCallback(Some(pointerAct))
    inputService.menuHandler.setCallback(Some(x => onMenuAction(x)))
    resize(game.width, game.height)
  }

  private[this] def pointerAct(pointerAction: PointerAction) = util.Logging.info(s"Credits pointer action [$pointerAction]")

  private[this] def onMenuAction(acts: Seq[MenuAction]) = util.Logging.info(s"Credits menu actions [${acts.mkString(", ")}]")
}

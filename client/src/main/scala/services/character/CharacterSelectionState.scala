package services.character

import com.definitelyscala.phaserce.Game
import models.analytics.AnalyticsActionType
import models.asset.Asset
import models.input.{MenuAction, PointerAction}
import services.input.InputService
import services.socket.AnalyticsService
import services.state.{GameState, LoadingState}

object CharacterSelectionState {
  private[this] val assets = Seq.empty[Asset]

  def load(phaser: Game, input: InputService, debug: Boolean = false) = {
    new LoadingState(next = new CharacterSelectionState(phaser, input, debug), phaser = phaser, assets = assets)
  }
}

class CharacterSelectionState(phaser: Game, inputService: InputService, debug: Boolean) extends GameState("charselect", phaser) {
  private[this] var charSelect: Option[CharacterSelectionService] = None

  override def create(game: Game) = {
    inputService.setPointerEventCallback(Some(pointerAct))
    inputService.menuHandler.setCallback(Some(acts => menuActs(acts)))

    charSelect = Some(CharacterSelectionService(phaser, character = "jeff"))

    onResize(width = game.width.toInt, height = game.height.toInt)
    AnalyticsService.send(AnalyticsActionType.IntroStart, io.circe.Json.obj())
  }

  override def update(game: Game) = {
    val dt = game.time.physicsElapsed
    inputService.update(dt)
    charSelect.foreach(_.update(dt))
  }

  override def shutdown(game: Game) = {
    inputService.menuHandler.setCallback(None)
    inputService.setPointerEventCallback(None)
    super.shutdown(game)
  }

  override def onResize(width: Int, height: Int) = charSelect.foreach(_.resize(width, height))

  private[this] def pointerAct(pointerAction: PointerAction) = charSelect.foreach(_.onPointer(pointerAction))

  private[this] def menuActs(acts: Seq[MenuAction]) = charSelect.foreach(_.menuActions(acts))
}

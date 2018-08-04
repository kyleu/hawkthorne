package services.map

import com.definitelyscala.phaserce.Game
import models.font.Font
import models.input.{MenuAction, PointerAction}
import services.audio.MusicService
import services.input.InputService
import services.state.{GameState, LoadingState}

object OverworldMapState {
  def load(phaser: Game, inputService: InputService, debug: Boolean) = new LoadingState(
    next = new OverworldMapState(phaser = phaser, inputService = inputService, debug = debug), phaser = phaser, assets = OverworldMapAssets.assets
  )
}

class OverworldMapState(phaser: Game, inputService: InputService, debug: Boolean) extends GameState("test", phaser) {
  private[this] var map: Option[OverworldMap] = None

  override def create(game: Game) = {
    Font.reset()
    MusicService.play(OverworldMapAssets.music, loop = true)
    map = Some(OverworldMap(game, "greendale"))
    map.foreach(m => game.add.existing(m.group))
    inputService.menuHandler.setCallback(Some(x => onMenuAction(x)))
    inputService.setPointerEventCallback(Some(pointerAct))
    resize(game.width, game.height)
  }

  override def update(game: Game) = {
    val dt = game.time.physicsElapsed
    inputService.update(dt)
    map.foreach(_.update(dt))
  }

  override def shutdown(game: Game) = {
    MusicService.stop(OverworldMapAssets.music)
    inputService.menuHandler.setCallback(None)
    inputService.setPointerEventCallback(None)
    super.shutdown(game)
  }

  override def onResize(width: Int, height: Int) = map.foreach(_.resize(width, height))

  private[this] def pointerAct(pointerAction: PointerAction) = {

  }

  private[this] def onMenuAction(acts: Seq[MenuAction]) = acts.foreach(a => map.foreach(_.menuAct(a)))
}

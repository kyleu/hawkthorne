package services.options

import com.definitelyscala.phaserce.Game
import models.asset.Asset
import models.component.VerticalParticles
import models.font.Font
import models.input.{MenuAction, PointerAction}
import services.audio.{MusicService, SoundEffectService}
import services.input.InputService
import services.state.{GameState, LoadingState, NavigationService}

object OptionsState {
  def load(phaser: Game, inputService: InputService, debug: Boolean) = new LoadingState(
    next = new OptionsState(phaser = phaser, inputService = inputService, debug = debug), phaser = phaser,
    assets = Font.assets ++ SoundEffectService.menuAssets ++ Seq(
      Asset.music("daybreak"),
      Asset.Image("options.checkbox.true", "images/menu/checkbox_checked.png"),
      Asset.Image("options.checkbox.false", "images/menu/checkbox_unchecked.png"),
      Asset.Image("options.menu.bg", "images/menu/pause.png"),
      Asset.Image(s"options.menu.arrow", s"images/menu/arrow.png"),
      Asset.Image(s"options.meter.bg", s"images/menu/range.png"),
      Asset.Image(s"options.meter.arrow", s"images/menu/small_arrow_up.png")
    )
  )
}

class OptionsState(phaser: Game, inputService: InputService, debug: Boolean) extends GameState("test", phaser) {
  private[this] var particles: Option[VerticalParticles] = None
  private[this] var options: Option[OptionsMenu] = None

  override def create(game: Game) = {
    Font.reset()
    MusicService.play("daybreak", loop = true)
    particles = Some(new VerticalParticles(game))
    options = Some(new OptionsMenu(game, () => NavigationService.navigateTo(game, inputService, "menu", debug)))

    inputService.setPointerEventCallback(Some(pointerAct))
    inputService.menuHandler.setCallback(Some(x => onMenuAction(x)))
    resize(game.width, game.height)
  }

  override def update(game: Game) = {
    val dt = game.time.physicsElapsed
    inputService.update(dt)
    particles.foreach(_.update(dt))
  }

  override def shutdown(game: Game) = {
    MusicService.stop("daybreak")
    inputService.menuHandler.setCallback(None)
    inputService.setPointerEventCallback(None)
    super.shutdown(game)
  }

  override def onResize(width: Int, height: Int) = {
    options.foreach(_.resize(width, height))
  }

  private[this] def pointerAct(pointerAction: PointerAction) = options.foreach(_.onPointer(pointerAction))

  private[this] def onMenuAction(acts: Seq[MenuAction]) = options.foreach(_.menuActions(acts))
}

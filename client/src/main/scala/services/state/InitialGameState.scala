package services.state

import com.definitelyscala.phaserce._
import com.definitelyscala.phasercepixi.WebGLRenderer
import models.input.InputCommand
import models.settings.ClientSettings
import org.scalajs.dom
import services.audio.{MusicService, SoundEffectService}
import services.debug.DebugService
import services.input.InputService
import util.JavaScriptUtils

class InitialGameState(nextState: InputService => GameState, phaser: Game, debug: Boolean) extends GameState("initial", phaser) {
  private[this] var input: Option[InputService] = None

  override def preload(game: Game) = {
    game.time.advancedTiming = true
    Canvas.setImageRenderingCrisp(phaser.canvas)
    game.load.image(key = "splash", url = LoadingState.prefix + "images/menu/splash.png")
    game.load.spritesheet(key = "progress", url = LoadingState.prefix + "images/scanning/scanningbar.png", frameWidth = 121.0, frameHeight = 13.0)
  }

  override def create(game: Game) = {
    dom.window.addEventListener("resize", { _: dom.Event =>
      val w = org.scalajs.dom.window.innerWidth
      val h = org.scalajs.dom.window.innerHeight
      game.state.getCurrentState().resize(w, h)
    })

    val inputService = new InputService(game, systemCommandHandler)
    inputService.menuHandler.setCallback(Some(_ => ()))
    input = Some(inputService)

    MusicService.reset(game)
    SoundEffectService.reset(game)
    ClientSettings.loadAndApply()

    if (debug) { DebugService.init(phaser) }

    JavaScriptUtils.as[WebGLRenderer](game.renderer).renderSession.roundPixels = true
    Canvas.setImageRenderingCrisp(game.canvas)

    game.stage.disableVisibilityChange = true

    //game.scale.scaleMode = ScaleManager.NO_SCALE
    game.scale.scaleMode = ScaleManager.RESIZE

    val s = game.add.sprite(game.width / 2, game.height / 2, "splash")
    s.anchor = util.PhaserUtils.centerPoint
    val scale = game.width * 0.6 / s.width
    s.scale.set(scale, scale)

    val nState = nextState(inputService)

    game.state.add(nState.key, nState, autoStart = false)

    val splash = dom.document.getElementById("splash")
    splash.parentNode.removeChild(splash)

    game.state.start(nState.key, clearWorld = false, clearCache = false)
  }

  def systemCommandHandler(cmd: InputCommand) = cmd match {
    case InputCommand.Debug => DebugService.inst.foreach(_.toggle())
    case _ => throw new IllegalStateException(s"Unhandled system command [$cmd]")
  }

  override def shutdown(game: Game) = {
    input.foreach(_.menuHandler.setCallback(None))
    super.shutdown(game)
  }
}

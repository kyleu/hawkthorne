package services.state

import com.definitelyscala.phaserce._
import com.definitelyscala.phasercepixi.WebGLRenderer
import org.scalajs.dom
import services.debug.DebugService
import util.JavaScriptUtils

class InitialGameState(nextState: GameState, phaser: Game, debug: Boolean) extends GameState("initial", phaser) {
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

    if (debug) { DebugService.init(phaser) }

    JavaScriptUtils.as[WebGLRenderer](game.renderer).renderSession.roundPixels = true
    Canvas.setImageRenderingCrisp(game.canvas)

    game.stage.disableVisibilityChange = true

    //game.scale.scaleMode = ScaleManager.NO_SCALE
    game.scale.scaleMode = ScaleManager.RESIZE

    val s = game.add.sprite(game.width / 2, game.height / 2, "splash")
    s.anchor = util.PhaserUtils.centerPoint
    val scale = game.width * 0.6 / s.width
    s.scale = new Point(scale, scale)

    game.state.add(nextState.key, nextState, autoStart = false)

    // val msg = NavigationService.initialMessage
    // NavigationService.navigate(game, msg._1, msg._2)

    val splash = dom.document.getElementById("splash")
    splash.parentNode.removeChild(splash)

    game.state.start(nextState.key, clearWorld = false, clearCache = false)
  }
}

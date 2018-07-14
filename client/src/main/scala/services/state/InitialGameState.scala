package services.state

import com.definitelyscala.phaserce._
import com.definitelyscala.phasercepixi.WebGLRenderer
import org.scalajs.dom
import services.ui.DebugService
import util.JavaScriptUtils

class InitialGameState(nextState: GameState, phaser: Game, debug: Boolean) extends GameState("initial", phaser) {
  override def preload(game: Game) = {
    Canvas.setImageRenderingCrisp(phaser.canvas)
    game.load.image("splash", LoadingState.prefix + "images/splash.png")
    game.load.spritesheet("progress", LoadingState.prefix + "images/progress.png", 121.0, 13.0)
  }

  override def create(game: Game) = {
    dom.window.addEventListener("resize", { _: dom.Event =>
      var w = org.scalajs.dom.window.innerWidth
      game.scale.setGameSize(w, org.scalajs.dom.window.innerHeight)
      game.state.getCurrentState().resize(w, org.scalajs.dom.window.innerHeight)
    })

    DebugService.initPhaser(phaser, debug)

    JavaScriptUtils.as[WebGLRenderer](game.renderer).renderSession.roundPixels = true
    game.stage.disableVisibilityChange = true
    game.scale.scaleMode = ScaleManager.NO_SCALE

    val s = game.add.sprite(game.width / 2, game.height / 2, "splash")
    s.anchor = new Point(0.5, 0.5)
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

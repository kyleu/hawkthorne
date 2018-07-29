package services.state

import com.definitelyscala.phaserce._
import com.definitelyscala.phasercepixi.WebGLRenderer
import models.data.map.TiledMap
import models.game.GameOptions
import models.phaser.PhaserGame
import models.player.Player
import org.scalajs.dom
import services.debug.DebugService
import util.JavaScriptUtils

object InitialGameState {
  def initialState(phaser: PhaserGame, path: String) = {
    path.trim match {
      case "" => GameplayState.load(phaser, GameOptions(map = TiledMap.BlackCaverns2, scenario = "new"), Player.default)
      case "intro" => IntroState.load(phaser)
      // case "menu" => MenuState.load(phaser)
      case "test" => TestState.load(phaser)
      case "sandbox" => SandboxState.load(phaser)
      case x if x.startsWith("map/") =>
        val opts = GameOptions(map = TiledMap.withValue(x.stripPrefix("map/")), scenario = "new")
        GameplayState.load(phaser, opts, Player.default)
      case x if x.startsWith("test/") => MapTestState.load(phaser, TiledMap.withValue(x.stripPrefix("test/")))
      case _ => throw new IllegalStateException(s"Unknown path [$path]")
    }
  }
}

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

package services.state

import com.definitelyscala.phaserce._
import com.definitelyscala.phasercepixi.WebGLRenderer
import models.data.map.TiledMap
import models.game.GameOptions
import models.player.Player
import models.settings.ClientSettings
import org.scalajs.dom
import services.debug.DebugService
import services.input.InputService
import util.JavaScriptUtils

object InitialGameState {
  def initialState(phaser: Game, input: InputService, path: String) = {

    path.trim match {
      case "" => GameplayState.load(phaser = phaser, input = input, options = GameOptions(
        map = TiledMap.BlackCaverns2, scenario = "new"), player = Player.default
      )
      case "intro" => IntroState.load(phaser = phaser, input = input)
      case "menu" => IntroState.load(phaser = phaser, input = input, skipToMenu = true)
      case "test" => TestState.load(phaser = phaser)
      case "sandbox" => SandboxState.load(phaser = phaser)

      case x if x.startsWith("map/") =>
        val opts = GameOptions(map = TiledMap.withValue(x.stripPrefix("map/")), scenario = "new")
        GameplayState.load(phaser = phaser, input = input, options = opts, player = Player.default)
      case x if x.startsWith("test/") => MapTestState.load(phaser = phaser, map = TiledMap.withValue(x.stripPrefix("test/")))
      case _ => throw new IllegalStateException(s"Unknown path [$path]")
    }
  }
}

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

    val inputService = new InputService(game)
    inputService.menuHandler.setCallback(Some(x => ()))
    input = Some(inputService)

    val settings = ClientSettings.load()

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

    val nState = nextState(inputService)

    game.state.add(nState.key, nState, autoStart = false)

    val splash = dom.document.getElementById("splash")
    splash.parentNode.removeChild(splash)

    game.state.start(nState.key, clearWorld = false, clearCache = false)
  }

  override def shutdown(game: Game) = {
    input.foreach(_.menuHandler.setCallback(None))
    super.shutdown(game)
  }
}

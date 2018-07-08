import com.definitelyscala.phaserce.{Game, IGameConfig, Phaser}
import services.state._
import util.JavaScriptUtils

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("Hawkthorne")
class Hawkthorne(path: String, debug: Boolean) {
  println("Welcome to Hawkthorne!")

  path.trim match {
    case "" => startGame(GameplayState.load())
    case "intro" => startGame(IntroScanState.load())
    case "test" => startGame(TestState.load())
    case "sandbox" => startGame(SandboxState.load())
    case _ => util.Logging.warn(s"Unknown path [$path]")
  }

  private[this] def startGame(nextState: GameState) = {
    js.Dynamic.global.window.PhaserGlobal = js.Dynamic.literal(
      hideBanner = true
    )

    val config = JavaScriptUtils.as[IGameConfig](js.Dynamic.literal(
      width = "100%",
      height = "100%",
      renderer = Phaser.WEBGL, // TODO Phaser.WEBGL_MULTI
      enableDebug = true,
      clearBeforeRender = false,
      antialias = false,
      multiTexture = true,
      parent = "hawkthorne",
      resolution = 1 // org.scalajs.dom.window.devicePixelRatio
    ))
    val game = new Game(config)
    js.Dynamic.global.phaser = game

    game.state.add("initial", new InitialGameState(nextState))
    game.state.start("initial", clearWorld = true, clearCache = true)
  }
}

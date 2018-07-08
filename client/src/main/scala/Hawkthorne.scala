import com.definitelyscala.phaserce.{Game, IGameConfig, Phaser}
import services.state._
import util.JavaScriptUtils

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("Hawkthorne")
class Hawkthorne(path: String, debug: Boolean) {
  println("Welcome to Hawkthorne!")

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
  val phaser = new Game(config)
  js.Dynamic.global.phaser = phaser

  val nextState = path.trim match {
    case "" => GameplayState.load(phaser)
    case "intro" => IntroScanState.load(phaser)
    case "test" => TestState.load(phaser)
    case "sandbox" => SandboxState.load(phaser)
    case _ => throw new IllegalStateException(s"Unknown path [$path]")
  }

  phaser.state.add("initial", new InitialGameState(nextState, phaser))
  phaser.state.start("initial", clearWorld = true, clearCache = true)
}

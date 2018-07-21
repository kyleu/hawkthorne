package models.phaser

import com.definitelyscala.phaserce.{Game, IGameConfig, Phaser}
import services.state._
import services.ui.NavigationService
import util.JavaScriptUtils

object PhaserGame {
  def getConfig(isWebGL: Boolean) = JavaScriptUtils.as[IGameConfig](scalajs.js.Dynamic.literal(
    width = "100%",
    height = "100%",
    renderer = if (isWebGL) { Phaser.WEBGL_MULTI } else { Phaser.CANVAS },
    enableDebug = true,
    clearBeforeRender = true,
    antialias = false,
    multiTexture = true,
    parent = "hawkthorne",
    resolution = 1 // TODO org.scalajs.dom.window.devicePixelRatio
  ))
}

class PhaserGame(val path: String, val webGL: Boolean, val isDebug: Boolean) extends Game(PhaserGame.getConfig(webGL)) {
  def begin() = {
    val nextState = NavigationService.initialState(this, path)
    state.add("initial", new InitialGameState(nextState = nextState, phaser = this, debug = isDebug))
    state.start("initial", clearWorld = true, clearCache = true)
    this
  }
}

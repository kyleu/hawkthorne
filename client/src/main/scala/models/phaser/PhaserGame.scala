package models.phaser

import com.definitelyscala.phaserce.{Game, IGameConfig, Phaser}
import services.state._
import services.ui.NavigationService
import util.JavaScriptUtils

object PhaserGame {
  val config = JavaScriptUtils.as[IGameConfig](scalajs.js.Dynamic.literal(
    width = "100%",
    height = "100%",
    renderer = Phaser.WEBGL, // TODO Phaser.WEBGL_MULTI
    enableDebug = true,
    clearBeforeRender = false,
    antialias = false,
    multiTexture = true,
    parent = "hawkthorne",
    resolution = org.scalajs.dom.window.devicePixelRatio
  ))
}

class PhaserGame(val path: String, val isDebug: Boolean) extends Game(PhaserGame.config) {
  def begin() = {
    val nextState = NavigationService.initialState(this, path)
    state.add("initial", new InitialGameState(nextState, this))
    state.start("initial", clearWorld = true, clearCache = true)
  }
}

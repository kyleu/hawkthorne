package models.phaser

import com.definitelyscala.phaserce.{Game, IGameConfig, Phaser}
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
    resolution = 1 // org.scalajs.dom.window.devicePixelRatio
  ))
}

class PhaserGame() extends Game(PhaserGame.config)

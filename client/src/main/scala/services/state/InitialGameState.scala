package services.state

import com.definitelyscala.phaserce.{Game, PluginObj, ScaleManager, State}
import com.definitelyscala.phasercepixi.WebGLRenderer
import util.JavaScriptUtils

import scala.scalajs.js

class InitialGameState extends State {
  override def create(game: Game) = {
    /*
    dom.window.addEventListener("resize", { _: dom.Event =>
      var w = org.scalajs.dom.window.innerWidth
      game.scale.setGameSize(w, org.scalajs.dom.window.innerHeight)
      game.state.getCurrentState().resize()
    })
     */

    val debugPlugin = js.Dynamic.global.Phaser.Plugin.Debug
    if (debugPlugin.toString != "undefined") {
      this.game.add.plugin(JavaScriptUtils.as[PluginObj](debugPlugin))
    }

    JavaScriptUtils.as[WebGLRenderer](game.renderer).renderSession.roundPixels = true
    game.stage.disableVisibilityChange = true
    game.scale.scaleMode = ScaleManager.NO_SCALE

    // GameState.values.foreach(gs => game.state.add(gs.key, gs.baseState))

    // val msg = NavigationService.initialMessage
    // NavigationService.navigate(game, msg._1, msg._2)
  }
}

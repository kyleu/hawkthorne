import com.definitelyscala.phaserce.Game
import services.event.{HawkthorneEventHandler, HawkthorneSystem}
import services.socket.SocketConnection
import services.state.NavigationService
import util.{ExceptionHandler, PhaserUtils}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("Hawkthorne")
class Hawkthorne(path: String, debug: Boolean) {
  val startMs = System.currentTimeMillis
  util.Logging.info("Welcome to Hawkthorne!")

  ExceptionHandler.install()

  val connection = initNetwork()
  val phaser = initPhaser()

  private[this] def initNetwork(): SocketConnection = {
    val handler = new HawkthorneEventHandler(onReady = () => HawkthorneSystem(connection, phaser, startMs))
    new SocketConnection("hawkthorne", handler = handler, binary = !debug)
  }

  private[this] def initPhaser() = {
    js.Dynamic.global.window.PhaserGlobal = js.Dynamic.literal(hideBanner = true)
    val webGL = true // dom.window.navigator.userAgent.indexOf("AppleWebKit") > -1

    val game = new Game(PhaserUtils.getConfig(webGL))
    js.Dynamic.global.phaser = game

    NavigationService.init(game = game, path = path, debug = debug)
    game
  }
}

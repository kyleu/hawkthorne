import models.phaser.PhaserGame
import org.scalajs.dom
import services.event.EventHandler
import services.socket.SocketConnection

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel

object Hawkthorne {
  var phaserStarted = false
  var networkStarted = false
  var networkConnected = false
}

@JSExportTopLevel("Hawkthorne")
class Hawkthorne(path: String, debug: Boolean) extends EventHandler {
  util.Logging.info("Welcome to Hawkthorne!")

  val connection = initNetwork()
  initPhaser()

  private[this] def initPhaser() = {
    js.Dynamic.global.window.PhaserGlobal = js.Dynamic.literal(hideBanner = true)
    val webGL = dom.window.navigator.userAgent.indexOf("AppleWebKit") > -1
    js.Dynamic.global.phaser = new PhaserGame(path = path, webGL = webGL, isDebug = debug).begin()
  }

  private[this] def initNetwork() = {
    val handler = new EventHandler {
      override def onConnect() = {
        Hawkthorne.networkConnected = true
        super.onConnect()
      }
      override def onClose() = {
        Hawkthorne.networkConnected = false
        super.onClose()
      }
    }

    val c = new SocketConnection("hawkthorne", handler = handler, binary = !debug)
    c.connect(s"/connect?binary=${!debug}")
    c
  }
}

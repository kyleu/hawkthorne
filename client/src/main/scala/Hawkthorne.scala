import models.RequestMessage.Ping
import models.{RequestMessage, ResponseMessage}
import models.data.map.TiledMap
import models.phaser.PhaserGame
import org.scalajs.dom.raw.Event
import services.event.EventHandler
import services.socket.{NetworkMessage, SocketConnection}
import services.state._

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel

object Hawkthorne {
  var phaserStarted = false
  var networkStarted = false
  var networkConnected = false
}

@JSExportTopLevel("Hawkthorne")
class Hawkthorne(path: String, debug: Boolean) extends EventHandler {
  println("Welcome to Hawkthorne!")

  val connection = initNetwork()
  initPhaser()

  private[this] def initPhaser() = {
    js.Dynamic.global.window.PhaserGlobal = js.Dynamic.literal(
      hideBanner = true
    )

    val phaser = new PhaserGame()
    js.Dynamic.global.phaser = phaser

    val nextState = path.trim match {
      case "" => GameplayState.load(phaser)
      case "intro" => IntroScanState.load(phaser)
      case "test" => TestState.load(phaser)
      case "sandbox" => SandboxState.load(phaser)
      case x if x.startsWith("map/") => MapState.load(phaser, TiledMap.withValue(x.stripPrefix("map/")))
      case _ => throw new IllegalStateException(s"Unknown path [$path]")
    }

    phaser.state.add("initial", new InitialGameState(nextState, phaser))
    phaser.state.start("initial", clearWorld = true, clearCache = true)
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

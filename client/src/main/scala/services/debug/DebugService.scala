package services.debug

import com.definitelyscala.datgui.{GUI, GUIParams}
import com.definitelyscala.phaserce.{Game, PluginObj}
import io.circe.Json
import models.analytics.AnalyticsActionType
import models.component.{BaseComponent, PlayerSprite}
import models.game.CheatOption
import models.node.Node
import models.settings.ClientSettings
import org.scalajs.dom
import org.scalajs.dom.Element
import services.map.MapService
import services.socket.AnalyticsService
import util.{DatGuiUtils, JavaScriptUtils}

import scala.scalajs.js

object DebugService {
  private[this] var debugService: Option[DebugService] = None

  def initialized = debugService.isDefined
  def inst = debugService

  def init(phaser: Game) = {
    debugService.foreach(_ => throw new IllegalStateException("Double init!"))
    debugService = Some(new DebugService(phaser))
  }
}

class DebugService private (phaser: Game) {
  private[this] var visible = true

  val params = JavaScriptUtils.as[GUIParams](scalajs.js.Dynamic.literal())
  val gui = new GUI(params)

  val settingsFolder = gui.addFolder("Settings")
  DatGuiUtils.addFunction(settingsFolder, "Reload Settings", () => util.Logging.info(s"Loaded Settings: ${ClientSettings.load()}"))
  DatGuiUtils.addFunction(settingsFolder, "Debug Settings", () => util.Logging.info(s"Current Settings: ${ClientSettings.getSettings}"))

  val networkFolder = gui.addFolder("Network")
  DatGuiUtils.addFunction(networkFolder, "Send Test Message", () => {
    AnalyticsService.send(AnalyticsActionType.Debug, Json.obj("cause" -> Json.fromString("ui")))
  })

  val debugPlugin = js.Dynamic.global.Phaser.Plugin.Debug
  if (debugPlugin.toString != "undefined") {
    phaser.add.plugin(JavaScriptUtils.as[PluginObj](debugPlugin))
  }

  def setMap(game: Game, mapService: MapService, nodes: Seq[Node], components: Seq[BaseComponent], players: Seq[PlayerSprite]) = {
    val cheatFolder = gui.addFolder("Cheats")
    CheatOption.values.foreach { c =>
      DatGuiUtils.addFunction(cheatFolder, c.toString, () => util.Logging.info(s"Cheat [$c] (${c.code}) selected: ${c.description}"))
    }

    DebugPhaser.addWorld(gui, game.world)
    DebugPhaser.addCamera(gui, game.camera)

    DebugMapService.addMap(gui, mapService, nodes)
    DebugPlayers.addPlayers(gui, players)

    val componentFolder = gui.addFolder("Components")
    DatGuiUtils.addFunction(componentFolder, "Toggle Debug", () => DebugComponents.toggleDebug(components))
    components.foreach(c => DebugComponents.add(componentFolder, c))
  }

  def toggle() = {
    visible = !visible
    val debugContainer = Option(dom.document.getElementById("pdebug"))
    val menus = Option(dom.document.getElementsByClassName("dg"))
    if (visible) {
      debugContainer.foreach(_.classList.remove("hidden"))
      menus.foreach(x => for (elem <- 0 until x.length) {
        x(elem).asInstanceOf[Element].classList.remove("hidden")
      })
    } else {
      debugContainer.foreach(_.classList.add("hidden"))
      menus.foreach(x => for (elem <- 0 until x.length) {
        x(elem).asInstanceOf[Element].classList.add("hidden")
      })
    }
  }
}

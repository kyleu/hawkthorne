package services.debug

import com.definitelyscala.datgui.{GUI, GUIParams}
import com.definitelyscala.phaserce.{Cache, Game, PluginObj}
import io.circe.Json
import models.analytics.AnalyticsActionType
import models.component.{BaseComponent, PlayerSprite}
import models.gui.{ConsoleLog, HudOverlay}
import models.input.PlayerInputHandler
import models.settings.ClientSettings
import org.scalajs.dom
import org.scalajs.dom.Element
import services.game.GameInstance
import services.map.MapService
import services.socket.AnalyticsService
import util.JsonSerializers._
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

  val cacheFolder = gui.addFolder("Cache")
  DatGuiUtils.addFunction(cacheFolder, "Debug Keys", () => util.Logging.info("Cache keys: " + Json.obj(
    "image" -> phaser.cache.getKeys(Cache.IMAGE).toIndexedSeq.asJson,
    "json" -> phaser.cache.getKeys(Cache.JSON).toIndexedSeq.asJson,
    "sound" -> phaser.cache.getKeys(Cache.SOUND).toIndexedSeq.asJson,
    "tilemap" -> phaser.cache.getKeys(Cache.TILEMAP).toIndexedSeq.asJson,
    "texture" -> phaser.cache.getKeys(Cache.TEXTURE).toIndexedSeq.asJson
  ).spaces2))

  val debugPlugin = js.Dynamic.global.Phaser.Plugin.Debug
  if (debugPlugin.toString != "undefined") {
    phaser.add.plugin(JavaScriptUtils.as[PluginObj](debugPlugin))
  }

  def setUI(consoleLog: ConsoleLog, hud: HudOverlay) = DebugUI.setUI(gui, consoleLog, hud)

  def setGameInstance(instance: GameInstance) = DebugGame.setGameInstance(gui, instance)

  def setMap(game: Game, mapService: MapService, instance: GameInstance, components: Seq[BaseComponent], players: Seq[PlayerSprite]) = {
    DebugMapService.setMap(game, gui, mapService, instance, components, players)
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

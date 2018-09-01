package services.debug

import com.definitelyscala.datgui.{GUI, GUIParams}
import com.definitelyscala.phaserce.{Cache, Game, PluginObj}
import io.circe.Json
import models.analytics.AnalyticsActionType
import models.component.{BaseComponent, PlayerSprite}
import models.gui.{ConsoleLog, HudOverlay}
import models.modal.Dialog
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
    debugService.foreach(_ => throw new IllegalStateException("Double debug service init!"))
    debugService = Some(new DebugService(phaser))
  }
}

class DebugService private (phaser: Game) {
  private[this] var visible = true

  private[this] val params = JavaScriptUtils.as[GUIParams](scalajs.js.Dynamic.literal())
  private[this] val gui = new GUI(params)
  private[this] var guiStuff = Seq.empty[GUI]

  def createSystemFolder(gui: GUI) = {
    val f = gui.addFolder("System")
    DatGuiUtils.addFunction(f, "Reload Settings", () => util.Logging.info(s"Loaded Settings: ${ClientSettings.load()}"))
    DatGuiUtils.addFunction(f, "Debug Settings", () => util.Logging.info(s"Current Settings: ${ClientSettings.getSettings}"))
    DatGuiUtils.addFunction(f, "Cache Keys", () => util.Logging.info("Cache keys: " + Json.obj(
      "image" -> phaser.cache.getKeys(Cache.IMAGE).toIndexedSeq.asJson,
      "json" -> phaser.cache.getKeys(Cache.JSON).toIndexedSeq.asJson,
      "sound" -> phaser.cache.getKeys(Cache.SOUND).toIndexedSeq.asJson,
      "tilemap" -> phaser.cache.getKeys(Cache.TILEMAP).toIndexedSeq.asJson,
      "texture" -> phaser.cache.getKeys(Cache.TEXTURE).toIndexedSeq.asJson
    ).spaces2))
    DatGuiUtils.addFunction(f, "Network Test", () => {
      AnalyticsService.send(AnalyticsActionType.Debug, Json.obj("cause" -> Json.fromString("ui")))
    })
    DatGuiUtils.addFunction(f, "Throw Exception", () => throw new IllegalStateException("Intentionally thrown"))
    f
  }

  val systemFolder = createSystemFolder(gui)

  val debugPlugin = js.Dynamic.global.Phaser.Plugin.Debug
  if (debugPlugin.toString != "undefined") {
    phaser.add.plugin(JavaScriptUtils.as[PluginObj](debugPlugin))
  }

  def setUI(consoleLog: ConsoleLog, hud: HudOverlay, dialog: Dialog) = guiStuff = guiStuff ++ DebugUI.setUI(gui, consoleLog, hud, dialog)

  def setMap(game: Game, mapService: MapService, instance: GameInstance, components: Seq[BaseComponent], players: Seq[PlayerSprite]) = {
    guiStuff = guiStuff :+ DebugGame.setInstance(game, gui, mapService, instance, components, players)
  }

  def clearGameStuff() = {
    guiStuff.foreach(x => gui.asInstanceOf[js.Dynamic].removeFolder(x))
    guiStuff = Nil
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

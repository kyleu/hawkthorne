package services.debug

import com.definitelyscala.datgui.GUI
import models.gui.{ConsoleLog, HudOverlay}
import util.DatGuiUtils

object DebugUI {
  def setUI(gui: GUI, consoleLog: ConsoleLog, hudOverlay: HudOverlay) = {
    val folder = gui.addFolder("GUI")

    val console = folder.addFolder("Console Log")
    console.add(consoleLog.group, "visible").listen()
    DatGuiUtils.addFunction(console, "Test", () => {
      val code = scala.util.Random.alphanumeric.take(4).mkString
      consoleLog.log(s"($code): I am {{red_light}}Hilda{{white}}, I live in the {{olive}}village{{white}}.")
    })

    val hud = folder.addFolder("HUD Overlay")
    console.add(hudOverlay.group, "visible").listen()
    DatGuiUtils.addFunction(hud, "Debug", () => util.Logging.info(hudOverlay.debugString()))
  }
}

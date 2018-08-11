package services.debug

import com.definitelyscala.datgui.GUI
import models.gui.{ConsoleLog, HudOverlay}
import util.DatGuiUtils

object DebugUI {
  def setUI(gui: GUI, consoleLog: ConsoleLog, hudOverlay: HudOverlay) = {
    val folder = gui.addFolder("GUI")

    val console = folder.addFolder("Console Log")
    DatGuiUtils.addFunction(console, "Test", () => consoleLog.log("I am {{red_light}}Hilda{{white}}, I live in the {{olive}}village{{white}}."))

    val hud = folder.addFolder("HUD Overlay")
    DatGuiUtils.addFunction(hud, "Debug", () => {
      util.Logging.info(hudOverlay.pointsText.text)
    })
  }
}

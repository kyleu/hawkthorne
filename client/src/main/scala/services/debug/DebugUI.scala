package services.debug

import com.definitelyscala.datgui.GUI
import models.gui.{ConsoleLog, HudOverlay}
import models.modal.Dialog
import util.DatGuiUtils

import scala.util.Random

object DebugUI {
  def setUI(gui: GUI, consoleLog: ConsoleLog, hudOverlay: HudOverlay, dialog: Dialog) = {
    val folder = gui.addFolder("GUI")

    val console = folder.addFolder("Console Log")
    DatGuiUtils.addFunction(console, "Test", () => {
      val code = scala.util.Random.alphanumeric.take(4).mkString
      consoleLog.log(s"($code): I am {{red_light}}Hilda{{white}}, I live in the {{olive}}village{{white}}.")
    })
    console.add(consoleLog.group, "visible").listen()

    val hud = folder.addFolder("HUD Overlay")
    DatGuiUtils.addFunction(hud, "Random Energy", () => hudOverlay.setEnergy(0, Random.nextInt(101), 100))
    DatGuiUtils.addFunction(hud, "Debug", () => util.Logging.info(hudOverlay.debugString()))
    hud.add(hudOverlay.group, "visible").listen()

    val d = folder.addFolder("Dialog")
    DatGuiUtils.addFunction(d, "Open", () => dialog.show(() => util.Logging.info("Debug dialog opened."), "Dialog test"))
    DatGuiUtils.addFunction(d, "Close", () => dialog.close(() => util.Logging.info("Debug dialog closed.")))

    Seq(folder)
  }
}

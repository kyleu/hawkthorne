package services.debug

import com.definitelyscala.datgui.GUI
import models.gui.{ConsoleLog, HudOverlay}
import util.DatGuiUtils

import scala.util.Random

object DebugUI {
  def setUI(gui: GUI, consoleLog: ConsoleLog, hudOverlay: HudOverlay) = {
    val folder = gui.addFolder("GUI")

    val console = folder.addFolder("Console Log")
    DatGuiUtils.addFunction(console, "Test", () => {
      val code = scala.util.Random.alphanumeric.take(4).mkString
      consoleLog.log(s"($code): I am {{red_light}}Hilda{{white}}, I live in the {{olive}}village{{white}}.")
    })
    console.add(consoleLog.group, "visible").listen()

    val hud = folder.addFolder("HUD Overlay")
    DatGuiUtils.addFunction(hud, "Random Energy", () => hudOverlay.setEnergy(Random.nextInt(101), 100))
    DatGuiUtils.addFunction(hud, "Debug", () => util.Logging.info(hudOverlay.debugString()))
    hud.add(hudOverlay.group, "visible").listen()
  }
}

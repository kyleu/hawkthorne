package services.debug

import com.definitelyscala.datgui.GUI
import services.game.GameInstance
import util.DatGuiUtils

object DebugGame {
  def setGameInstance(gui: GUI, gameInstance: GameInstance) = {
    val folder = gui.addFolder("Game Instance")

    DatGuiUtils.addFunction(folder, "Dump", () => {
      util.Logging.info("TODO!")
    })
  }
}

package services.debug

import com.definitelyscala.datgui.GUI
import services.game.GameInstance
import util.DatGuiUtils
import util.JsonSerializers._

object DebugGame {
  def setGameInstance(gui: GUI, gameInstance: GameInstance) = {
    val folder = gui.addFolder("Game Instance")

    DatGuiUtils.addFunction(folder, "Dump", () => {
      util.Logging.info(gameInstance.asJson.spaces2)
    })
  }
}

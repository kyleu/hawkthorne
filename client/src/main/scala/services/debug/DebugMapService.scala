package services.debug

import com.definitelyscala.datgui.GUI
import com.definitelyscala.phaserce.{Game, TilemapLayer}
import models.component.{BaseComponent, PlayerSprite}
import models.options.CheatOptions
import services.game.GameInstance
import services.map.MapService
import util.DatGuiUtils

object DebugMapService {
  def setMap(game: Game, gui: GUI, mapService: MapService, instance: GameInstance, components: Seq[BaseComponent], players: Seq[PlayerSprite]) = {
    val cheatFolder = gui.addFolder("Cheats")
    CheatOptions.values.foreach { c =>
      DatGuiUtils.addFunction(cheatFolder, c.toString, () => util.Logging.info(s"Cheat [$c] (${c.code}) selected: ${c.description}"))
    }

    val mapFolder = addMap(gui, mapService)
    val playerFolders = DebugPlayers.addPlayers(gui, instance, players)

    val componentFolder = gui.addFolder("Components")
    DatGuiUtils.addFunction(componentFolder, "Toggle Debug", () => DebugComponents.toggleDebug(components))
    components.sortBy(_.name).map(c => DebugComponents.add(componentFolder, c))

    playerFolders ++ Seq(cheatFolder, mapFolder, componentFolder)
  }

  def addMap(gui: GUI, mapService: MapService) = {
    val f = gui.addFolder(s"Map (${mapService.map.value})")
    mapService.layers.foreach(l => addLayer(mapService, f, l))
    f
  }

  private[this] def addLayer(mapService: MapService, root: GUI, layer: TilemapLayer) = {
    val f = root.addFolder(layer.name)
    f.add(layer, "visible")
  }
}

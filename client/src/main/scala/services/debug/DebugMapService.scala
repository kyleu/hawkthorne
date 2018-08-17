package services.debug

import com.definitelyscala.datgui.GUI
import com.definitelyscala.phaserce.{Game, TilemapLayer}
import models.component.{BaseComponent, PlayerSprite}
import models.node.Node
import models.options.CheatOptions
import services.map.MapService
import util.{DatGuiUtils, Logging}

object DebugMapService {
  def setMap(game: Game, gui: GUI, mapService: MapService, components: Seq[BaseComponent], players: Seq[PlayerSprite]) = {
    val cheatFolder = gui.addFolder("Cheats")
    CheatOptions.values.foreach { c =>
      DatGuiUtils.addFunction(cheatFolder, c.toString, () => util.Logging.info(s"Cheat [$c] (${c.code}) selected: ${c.description}"))
    }

    addMap(gui, mapService)
    DebugPlayers.addPlayers(gui, players)

    val componentFolder = gui.addFolder("Components")
    DatGuiUtils.addFunction(componentFolder, "Toggle Debug", () => DebugComponents.toggleDebug(components))
    components.sortBy(_.name).foreach(c => DebugComponents.add(componentFolder, c))
  }

  def addMap(gui: GUI, mapService: MapService) = {
    val f = gui.addFolder(s"Map (${mapService.map.value})")
    mapService.layers.foreach(l => addLayer(mapService, f, l._1, l._2))
  }

  private[this] def addLayer(mapService: MapService, root: GUI, id: String, layer: TilemapLayer) = {
    val f = root.addFolder(id)
    f.add(layer, "visible")
  }

  private[this] def addNode(mapService: MapService, root: GUI, node: Node) = {
    val f = root.addFolder(s"${node.t}[${node.id}]: " + node.name)
    DatGuiUtils.addFunction(f, "Debug", () => Logging.info(util.JsonSerializers.serialize(node).spaces2))
  }
}

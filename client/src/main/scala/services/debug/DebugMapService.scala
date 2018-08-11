package services.debug

import com.definitelyscala.datgui.GUI
import com.definitelyscala.phaserce.{Game, TilemapLayer}
import models.component.{BaseComponent, PlayerSprite}
import models.node.Node
import models.options.CheatOptions
import services.map.MapService
import util.{DatGuiUtils, Logging}

object DebugMapService {
  def setMap(game: Game, gui: GUI, mapService: MapService, nodes: Seq[Node], components: Seq[BaseComponent], players: Seq[PlayerSprite]) = {
    val cheatFolder = gui.addFolder("Cheats")
    CheatOptions.values.foreach { c =>
      DatGuiUtils.addFunction(cheatFolder, c.toString, () => util.Logging.info(s"Cheat [$c] (${c.code}) selected: ${c.description}"))
    }

    DebugPhaser.addWorld(gui, game.world)
    DebugPhaser.addCamera(gui, game.camera)

    addMap(gui, mapService, nodes)
    DebugPlayers.addPlayers(gui, players)

    val componentFolder = gui.addFolder("Components")
    DatGuiUtils.addFunction(componentFolder, "Toggle Debug", () => DebugComponents.toggleDebug(components))
    components.foreach(c => DebugComponents.add(componentFolder, c))
  }

  def addMap(gui: GUI, mapService: MapService, nodes: Seq[Node]) = {
    val f = gui.addFolder(s"Map (${mapService.map.value})")
    val layersFolder = f.addFolder("Layers")
    mapService.layers.foreach(l => addLayer(mapService, layersFolder, l._1, l._2))
    val nodesFolder = f.addFolder("Nodes")
    nodes.foreach(n => addNode(mapService, nodesFolder, n))
  }

  private[this] def addLayer(mapService: MapService, root: GUI, id: String, layer: TilemapLayer) = {
    val f = root.addFolder(id)
    f.add(layer, "visible")
  }

  private[this] def addNode(mapService: MapService, root: GUI, node: Node) = {
    import util.JsonSerializers._
    val f = root.addFolder(s"${node.t}[${node.id}]: " + node.name)
    DatGuiUtils.addFunction(f, "Debug", () => Logging.info(node.asJson.spaces2))
  }
}

package services.debug

import com.definitelyscala.datgui.GUI
import com.definitelyscala.phaserce.TilemapLayer
import models.node.Node
import services.map.MapService
import util.{DatGuiUtils, Logging}

object DebugMapService {
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

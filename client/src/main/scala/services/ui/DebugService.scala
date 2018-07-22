package services.ui

import com.definitelyscala.datgui.{GUI, GUIParams}
import com.definitelyscala.phaserce.{Game, PluginObj, TilemapLayer}
import models.component.BaseComponent
import models.node.Node
import models.player.PlayerSprite
import org.scalajs.dom
import org.scalajs.dom.Element
import services.map.MapService
import util.{DatGuiUtils, JavaScriptUtils, Logging}

import scala.scalajs.js
import scala.util.Random

object DebugService {
  private[this] var debugService: Option[DebugService] = None

  def inst = debugService

  def init(phaser: Game) = {
    debugService.foreach(_ => throw new IllegalStateException("Double init!"))
    debugService = Some(new DebugService(phaser))
  }
}

class DebugService private (phaser: Game) {
  private[this] var visible = true

  val params = JavaScriptUtils.as[GUIParams](scalajs.js.Dynamic.literal())
  val gui = new GUI(params)

  val debugPlugin = js.Dynamic.global.Phaser.Plugin.Debug
  if (debugPlugin.toString != "undefined") {
    phaser.add.plugin(JavaScriptUtils.as[PluginObj](debugPlugin))
  }

  def setMap(game: Game, mapService: MapService, nodes: Seq[Node], components: Seq[BaseComponent], players: Seq[PlayerSprite]) = {
    val cw = gui.addFolder("World")
    DatGuiUtils.addFunction(cw, "Scale", () => util.Logging.info("World Scale: " + game.world.scale))
    DatGuiUtils.addFunction(cw, "Bounds", () => util.Logging.info("World Bounds: " + game.world.bounds))

    val cf = gui.addFolder("Camera")
    cf.add(phaser.camera, "x", 0.0, mapService.mapPxWidth.toDouble).listen()
    cf.add(phaser.camera, "y", 0.0, mapService.mapPxHeight.toDouble).listen()
    cf.add(phaser.camera, "width", 0.0, 500.0).listen()
    cf.add(phaser.camera, "height", 0.0, 500.0).listen()

    val cfs = cf.addFolder("Scale")
    cfs.add(phaser.camera.scale, "x", 0.0, 10.0).listen()
    cfs.add(phaser.camera.scale, "y", 0.0, 10.0).listen()

    val cfb = cf.addFolder("Bounds")
    cfb.add(phaser.camera.bounds, "x", 0.0, mapService.mapPxWidth.toDouble).listen()
    cfb.add(phaser.camera.bounds, "y", 0.0, mapService.mapPxHeight.toDouble).listen()
    cfb.add(phaser.camera.bounds, "width", 0.0, 500.0).listen()
    cfb.add(phaser.camera.bounds, "height", 0.0, 500.0).listen()

    val f = gui.addFolder(s"Map (${mapService.map.value})")
    val layersFolder = f.addFolder("Layers")
    mapService.layers.foreach(l => addLayer(mapService, layersFolder, l._1, l._2))
    val nodesFolder = f.addFolder("Nodes")
    nodes.foreach(n => addNode(mapService, nodesFolder, n))

    players.zipWithIndex.foreach {
      case (playerSprite, idx) =>
        val f = gui.addFolder(s"Player $idx")
        val anims = PlayerSprite.animations.keys.toSeq.sorted
        f.add(playerSprite.sprite, "x", 0.0, mapService.mapPxWidth.toDouble).listen()
        f.add(playerSprite.sprite, "y", 0.0, mapService.mapPxHeight.toDouble).listen()
        DatGuiUtils.addChoices(f, "Animation", "No Animation", "No Animation" +: anims, v => playerSprite.setAnimation(Some(v)))
        DatGuiUtils.addFunction(f, "Random Anim", () => {
          val anim = anims(Random.nextInt(anims.size))
          Logging.info(s"Random animation: [$anim]")
          playerSprite.setAnimation(Some(anim))
        })
    }

    val componentFolder = gui.addFolder("Components")
    components.foreach(c => DebugComponents.add(componentFolder, c))
  }

  def toggle() = {
    visible = !visible
    val debugContainer = Option(dom.document.getElementById("pdebug"))
    val menus = Option(dom.document.getElementsByClassName("dg"))
    if (visible) {
      debugContainer.foreach(_.classList.remove("hidden"))
      menus.foreach(x => for (elem <- 0 until x.length) {
        x(elem).asInstanceOf[Element].classList.remove("hidden")
      })
    } else {
      debugContainer.foreach(_.classList.add("hidden"))
      menus.foreach(x => for (elem <- 0 until x.length) {
        x(elem).asInstanceOf[Element].classList.add("hidden")
      })
    }
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

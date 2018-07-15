package services.ui

import com.definitelyscala.datgui.{GUI, GUIParams}
import com.definitelyscala.phaserce.{Game, PluginObj, TilemapLayer}
import models.player.PlayerSprite
import org.scalajs.dom
import org.scalajs.dom.Element
import services.map.MapService
import util.{DatGuiUtils, JavaScriptUtils, Logging}

import scala.scalajs.js
import scala.util.Random

object DebugService {
  private[this] var debugService: Option[DebugService] = None

  def inst = debugService.getOrElse(throw new IllegalStateException("Not initialized"))

  def init(phaser: Game, debug: Boolean) = {
    debugService.foreach(_ => throw new IllegalStateException("Double init!"))
    debugService = Some(new DebugService(phaser, debug))
  }
}

class DebugService private (phaser: Game, debug: Boolean) {
  private[this] var visible = false

  private[this] var mapOpt: Option[MapService] = None
  private[this] def mapService = mapOpt.getOrElse(throw new IllegalStateException("No map service."))

  val params = JavaScriptUtils.as[GUIParams](scalajs.js.Dynamic.literal())
  val gui = new GUI(params)

  visible = debug
  if (debug) {
    val debugPlugin = js.Dynamic.global.Phaser.Plugin.Debug
    if (debugPlugin.toString != "undefined") {
      phaser.add.plugin(JavaScriptUtils.as[PluginObj](debugPlugin))
    }
  }

  def setMap(mapService: MapService) = {
    mapOpt.foreach(_ => throw new IllegalStateException("Already set map"))
    mapOpt = Some(mapService)
    val f = gui.addFolder(s"Map (${mapService.map.value})")
    val layersFolder = f.addFolder("Layers")
    mapService.layers.foreach(l => addLayer(mapService, layersFolder, l._1, l._2))
    mapService.collisionLayer.foreach(c => addLayer(mapService, layersFolder, "collision", c))
  }

  def addPlayer(playerSprite: PlayerSprite) = {
    val f = gui.addFolder("Player 0")
    val anims = PlayerSprite.animations.keys.toSeq.sorted
    f.add(playerSprite.sprite, "x", 0.0, mapService.mapPxWidth).listen()
    f.add(playerSprite.sprite, "y", 0.0, mapService.mapPxHeight).listen()
    DatGuiUtils.addChoices(f, "Animation", "No Animation", "No Animation" +: anims, v => playerSprite.setAnimation(Some(v)))
    DatGuiUtils.addFunction(f, "Random Anim", () => {
      val anim = anims(Random.nextInt(anims.size))
      Logging.info(s"Random animation: [$anim]")
      playerSprite.setAnimation(Some(anim))
    })
  }

  def toggle() = {
    visible = !visible
    val debugContainer = Option(dom.document.getElementById("pdebug"))
    val menus = Option(dom.document.getElementsByClassName("dg"))
    if (visible) {
      debugContainer.foreach(_.classList.remove("hidden"))
      menus.foreach(x => for (elem <- 0 until x.length) {
        val el = x(elem).asInstanceOf[Element].classList.remove("hidden")
      })
    } else {
      debugContainer.foreach(_.classList.add("hidden"))
      menus.foreach(x => for (elem <- 0 until x.length) {
        val el = x(elem).asInstanceOf[Element].classList.add("hidden")
      })
    }
  }

  private[this] def addLayer(mapService: MapService, root: GUI, id: String, layer: TilemapLayer) = {
    val f = root.addFolder(id)
    f.add(layer, "visible")
  }
}

package services.ui

import com.definitelyscala.datgui.{GUI, GUIParams}
import com.definitelyscala.phaserce.{Game, PluginObj}
import models.player.PlayerSprite
import org.scalajs.dom
import org.scalajs.dom.Element
import util.{DatGuiUtils, JavaScriptUtils, Logging}

import scala.scalajs.js
import scala.util.Random

object DebugService {
  private[this] var visible = false
  private[this] var g: Option[Game] = None
  private[this] def game = g.getOrElse(throw new IllegalStateException("Not initialized."))

  def initPhaser(phaser: Game, debug: Boolean) = {
    visible = debug
    g = Some(phaser)
    if (debug) {
      val debugPlugin = js.Dynamic.global.Phaser.Plugin.Debug
      if (debugPlugin.toString != "undefined") {
        game.add.plugin(JavaScriptUtils.as[PluginObj](debugPlugin))
      }
    }
  }

  def initGui(playerSprite: PlayerSprite) = {
    val params = JavaScriptUtils.as[GUIParams](scalajs.js.Dynamic.literal())
    val gui = new GUI(params)
    val f = gui.addFolder("Player 0")
    val anims = PlayerSprite.animations.keys.toSeq.sorted
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
}

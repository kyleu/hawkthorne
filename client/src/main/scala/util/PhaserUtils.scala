package util

import com.definitelyscala.phaserce.{Game, Group, IGameConfig, Math, Phaser, Signal, Sprite}
import org.scalajs.dom.ext.Color

import scala.scalajs.js

object PhaserUtils {
  def makeBackdrop(game: Game, width: Double = 1, height: Double = 1, color: String = "#000000") = {
    val bgData = game.make.bitmapData(1, 1)
    val c = Color(color)
    bgData.fill(c.r.toDouble, c.g.toDouble, c.b.toDouble)
    val s = new Sprite(game, 0, 0, bgData)
    s.name = "backdrop"
    s.width = width
    s.height = height
    s
  }

  def addToSignal(signal: Signal, x: Any => Unit) = signal.add(x, 0, 1.0)

  def expose(x: js.Any) = {
    js.Dynamic.global.obj = x
  }

  def getConfig(isWebGL: Boolean) = JavaScriptUtils.as[IGameConfig](scalajs.js.Dynamic.literal(
    width = "100%",
    height = "100%",
    renderer = if (isWebGL) { Phaser.AUTO } else { Phaser.CANVAS },
    enableDebug = true,
    clearBeforeRender = true,
    antialias = false,
    multiTexture = true,
    parent = "hawkthorne",
    resolution = 1 // Not org.scalajs.dom.window.devicePixelRatio
  ))

  def simpleResize(group: Group, width: Int, height: Int, dimensions: (Int, Int)) = {
    val wRatio = width.toDouble / dimensions._1
    val hRatio = height.toDouble / dimensions._2
    val scale = Math.min(wRatio, hRatio)
    val x = (width - (dimensions._1 * scale)) / 2
    val y = (height - (dimensions._2 * scale)) / 2
    group.position.set(Math.max(x, 0), Math.max(y, 0))
    group.scale.set(scale, scale)
  }
}

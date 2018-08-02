package models.component

import com.definitelyscala.phaserce.Game

import scala.scalajs.js.annotation.JSExport

object BaseComponent {
  trait Resizable {
    def resize(width: Int, height: Int): Unit
  }
}

trait BaseComponent {
  def game: Game
  def name: String

  @JSExport
  def x: Double
  @JSExport
  def x_=(newX: Double): Unit

  @JSExport
  def y: Double
  @JSExport
  def y_=(newY: Double): Unit

  def update(deltaMs: Double): Unit = ()

  @JSExport
  def visible: Boolean
  @JSExport
  def visible_=(b: Boolean): Unit

  def setPositionInt(newX: Int, newY: Int, visible: Option[Boolean] = None) = setPosition(newX.toDouble, newY.toDouble, visible)
  def setPosition(newX: Double, newY: Double, vis: Option[Boolean] = None) = {
    x = newX
    y = newY
    vis.foreach(visible = _)
  }
}

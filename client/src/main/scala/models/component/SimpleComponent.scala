package models.component

import com.definitelyscala.phasercepixi.DisplayObjectContainer

abstract class SimpleComponent() extends BaseComponent {
  def comp: DisplayObjectContainer

  override def x: Double = comp.x
  override def x_=(newX: Double): Unit = comp.x = newX
  override def y: Double = comp.y
  override def y_=(newY: Double): Unit = comp.y = newY

  override def visible = comp.visible
  override def visible_=(v: Boolean) = comp.visible = v
}

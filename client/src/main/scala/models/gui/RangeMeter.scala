package models.gui

import com.definitelyscala.phaserce.{Game, Group, Image}
import models.component.SimpleComponent

class RangeMeter(
    override val game: Game, parent: Group, override val name: String, initialX: Int, initialY: Int, min: Int = 0, max: Int = 10, onChange: Int => Unit
) extends SimpleComponent {
  val group = new Group(game, parent, name)
  group.name = s"meter.$name"
  group.x = initialX.toDouble
  group.y = initialY.toDouble

  override def comp = group

  private[this] val bgImage = new Image(game = game, x = 3, y = 2, key = s"options.meter.bg")
  bgImage.name = "meter.bg"
  bgImage.tint = 0x000000
  group.add(bgImage)

  private[this] val arrowImage = new Image(game = game, x = 0, y = 9, key = s"options.meter.arrow")
  arrowImage.name = "meter.arrow"
  arrowImage.tint = 0x000000
  group.add(arrowImage)

  private[this] var _setting = 0
  def setting = _setting
  def setting_=(s: Int) = if (_setting != s) {
    if (s < min || s > max) {
      throw new IllegalStateException(s"Provided setting [$s] is not in range [$min-$max].")
    }
    _setting = s
    arrowImage.x = (((bgImage.width - 1) / (max - min)) + min) * s
    onChange(s)
  }

  def increment() = setting match {
    case x if x == max => setting = min
    case _ => setting = setting + 1
  }

  def decrement() = setting match {
    case x if x == min => setting = max
    case _ => setting = setting - 1
  }

  override def destroy() = group.destroy(destroyChildren = true)
}

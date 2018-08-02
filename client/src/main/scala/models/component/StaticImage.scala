package models.component

import com.definitelyscala.phaserce.{Game, Group, Image}
import com.definitelyscala.phasercepixi.Texture

final case class StaticImage(
    override val game: Game,
    group: Group,
    override val name: String,
    tex: Texture
) extends BaseComponent {
  val image = new Image(game = game, x = 0, y = 0, key = tex)
  image.name = name
  group.add(image)

  override def x: Double = image.x
  override def x_=(newX: Double): Unit = image.x = newX
  override def y: Double = image.y
  override def y_=(newY: Double): Unit = image.y = newY

  override def visible = image.visible
  override def visible_=(v: Boolean) = image.visible = v
}

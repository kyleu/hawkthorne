package models.component

import com.definitelyscala.phaserce.{Game, Group, Image}
import com.definitelyscala.phasercepixi.Texture

case class StaticImage(
    override val game: Game,
    group: Group,
    override val name: String,
    override val x: Int,
    override val y: Int,
    tex: Texture
) extends BaseComponent {
  val image = new Image(game = game, x = x.toDouble, y = y.toDouble, key = tex)
  image.name = name
  group.add(image)
}

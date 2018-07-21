package models.component

import com.definitelyscala.phaserce.{Game, Group, Image}
import com.definitelyscala.phasercepixi.Texture

case class StaticImage(game: Game, group: Group, override val name: String, x: Int, y: Int, tex: Texture) extends BaseComponent {
  val image = new Image(game = game, x = x.toDouble, y = y.toDouble, key = tex)
  image.name = name
  group.add(image)
}

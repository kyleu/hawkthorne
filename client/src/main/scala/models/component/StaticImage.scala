package models.component

import com.definitelyscala.phaserce.{Game, Group, Image}
import com.definitelyscala.phasercepixi.Texture

final case class StaticImage(
    override val game: Game,
    group: Group,
    override val name: String,
    tex: Texture
) extends SimpleComponent {
  val image = new Image(game = game, x = 0, y = 0, key = tex)
  override def comp = image
  image.name = name
  group.add(image)
}

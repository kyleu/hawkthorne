package models.component

import com.definitelyscala.phaserce.{Game, Group, Sprite}

final case class StaticSprite(
    override val game: Game,
    group: Group,
    override val name: String,
    key: String,
    frame: Int = 0,
    flip: Boolean = false
) extends SimpleComponent {
  val sprite = new Sprite(game = game, x = 0, y = 0, key = key, frame = frame)
  override def comp = sprite
  sprite.name = name
  if (flip) {
    // TODO Reverse texture
    //sprite.scale.x = -1
    //sprite.x += sprite.width
  }
  group.add(sprite)
}

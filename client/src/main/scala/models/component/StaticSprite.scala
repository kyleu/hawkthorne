package models.component

import com.definitelyscala.phaserce.{Game, Group, Sprite}

final case class StaticSprite(
    override val game: Game,
    group: Group,
    override val name: String,
    override val x: Int,
    override val y: Int,
    key: String,
    frame: Int = 0,
    visible: Boolean = true,
    flip: Boolean = false,
) extends BaseComponent {
  val sprite = new Sprite(game = game, x = x.toDouble, y = y.toDouble, key = key, frame = frame)
  sprite.name = name
  sprite.visible = visible
  if (flip) {
    sprite.scale.x = -1
    sprite.x += sprite.width
  }
  group.add(sprite)
}

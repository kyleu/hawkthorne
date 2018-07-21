package models.component

import com.definitelyscala.phaserce.{Game, Group, Sprite}

case class StaticSprite(game: Game, group: Group, override val name: String, x: Int, y: Int, key: String, frame: Int = 0) extends BaseComponent {
  val sprite = new Sprite(game = game, x = x.toDouble, y = y.toDouble, key = key, frame = frame)
  sprite.name = name
  group.add(sprite)
}

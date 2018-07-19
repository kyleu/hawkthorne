package models.component

import com.definitelyscala.phaserce.{Game, Group, Sprite}

class StaticSprite(game: Game, group: Group, x: Double, y: Double, key: String, frame: Int) extends BaseComponent {
  val sprite = new Sprite(game = game, x, y, key, frame)
  group.add(sprite)
}

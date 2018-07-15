package models.component

import com.definitelyscala.phaserce.{Game, Sprite}

class StaticSprite(game: Game, x: Double, y: Double, key: String, frame: Int) extends BaseComponent {
  val sprite = new Sprite(game = game, x, y, key, frame)
}

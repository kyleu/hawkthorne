package models.component

import com.definitelyscala.phaserce.{Game, Group, Sprite}
import services.map.MapService

case class StaticSprite(game: Game, group: Group, override val name: String, x: Int, y: Int, key: String, frame: Int = 0) extends BaseComponent {
  val sprite = new Sprite(game = game, x = x.toDouble, y = y.toDouble, key = key, frame = frame)
  sprite.name = name
  sprite.scale = MapService.scalePoint
  group.add(sprite)
}

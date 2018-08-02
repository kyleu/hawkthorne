package models.component

import com.definitelyscala.phaserce.{Game, Group, Sprite}

final case class StaticSprite(
    override val game: Game,
    group: Group,
    override val name: String,
    key: String,
    frame: Int = 0,
    flip: Boolean = false
) extends BaseComponent {
  val sprite = new Sprite(game = game, x = 0, y = 0, key = key, frame = frame)
  sprite.name = name
  if (flip) {
    // TODO Reverse texture
    //sprite.scale.x = -1
    //sprite.x += sprite.width
  }
  group.add(sprite)

  override def x: Double = sprite.x
  override def x_=(newX: Double): Unit = sprite.x = newX
  override def y: Double = sprite.y
  override def y_=(newY: Double): Unit = sprite.y = newY

  override def visible = sprite.visible
  override def visible_=(v: Boolean) = sprite.visible = v
}

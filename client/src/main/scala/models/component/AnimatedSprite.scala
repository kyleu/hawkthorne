package models.component

import com.definitelyscala.phaserce.{Game, Group, Sprite}
import models.animation.Animation

case class AnimatedSprite(
    override val game: Game,
    group: Group,
    override val name: String,
    override val x: Int,
    override val y: Int,
    key: String,
    animations: Map[String, Animation],
    defAnim: Option[String] = None,
    flip: Boolean = false
) extends BaseComponent {
  private[this] var activeAnimation = defAnim.map(animations.apply)

  val sprite = new Sprite(game, x.toDouble, y.toDouble, key)
  sprite.name = if (name.isEmpty) { key.substring(key.lastIndexOf('.') + 1) } else { name }
  if (flip) {
    sprite.x += sprite.width
    sprite.scale.x = -1
  }
  group.add(sprite)

  def setAnimation(key: Option[String]) = activeAnimation = key.map { k =>
    val a = animations.getOrElse(k, throw new IllegalStateException(s"No animation [$k] among [${animations.keys.toSeq.sorted.mkString(", ")}]."))
    sprite.frame = a.firstFrame
    a
  }

  override def update(deltaMs: Double) = activeAnimation.foreach(_.nextFrame(deltaMs).foreach { f =>
    sprite.frame = f
  })
}

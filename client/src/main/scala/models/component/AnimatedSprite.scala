package models.component

import com.definitelyscala.phaserce.{Game, Group, Sprite}
import models.animation.Animation

object AnimatedSprite {
  def single(game: Game, group: Group, name: String, key: String, animation: Animation, flip: Boolean = false) = {
    AnimatedSprite(game, group, name, key, Map(animation.id -> animation), Some(animation.id))
  }
}

final case class AnimatedSprite(
    override val game: Game,
    group: Group,
    override val name: String,
    key: String,
    animations: Map[String, Animation],
    defAnim: Option[String] = None,
    flip: Boolean = false
) extends SimpleComponent {
  private[this] var activeAnimation = defAnim.map(animations.apply)

  val sprite = new Sprite(game, 0, 0, key)
  override def comp = sprite

  sprite.name = if (name.isEmpty) { key.substring(key.lastIndexOf('.') + 1) } else { name }
  if (flip) {
    // TODO reverse texture
    // sprite.x += sprite.width
    // sprite.scale.x = -1
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

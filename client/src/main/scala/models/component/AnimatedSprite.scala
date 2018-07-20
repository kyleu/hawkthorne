package models.component

import com.definitelyscala.phaserce.{Game, Group, Sprite}
import models.animation.Animation
import services.map.MapService

case class AnimatedSprite(
    game: Game, group: Group, override val name: String, x: Int, y: Int, key: String, animations: Map[String, Animation]
) extends BaseComponent {
  private[this] var activeAnimation: Option[Animation] = None

  val sprite = new Sprite(game, x.toDouble, y.toDouble, key)
  sprite.name = name
  sprite.scale = MapService.scalePoint
  group.add(sprite)

  def setAnimation(key: Option[String]) = activeAnimation = key.map { k =>
    val a = animations.getOrElse(k, throw new IllegalStateException(s"No animation [$k] among [${animations.keys.toSeq.sorted.mkString(", ")}]."))
    sprite.frame = a.firstFrame
    a
  }

  override def update(deltaMs: Double) = {
    activeAnimation.foreach(_.nextFrame(deltaMs).foreach { f =>
      sprite.frame = f
    })
  }
}

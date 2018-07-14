package models.phaser

import com.definitelyscala.phaserce.{Game, Group, Sprite}
import models.animation.Animation

case class AnimatedSprite(game: Game, group: Group, offsetX: Int, offsetY: Int, key: String, animations: Map[String, Animation]) {
  private[this] var activeAnimation: Option[Animation] = None

  val sprite = new Sprite(game, offsetX.toDouble, offsetY.toDouble, key)
  group.add(sprite)

  def setAnimation(key: Option[String]) = activeAnimation = key.map { k =>
    val a = animations.getOrElse(k, throw new IllegalStateException(s"No animation [$k] among [${animations.keys.toSeq.sorted.mkString(", ")}]."))
    sprite.frame = a.firstFrame
    a
  }

  def update(deltaMs: Double) = {
    activeAnimation.foreach(_.nextFrame(deltaMs).foreach(f => sprite.frame = f))
  }
}

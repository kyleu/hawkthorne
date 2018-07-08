package models.phaser

import com.definitelyscala.phaserce.Game
import models.animation.Animation

case class AnimatedSprite(game: Game, offsetX: Int, offsetY: Int, key: String, animations: Animation*) {
  private[this] var activeAnimation = animations.headOption.getOrElse(throw new IllegalStateException("Please provide at least one animation."))

  val sprite = game.add.sprite(offsetX.toDouble, offsetY.toDouble, key)

  def update(deltaMs: Double) = {
    activeAnimation.nextFrame(deltaMs).foreach(f => sprite.frame = f)
  }
}

package services.input

import models.player.PlayerSprite

class InputHandler(player: PlayerSprite) {
  private[this] var lastVelocity = 0.0 -> 0.0

  def process(elapsed: Double, velocity: (Double, Double), events: Seq[String]) = {
    updateAnimation(velocity)
    updateLocation(elapsed, velocity)
    lastVelocity = velocity
  }

  private[this] def updateAnimation(velocity: (Double, Double)) = {
    lastVelocity._1 match {
      case x if x <= 0.0 && velocity._1 > 0.0 => player.setFaceRight(true)
      case x if x <= 0.0 && velocity._1 < 0.0 => player.setFaceRight(false)
      case _ => // noop
    }
  }

  private[this] def updateLocation(elapsed: Double, velocity: (Double, Double)) = {
    val speed = 250

    val xDelta = velocity._1 * elapsed * speed
    val yDelta = velocity._2 * elapsed * speed

    player.sprite.x = player.sprite.x + xDelta
    player.sprite.y = player.sprite.y + yDelta
  }
}

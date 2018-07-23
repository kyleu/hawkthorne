package services.input

import models.player.PlayerSprite

class PlayerInputHandler(player: PlayerSprite) {
  private[this] var lastVelocity = 0.0 -> 0.0

  def process(delta: Double, velocity: (Double, Double), events: Seq[String]) = {
    events.foreach(e => util.Logging.info("Event: " + e))

    val anim = findAnimation(velocity)
    anim.foreach(x => player.as.setAnimation(Some(x)))

    val loc = updateLocation(delta, velocity)
    loc.foreach { l =>
      player.as.sprite.x = l._1
      player.as.sprite.y = l._2
    }

    lastVelocity = velocity
  }

  private[this] def findAnimation(velocity: (Double, Double)) = {
    lastVelocity._1 match {
      case x if x <= 0.0 && velocity._1 > 0.0 => Some("idle.right")
      case x if x <= 0.0 && velocity._1 < 0.0 => Some("idle.left")
      case _ => None
    }
  }

  private[this] def updateLocation(delta: Double, velocity: (Double, Double)) = {
    val speed = 200

    val xVel = Math.min(velocity._1, 1.0)
    val yVel = Math.min(velocity._2, 1.0)

    val xDelta = xVel * delta * speed
    val yDelta = yVel * delta * speed

    Some((player.as.sprite.x + xDelta) -> (player.as.sprite.y + yDelta))
  }
}

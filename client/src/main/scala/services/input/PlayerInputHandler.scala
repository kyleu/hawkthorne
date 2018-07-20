package services.input

import models.player.PlayerSprite

class PlayerInputHandler(player: PlayerSprite) {
  private[this] var lastVelocity = 0.0 -> 0.0

  def process(elapsed: Double, velocity: (Double, Double), events: Seq[String]) = {
    events.foreach(e => util.Logging.info("Event: " + e))

    val anim = findAnimation(velocity)
    anim.foreach(x => player.setAnimation(Some(x)))

    val loc = updateLocation(elapsed, velocity)
    loc.foreach { l =>
      player.sprite.x = l._1
      player.sprite.y = l._2
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

  private[this] def updateLocation(elapsed: Double, velocity: (Double, Double)) = {
    val speed = 1000

    val xDelta = velocity._1 * elapsed * speed
    val yDelta = velocity._2 * elapsed * speed

    Some((player.sprite.x + xDelta) -> (player.sprite.y + yDelta))
  }
}

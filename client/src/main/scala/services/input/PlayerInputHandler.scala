package services.input

import models.player.PlayerSprite

class PlayerInputHandler(player: PlayerSprite) {
  private[this] var lastVelocity = 0.0 -> 0.0

  def process(delta: Double, velocity: (Double, Double), events: Seq[String]) = {
    events.foreach(e => util.Logging.info("Event: " + e))

    val anim = findAnimation(velocity)
    anim.foreach(x => player.setAnimation(Some(x)))

    val loc = updateLocation(delta, velocity)
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

  private[this] def updateLocation(delta: Double, velocity: (Double, Double)) = {
    val speed = 200

    val xDelta = velocity._1 * delta * speed
    val yDelta = velocity._2 * delta * speed

    Some((player.sprite.x + xDelta) -> (player.sprite.y + yDelta))
  }
}

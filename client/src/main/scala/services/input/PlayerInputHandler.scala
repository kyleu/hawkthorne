package services.input

import models.component.PlayerSprite
import models.game.GameUpdate

class PlayerInputHandler(player: PlayerSprite) {
  private[this] var lastInput = GameUpdate.PlayerInput(0, 0, 0, Nil)

  def process(delta: Double, input: GameUpdate.PlayerInput) = {
    input.commands.foreach(c => util.Logging.info("Command: " + c))

    val anim = findAnimation(input)
    anim.foreach(x => player.as.setAnimation(Some(x)))

    val loc = updateLocation(delta, input)
    loc.foreach { l =>
      player.x = l._1
      player.y = l._2
    }

    lastInput = input
  }

  private[this] def findAnimation(input: GameUpdate.PlayerInput) = {
    lastInput.x match {
      case x if x <= 0.0 && input.x > 0.0 => Some("idle.right")
      case x if x >= 0.0 && input.x < 0.0 => Some("idle.left")
      case _ => None
    }
  }

  private[this] def updateLocation(delta: Double, input: GameUpdate.PlayerInput) = {
    val speed = 200

    val xVel = Math.min(input.x, 1.0)
    val yVel = Math.min(input.y, 1.0)

    val xDelta = xVel * delta * speed
    val yDelta = yVel * delta * speed

    Some((player.x + xDelta) -> (player.y + yDelta))
  }
}

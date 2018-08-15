package models.input

import models.game.GameCommand

class PlayerInputHandler(maxX: Int, maxY: Int, log: String => Unit) {
  private[this] var lastInput = GameCommand.PlayerInput(0, 0, 0, Nil)

  private[this] val charPadding = 24.0
  private[this] val (maxXPadded, maxYPadded) = (maxX - charPadding, maxY - charPadding)

  def process(delta: Double, currentX: Double, currentY: Double, input: GameCommand.PlayerInput) = {
    input.commands.foreach(c => log(s"Unhandled Player Command: [$c]"))
    val anim = findAnimation(input)
    val loc = updateLocation(delta, currentX, currentY, input)
    lastInput = input
    anim -> loc
  }

  private[this] def findAnimation(input: GameCommand.PlayerInput) = {
    lastInput.x match {
      case x if x <= 0.0 && input.x > 0.0 => Some("idle.right")
      case x if x >= 0.0 && input.x < 0.0 => Some("idle.left")
      case _ => None
    }
  }

  private[this] def updateLocation(delta: Double, currentX: Double, currentY: Double, input: GameCommand.PlayerInput) = {
    val speed = 200

    val xVel = Math.min(input.x, 1.0)
    val yVel = Math.min(input.y, 1.0)

    val xDelta = xVel * delta * speed
    val yDelta = yVel * delta * speed

    val newX = Math.max(charPadding, Math.min(maxXPadded, currentX + xDelta))
    val newY = Math.max(charPadding, Math.min(maxYPadded, currentY + yDelta))

    if (newX == currentX && newY == currentY) {
      None
    } else {
      Some(newX -> newY)
    }
  }
}

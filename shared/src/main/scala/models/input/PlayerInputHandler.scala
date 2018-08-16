package models.input

import models.game.GameCommand

class PlayerInputHandler(maxX: Int, maxY: Int, orthogonal: Boolean, log: String => Unit) {
  private[this] var facingRight = true
  private[this] var lastAnimation = "initial"
  private[this] var lastInput = GameCommand.PlayerInput(0, 0, 0, Nil)

  private[this] val charPadding = 24.0
  private[this] val (maxXPadded, maxYPadded) = (maxX - charPadding, maxY - charPadding)

  def processCommand(c: InputCommand) = c match {
    case InputCommand.Confirm => log("Confirmed!")
    case _ => log(s"Unhandled Player Command: [$c]")
  }
  def process(delta: Double, currentX: Double, currentY: Double, input: GameCommand.PlayerInput) = {
    input.commands.foreach(processCommand)
    val anim = findAnimation(input)
    val loc = updateLocation(delta, currentX, currentY, input)
    lastInput = input
    anim -> loc
  }

  def anim(key: String) = if (facingRight) { s"$key.right" } else { s"$key.left" }

  private[this] def findAnimation(input: GameCommand.PlayerInput) = {
    lastInput.x match {
      case x if x <= 0.0 && input.x > 0.0 => facingRight = true
      case x if x >= 0.0 && input.x < 0.0 => facingRight = false
      case _ => // noop
    }
    val an = if (input.x == 0) {
      anim("idle")
    } else {
      anim("walk")
    }
    if (an == lastAnimation) {
      None
    } else {
      lastAnimation = an
      Some(an)
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

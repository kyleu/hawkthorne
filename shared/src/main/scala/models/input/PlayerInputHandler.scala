package models.input

import models.game.GameCommand
import services.game.GameInstance
import util.BoundingBox

class PlayerInputHandler(instance: GameInstance, boundingBox: BoundingBox, initialX: Int, initialY: Int, log: String => Unit) {
  private[this] var (currentX, currentY) = initialX.toDouble -> initialY.toDouble
  private[this] var facingRight = true
  private[this] var isDucking = false
  private[this] var lastAnimation = "initial"
  private[this] var lastInput = GameCommand.PlayerInput(0, 0, 0, Nil)

  private[this] val charPadding = 24.0
  private[this] val (maxXPadded, maxYPadded) = (instance.bounds._1 - charPadding, instance.bounds._2 - charPadding)

  def process(delta: Double, input: GameCommand.PlayerInput) = {
    input.commands.foreach(cmd => processCommand(cmd, delta, currentX, currentY))
    lastInput = input
    findAnimation(input) -> updateLocation(delta, input)
  }

  def x = currentX
  def y = currentY
  def getPosition = x -> y
  def setPosition(newX: Double, newY: Double) = {
    currentX = newX
    currentY = newY
  }

  private[this] def anim(key: String) = if (facingRight) { s"$key.right" } else { s"$key.left" }

  private[this] def processCommand(c: InputCommand, delta: Double, currentX: Double, currentY: Double) = c match {
    case InputCommand.Confirm => instance.stage.collidingObjects(currentX, currentY).foreach(collided => log("Collided: " + collided))
    case _ => log(s"Unhandled Player Command: [$c]")
  }

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

  private[this] def updateLocation(delta: Double, input: GameCommand.PlayerInput) = {
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
      currentX = newX
      currentY = newY
      Some(newX -> newY)
    }
  }
}

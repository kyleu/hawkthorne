package models.input

import models.game.GameCommand
import services.game.GameInstance
import util.BoundingBox

class PlayerInputHandler(instance: GameInstance, boundingBox: BoundingBox, initialX: Int, initialY: Int, log: String => Unit) {
  private[this] val (maxX, maxY) = instance.bounds._1.toDouble -> instance.bounds._2.toDouble

  private[this] var (currentX, currentY) = (initialX.toDouble, initialY.toDouble)
  private[this] var (facingRight, isJumping, isDucking) = (true, false, false)

  private[this] var lastAnimation = "initial"
  private[this] var lastInput = GameCommand.PlayerInput(0, 0, 0, Nil)

  def process(delta: Double, input: GameCommand.PlayerInput) = {
    val loc = updateLocation(delta, input)
    input.commands.foreach(cmd => processCommand(cmd, delta, currentX, currentY))
    val an = findAnimation(input)
    lastInput = input
    an -> loc
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
    case InputCommand.Confirm =>
      val rect = boundingBox.at(currentX - 24, currentY - 24, isDucking)
      val collisions = instance.stage.collidingObjects(rect)
      // log(s"Found [${collisions.size}] collisions for [$rect]")
      collisions.foreach(collided => log("Collided: " + collided))
    case _ => log(s"Unhandled Player Command: [$c]")
  }

  private[this] def findAnimation(input: GameCommand.PlayerInput) = {
    facingRight = lastInput.x match {
      case x if x <= 0.0 && input.x > 0.0 => true
      case x if x >= 0.0 && input.x < 0.0 => false
      case _ => facingRight
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

    val newX = Math.max(0, Math.min(maxX, currentX + xDelta))
    val newY = Math.max(0, Math.min(maxY, currentY + yDelta))

    if (newX == currentX && newY == currentY) {
      None
    } else {
      val finalX = newX
      val finalY = newY

      currentX = finalX
      currentY = finalY
      Some(finalX -> finalY)
    }
  }
}

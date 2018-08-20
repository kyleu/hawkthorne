package models.input

import models.game.{GameCommand, GameMessage}
import services.collision.CollisionService
import services.game.GameInstance
import util.BoundingBox

class PlayerInputHandler(instance: GameInstance, playerIdx: Int, boundingBox: BoundingBox, initialX: Int, initialY: Int, log: String => Unit) {
  private[this] val collision = CollisionService(instance.options.map, instance.stage.getCollision)

  private[this] var current = (initialX.toDouble, initialY.toDouble)
  private[this] var (facingRight, isJumping, isDucking) = (true, false, false)

  private[this] var lastAnimation = "initial"
  private[this] var lastInput = GameCommand.PlayerInput(0, 0, 0, Nil)

  def process(delta: Double, input: GameCommand.PlayerInput) = {
    val cmdMessages = input.commands.flatMap(cmd => processCommand(cmd, delta))
    val loc = updateLocation(delta, input)

    val an = findAnimation(input)
    lastInput = input

    val aMsg = an.map(a => GameMessage.PlayerAnimationUpdated(playerIdx, a)).toSeq
    val lMsg = loc.map { case (newX, newY) => GameMessage.PlayerLocationUpdated(playerIdx, newX, newY) }.toSeq
    aMsg ++ lMsg ++ cmdMessages
  }

  def x = current._1
  def y = current._2
  def getPosition = x -> y
  def setPosition(newX: Double, newY: Double) = current = newX -> newY
  def bounds = boundingBox.at(current._1, current._2, isDucking)

  private[this] def anim(key: String) = if (facingRight) { s"$key.right" } else { s"$key.left" }

  private[this] def processCommand(c: InputCommand, delta: Double) = c match {
    case InputCommand.Confirm => instance.stage.collidingObjects(bounds).flatMap(_.onSelect(playerIdx))
    case _ =>
      log(s"Unhandled Player Command: [$c]")
      Nil
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

    val (newX, newY) = collision.move(current, bounds, xDelta -> yDelta)

    if (newX == current._1 && newY == current._2) {
      None
    } else {
      current = newX -> newY
      Some(current)
    }
  }
}

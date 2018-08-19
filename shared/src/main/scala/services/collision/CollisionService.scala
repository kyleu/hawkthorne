package services.collision

import models.collision.{CollisionGrid, CollisionPoly}

case class CollisionService(max: (Double, Double), collision: Either[CollisionPoly, CollisionGrid]) {
  def move(current: (Double, Double), delta: (Double, Double)) = {
    val (newX, newY) = (moveX(current._1, delta._1), moveY(current._2, delta._2))
    newX -> newY
  }

  private[this] def moveX(currentX: Double, deltaX: Double) = if (deltaX == 0) {
    currentX
  } else {
    Math.max(0, Math.min(max._1, currentX + deltaX))
  }

  private[this] def moveY(currentY: Double, deltaY: Double) = if (deltaY == 0) {
    currentY
  } else {
    Math.max(0, Math.min(max._2, currentY + deltaY))
  }
}

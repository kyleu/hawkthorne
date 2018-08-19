package services.collision

import models.collision.CollisionPoly
import util.Rectangle

class PolygonMovement(max: (Double, Double), poly: CollisionPoly) extends MovementHelper {
  override def moveX(current: (Double, Double), bounds: Rectangle, deltaX: Double) = Math.max(0, Math.min(max._1, current._1 + deltaX))
  override def moveY(current: (Double, Double), bounds: Rectangle, deltaY: Double) = Math.max(0, Math.min(max._2, current._2 + deltaY))
}

package services.collision

import models.collision.CollisionGrid
import util.Rectangle

class GridMovement(max: (Double, Double), grid: CollisionGrid) extends MovementHelper {
  override def moveX(current: (Double, Double), bounds: Rectangle, deltaX: Double) = {
    val newX = Math.max(0, Math.min(max._1, current._1 + deltaX))

    val newTile = tileAt(newX, current._2)

    grid.forCoords(newTile) match {
      case Some(t) => t.special match {
        case Some(special) => current._1
        case None => current._1
      }
      case None => newX
    }
  }

  override def moveY(current: (Double, Double), bounds: Rectangle, deltaY: Double) = {
    val newY = Math.max(0, Math.min(max._2, current._2 + deltaY))
    val newTile = tileAt(current._1, newY)

    grid.forCoords(newTile) match {
      case Some(t) => t.special match {
        case Some(special) => current._2
        case None => current._2
      }
      case None => newY
    }
  }
}

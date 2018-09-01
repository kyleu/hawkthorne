package services.collision

import models.collision.CollisionGrid
import models.options.SystemOptions
import util.Rectangle

class GridMovement(max: (Double, Double), grid: CollisionGrid) extends MovementHelper {
  override def moveX(current: (Double, Double), bounds: Rectangle, deltaX: Double) = {
    val newX = Math.max(0, Math.min(max._1, current._1 + deltaX))

    val newTile = tileAt(newX, current._2)

    grid.forCoords(newTile) match {
      case Some(t) => t.special match {
        case Some(special) =>
          val tileY = newTile._2 * SystemOptions.tileSize
          val outside = bounds.y - tileY <= special._2 || bounds.y - tileY > special._4 + 1
          println(s"SpecialX: $special ($outside), LogicX: ${bounds.y} - $tileY <= ${special._2} || ${bounds.y} - $tileY > ${special._4} + 1")
          if (outside) { newX } else { current._1 }
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
        case Some(special) =>
          val tileX = newTile._1 * SystemOptions.tileSize
          val outside = (bounds.x + bounds.w) - tileX <= special._1 || bounds.x - tileX >= special._3
          println(s"SpecialY: $special ($outside), LogicY: (${bounds.x} + ${bounds.w}) - $tileX <= ${special._1} || ${bounds.x} - $tileX >= ${special._3}")
          if (outside) { newY } else { current._2 }
        case None => current._2
      }
      case None => newY
    }
  }
}

package services.collision

import models.collision.{CollisionGrid, CollisionPoly}
import models.data.map.TiledMap
import models.options.SystemOptions
import util.Rectangle

case class CollisionService(map: TiledMap, collision: Either[CollisionPoly, CollisionGrid]) {
  val max = (map.width.toDouble * SystemOptions.tileSize, map.height.toDouble * SystemOptions.tileSize)

  def move(current: (Double, Double), size: Rectangle, delta: (Double, Double)) = {
    val newX = moveX(current, delta._1)
    val newY = moveY(newX -> current._2, delta._2)
    // TODO...
    newX -> newY
  }

  private[this] def tileAt(currentX: Double, currentY: Double) = {
    val col = math.floor(currentX / SystemOptions.tileSize).toInt
    val row = math.floor(currentY / SystemOptions.tileSize).toInt
    col -> row
  }

  private[this] def moveX(current: (Double, Double), deltaX: Double) = if (deltaX == 0) {
    current._1
  } else {
    val newX = Math.max(0, Math.min(max._1, current._1 + deltaX))
    val currentTile = tileAt(current._1, current._2)
    collision match {
      case Right(grid) =>
        val newTile = tileAt(newX, current._2)
        if (newTile == currentTile) {
          newX
        } else {
          grid.forCoords(newTile) match {
            case Some(collided) => current._1
            case None => newX
          }
        }
      case Left(poly) => newX
    }
  }

  private[this] def moveY(current: (Double, Double), deltaY: Double) = if (deltaY == 0) {
    current._2
  } else {
    val newY = Math.max(0, Math.min(max._2, current._2 + deltaY))
    val currentTile = tileAt(current._1, current._2)
    collision match {
      case Right(grid) =>
        val newTile = tileAt(current._1, newY)
        if (newTile == currentTile) {
          newY
        } else {
          grid.forCoords(newTile) match {
            case Some(collided) => current._2
            case None => newY
          }
        }
      case Left(poly) => newY
    }
  }
}

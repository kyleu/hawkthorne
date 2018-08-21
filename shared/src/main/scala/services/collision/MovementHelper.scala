package services.collision

import models.options.SystemOptions
import util.Rectangle

trait MovementHelper {
  final def move(current: (Double, Double), bounds: Rectangle, delta: (Double, Double)) = {
    val newX = if (delta._1 == 0) { current._1 } else { moveX(current, bounds, delta._1) }
    val newY = if (delta._2 == 0) { current._2 } else { moveY(newX -> current._2, bounds, delta._2) }
    newX -> newY
  }

  def moveX(current: (Double, Double), bounds: Rectangle, deltaX: Double): Double
  def moveY(current: (Double, Double), bounds: Rectangle, deltaY: Double): Double

  protected[this] def tileAt(x: Double, y: Double) = {
    val col = math.floor(x / SystemOptions.tileSize).toInt
    val row = math.floor(y / SystemOptions.tileSize).toInt
    col -> row
  }
}

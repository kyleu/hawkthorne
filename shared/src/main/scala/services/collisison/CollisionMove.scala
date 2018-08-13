package services.collisison

import services.game.GameInstance
import util.Point

object CollisionMove {

  def moveX(game: GameInstance, player: Point, x: Double, y: Double, width: Int, height: Int, dx: Double, dy: Double) = {
    dx
  }

  def moveY(game: GameInstance, player: Point, x: Double, y: Double, width: Int, height: Int, dx: Double, dy: Double) = dy match {
    case 0.0 => 0.0
    case _ =>

      dy
  }

  def move(game: GameInstance, player: Point, x: Double, y: Double, width: Int, height: Int, dx: Double, dy: Double) = {
    val newX = moveX(game, player, x, y, width, height, dx, dy)
    val newY = moveY(game, player, newX, y, width, height, dx, dy)
    newX -> newY
  }
}

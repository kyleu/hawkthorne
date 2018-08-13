package services.collisison

import models.options.SystemOptions
import services.game.GameInstance

object CollisionScan {
  def scanRows(game: GameInstance, x: Double, y: Double, width: Int, height: Int, scanRight: Boolean = true) = {
    var edgeX = x
    val (stop, change) = if (scanRight) { (game.bounds._1, 1) } else { (1, -1) }

    val currentCol = (edgeX / SystemOptions.tileSize).floor.toInt + 1
    val topRow = (y / SystemOptions.tileSize).floor.toInt
    val bottomRow = ((y + height - 1) / SystemOptions.tileSize).floor.toInt
    (currentCol to stop by change).flatMap { i =>
      (topRow to bottomRow).map { j =>
        i + (j * game.bounds._1)
      }
    }
  }

  def scanCols(game: GameInstance, x: Double, y: Double, width: Int, height: Int, scanDown: Boolean = true) = {
    var edgeY = y
    val (stop, change) = if (scanDown) { (game.bounds._2 - 1, 1) } else { (0, -1) }

    val currentRow = (edgeY / SystemOptions.tileSize).floor.toInt
    val leftColumn = (x / SystemOptions.tileSize).floor.toInt + 1
    val rightColumn = ((x + width - 1) / SystemOptions.tileSize).floor.toInt + 1
    (currentRow to stop by change).flatMap { i =>
      (leftColumn to rightColumn).map { j =>
        (i * game.bounds._1) + j
      }
    }
  }
}

package services.camera

import com.definitelyscala.phaserce.{Game, Point}

class PositionHelper(game: Game) {
  private[this] var (lastX, lastY) = 0 -> 0

  def newCameraOffset(dt: Double, zoom: Double, currentX: Double, currentY: Double) = {
    val target = new Point((currentX * zoom) - (game.width / 2), (currentY * zoom) - (game.height / 2)).floor()

    val maxX = 1000000.0 // TODO Arrgh
    val maxY = 1000000.0 // TODO Arrgh

    val clampedX = Math.max(0.0, Math.min(maxX, target.x)).toInt
    val clampedY = Math.max(0.0, Math.min(maxY, target.y)).toInt
    if (clampedX != lastX || clampedY != lastY) {
      util.Logging.info(s"zoom: [$zoom] clamped: [$clampedX, $clampedY] max: [$maxX, $maxY] game: [${game.width}, ${game.height}]")
      lastX = clampedX
      lastY = clampedY
      Some(new Point(-clampedX.toDouble, -clampedY.toDouble))
    } else {
      None
    }
  }
}

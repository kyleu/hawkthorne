package services.camera

import com.definitelyscala.phaserce.{Game, Group, Point}

class GroupCameraService(game: Game, group: Group, todoNotJustSize: Double) {
  private[this] var zoom = 1.0
  private[this] var minZoom = 1.0
  private[this] var maxZoom = 10.0
  private[this] val size = todoNotJustSize -> todoNotJustSize
  private[this] var (currentX, currentY) = (0.0, 0.0)
  private[this] var (lastX, lastY) = 0.0 -> 0.0

  def currentZoom = zoom

  def resize(width: Int, height: Int) = {
    val desiredZ = Math.min(width / size._1, height / size._2)
    val newZ = Math.min(Math.max(desiredZ, minZoom), maxZoom)
    if (newZ != zoom) {
      zoom = newZ
      group.scale.set(zoom, zoom)
      update()
    }
  }

  def focusOn(x: Double, y: Double) = if (currentX != x || currentY != y) {
    currentX = x
    currentY = y
    update()
  }

  private[this] def update() = newCameraOffset().foreach(p => group.position = p)

  private[this] def newCameraOffset() = {
    val target = new Point((currentX * zoom) - (game.width / 2), (currentY * zoom) - (game.height / 2))

    val maxX = 1000000.0 // TODO Arrgh
    val maxY = 1000000.0 // TODO Arrgh

    val clampedX = Math.max(0.0, Math.min(maxX, target.x))
    val clampedY = Math.max(0.0, Math.min(maxY, target.y))
    if (clampedX != lastX || clampedY != lastY) {
      //util.Logging.info(s"zoom: [$zoom] clamped: [$clampedX, $clampedY] max: [$maxX, $maxY] game: [${game.width}, ${game.height}]")
      lastX = clampedX
      lastY = clampedY
      Some(new Point(-clampedX.toDouble, -clampedY.toDouble))
    } else {
      None
    }
  }
}

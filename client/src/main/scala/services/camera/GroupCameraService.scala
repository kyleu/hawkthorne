package services.camera

import com.definitelyscala.phaserce.{Game, Group, Point}

class GroupCameraService(game: Game, group: Group, todoNotJustSize: Double) {
  private[this] val positionHelper = new PositionHelper(game)

  private[this] var zoom = 1.0
  private[this] val size = todoNotJustSize -> todoNotJustSize
  private[this] var (currentX, currentY) = (0.0, 0.0)

  def currentZoom = zoom

  def resize(width: Int, height: Int) = {
    val newZ = Math.min(width / size._1, height / size._2)
    if (newZ != zoom) {
      zoom = newZ
      group.scale = new Point(zoom, zoom)
    }
  }

  def focusOn(x: Double, y: Double) = {
    currentX = x
    currentY = y
  }

  def update(dt: Double) = {
    positionHelper.newCameraOffset(dt, zoom, currentX, currentY).foreach(p => group.position = p)
  }
}

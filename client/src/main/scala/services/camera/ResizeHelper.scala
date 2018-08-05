package services.camera

import com.definitelyscala.phaserce.{Group, Point}

class ResizeHelper(group: Group, todoNotJustSize: Double) {
  private[this] var zoom = 1.0
  private[this] val size = todoNotJustSize

  def currentZoom = zoom

  def resize(width: Int, height: Int) = {
    val newZ = Math.min(width / size, height / size)
    if (newZ != zoom) {
      zoom = newZ
      group.scale = new Point(zoom, zoom)
    }
  }
}

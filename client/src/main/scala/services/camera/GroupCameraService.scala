package services.camera

import com.definitelyscala.phaserce.{Game, Group}

class GroupCameraService(game: Game, group: Group) {
  private[this] val positionHelper = new PositionHelper(game)
  private[this] val resizeHelper = new ResizeHelper(group, 600.0)

  def currentZoom = resizeHelper.currentZoom

  def update(dt: Double, zoom: Double, x: Double, y: Double) = {
    positionHelper.newCameraOffset(dt, zoom, x, y).foreach(p => group.position = p)
  }

  def resize(width: Int, height: Int) = {
    resizeHelper.resize(width, height)
  }
}

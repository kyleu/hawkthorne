package services.game

import com.definitelyscala.phaserce.Camera

class CameraService(camera: Camera) {

  val shittyDefaultScale = 1.0

  private[this] def getScale(width: Int, height: Int) = shittyDefaultScale

  private[this] var currentScale = 1.0
  private[this] var (currentX, currentY) = (0, 0)
  private[this] var (currentStageWidth, currentStageHeight) = (0, 0)
  private[this] var (currentWorldWidth, currentWorldHeight) = (0, 0)

  def resize(stageWidth: Int, stageHeight: Int, worldWidth: Int, worldHeight: Int) = {
    val newScale = getScale(stageWidth, stageHeight)
    if (newScale != currentScale) {
      camera.scale.setTo(newScale, newScale)
      camera.bounds.setTo(0, 0, worldWidth * newScale, worldHeight * newScale)
      currentScale = newScale
    }

    currentStageWidth = stageWidth
    currentStageHeight = stageHeight
    currentWorldWidth = worldWidth
    currentWorldHeight = worldHeight
  }

  def focusOn(x: Int, y: Int) = if (currentX != x || currentY != y) {
    val candidateX = x - ((currentStageWidth / currentScale) / 2)
    val candidateY = y - ((currentStageWidth / currentScale) / 2)

    val newX = Math.min(Math.max(candidateX, 0), Math.max(currentWorldWidth - (currentStageWidth / currentScale), 0.0))
    val newY = Math.min(Math.max(candidateY, 0), Math.max(currentWorldHeight - (currentStageWidth / currentScale), 0.0))

    if (newX != camera.x || newY != camera.y) {
      camera.x = newX
      camera.y = newY
    }

    currentX = x
    currentY = y
    //util.Logging.info(s"Focused camera on [$x/$y] resulting in camera location [${camera.x}/${camera.y}].")
  }
}

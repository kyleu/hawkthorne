package services.game

import com.definitelyscala.phaserce.{Camera, Game}

class CameraService(camera: Camera) {
  private[this] def getScale(width: Int, height: Int) = 2.0
  private[this] var (currentX, currentY) = (0, 0)
  private[this] var (currentStageWidth, currentStageHeight) = (0, 0)
  private[this] var (currentWorldWidth, currentWorldHeight) = (0, 0)

  def resize(stageWidth: Int, stageHeight: Int, worldWidth: Int, worldHeight: Int) = {
    val scale = getScale(stageWidth, stageHeight)
    camera.scale.x = scale
    camera.scale.y = scale

    camera.bounds.width = worldWidth * camera.scale.x
    camera.bounds.height = worldHeight * camera.scale.y

    currentStageWidth = stageWidth
    currentStageHeight = stageHeight
    currentWorldWidth = worldWidth
    currentWorldHeight = worldHeight
  }

  def focusOn(x: Int, y: Int) = if (currentX != x || currentY != y) {
    val candidateX = x - (currentStageWidth / 2)
    val candidateY = y - (currentStageHeight / 2)

    val newX = Math.min(Math.max(candidateX, 0), Math.max(currentWorldWidth - currentStageWidth, 0)).toDouble
    val newY = Math.min(Math.max(candidateY, 0), Math.max(currentWorldHeight - currentStageHeight, 0)).toDouble

    if (newX != camera.x || newY != camera.y) {
      camera.x = newX
      camera.y = newY
    }

    currentX = x
    currentY = y
    //util.Logging.info(s"Focused camera on [$x/$y] resulting in camera location [${camera.x}/${camera.y}].")
  }
}

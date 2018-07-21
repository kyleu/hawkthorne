package services.input

import com.definitelyscala.phaserce.Game

case class PointerInput(game: Game) {
  game.input.mouse.capture = true

  def update(menu: Boolean, delta: Double) = {
    val ptr = game.input.activePointer
    if (ptr.leftButton.isDown) {
      game.camera.x = -ptr.worldX
      game.camera.y = -ptr.worldY
      util.Logging.info(s"Button pressed [World: ${ptr.worldX}/${ptr.worldY}] [Screen: ${ptr.screenX}/${ptr.screenY}] [Camera: ${game.camera.x}/${game.camera.y}]")
    }
  }

  def close() = {}
}

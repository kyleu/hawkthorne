package services.game

import com.definitelyscala.phaserce.Game
import models.component.PlayerSprite
import models.gui.{ConsoleLog, HudOverlay}
import models.player.Player
import services.camera.CameraService
import services.debug.DebugService
import services.map.MapService

class GameplayDisplay(game: Game, mapService: MapService, player: Player, instance: GameInstance) {
  private[this] val playerHeight = 48
  private[this] val playerHalfHeight = playerHeight / 2

  val camera = new CameraService(game, mapService.group, 400, mapService.mapPxWidth -> mapService.mapPxHeight)

  val playerSprite = new PlayerSprite(
    game = game, group = mapService.group, idx = 0, player = player,
    initialLoc = instance.spawn.x -> instance.spawn.y, initialBounds = mapService.mapPxWidth -> mapService.mapPxHeight
  )

  val hudOverlay = HudOverlay(game = game, player = player)

  val console = ConsoleLog(game = game)
  console.log("This is a test of the emergency broadcast system. This is only a test!")

  DebugService.inst.foreach(_.setUI(console, hudOverlay))

  resize(game.width.toInt, game.height.toInt)

  def update(delta: Double) = {
    camera.focusOn(playerSprite.x + playerHalfHeight, playerSprite.y + playerHalfHeight)
    console.update(delta)
  }

  def resize(width: Int, height: Int) = {
    camera.resize(width, height)
    hudOverlay.resize(width, height, camera.currentZoom)
    console.resize(width, height, camera.currentZoom)
  }
}

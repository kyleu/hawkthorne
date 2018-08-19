package services.game

import com.definitelyscala.phaserce.Game
import models.component.PlayerSprite
import models.gui.{ConsoleLog, HudOverlay}
import models.player.Player
import services.camera.CameraService
import services.debug.DebugService
import services.map.MapService

class GameplayDisplay(game: Game, mapService: MapService, player: Player, instance: GameInstance) {
  val camera = new CameraService(
    game = game,
    group = mapService.group,
    parallaxLayers = mapService.parallaxLayers,
    desiredSize = 400 -> 400,
    pxSize = mapService.mapPxWidth -> mapService.mapPxHeight
  )

  val playerSprite = new PlayerSprite(
    game = game, mapGroup = mapService.group, idx = 0, player = player,
    initialLoc = instance.spawn.x -> instance.spawn.y, initialBounds = mapService.mapPxWidth -> mapService.mapPxHeight
  )

  val hudOverlay = HudOverlay(game = game, player = player)

  val console = ConsoleLog(game = game)
  console.log("This is a test of the emergency broadcast system. This is only a test!")

  DebugService.inst.foreach(_.setUI(console, hudOverlay))

  resize(game.width.toInt, game.height.toInt)

  def update(delta: Double) = {
    camera.focusOn(playerSprite.x, playerSprite.y)
    console.update(delta)
  }

  def resize(width: Int, height: Int) = {
    camera.resize(width, height)
    hudOverlay.resize(width, height, camera.currentZoom)
    console.resize(width, height, camera.currentZoom)
  }
}

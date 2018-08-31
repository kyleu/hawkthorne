package services.game

import com.definitelyscala.phaserce.Game
import models.component.PlayerSprite
import models.gui.{ConsoleLog, HudOverlay}
import models.modal.Dialog
import models.player.Player
import services.camera.CameraService
import services.debug.DebugService
import services.input.InputService
import services.map.MapService

class GameplayDisplay(game: Game, inputService: InputService, mapService: MapService, players: IndexedSeq[Player], instance: GameInstance) {
  val camera = new CameraService(
    game = game,
    group = mapService.group,
    parallaxLayers = mapService.parallaxLayers,
    desiredSize = 400 -> 400,
    pxSize = mapService.mapPxWidth -> mapService.mapPxHeight
  )

  val playerSprites = players.map { player =>
    val ret = new PlayerSprite(game = game, mapGroup = mapService.group, player = player, initialBounds = mapService.mapPxWidth -> mapService.mapPxHeight)
    val pos = instance.positionForPlayer(player.idx)
    ret.setPosition(pos._1, pos._2)
    ret
  }

  val hudOverlay = HudOverlay(game = game, players = players)
  val console = ConsoleLog(game = game)
  val dialog = new Dialog(game = game, inputService = inputService)
  DebugService.inst.foreach(_.setUI(console, hudOverlay, dialog))

  resize(game.width.toInt, game.height.toInt)

  def update(delta: Double) = {
    camera.focusOn(playerSprites.map(_.x).sum / playerSprites.size, playerSprites.map(_.y).sum / playerSprites.size)
    console.update(delta)
    dialog.update(delta)
  }

  def resize(width: Int, height: Int) = {
    camera.resize(width, height)
    hudOverlay.resize(width, height, camera.currentZoom)
    console.resize(width, height, camera.currentZoom)
    dialog.resize(width, height, camera.currentZoom)
  }

  def destroy() = {
    hudOverlay.destroy()
    console.destroy()
  }
}

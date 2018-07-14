package services

import com.definitelyscala.phaserce.Game
import models.data.map.TiledMap
import models.phaser.{NodeLoader, SplashComponent}
import models.player.{Player, PlayerSprite}
import services.input.InputService
import services.map.MapService
import services.ui.DebugService

class GameplayService(game: Game, map: TiledMap, player: Player) {
  private[this] var started = false
  private[this] var elapsed = 0.0

  private[this] val mapService = new MapService(game, map, playMusic = false)

  private[this] val playerSprite = new PlayerSprite(game, mapService.group, player, 100, 100)
  private[this] val input = new InputService(game, IndexedSeq(playerSprite))

  private[this] val splashComplete = SplashComponent.show(game)
  private[this] val loader = new NodeLoader(game, mapService.group).load(nodes = mapService.nodes, onComplete = sprites => {
    splashComplete()
    playerSprite.sprite.bringToTop()
    started = true
  })

  DebugService.initGui(playerSprite)
  println("Hawkthore started.")

  def update() = if (started) {
    val dt = game.time.physicsElapsed
    elapsed += dt

    input.update(dt)
    playerSprite.update(dt)
  }
}

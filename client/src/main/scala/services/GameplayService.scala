package services

import com.definitelyscala.phaserce.Game
import models.component.BaseComponent.Resizable
import models.component.{BaseComponent, HudOverlay, SplashComponent}
import models.data.map.TiledMap
import models.phaser.NodeLoader
import models.player.{Player, PlayerSprite}
import services.input.InputService
import services.map.MapService
import services.ui.DebugService

class GameplayService(game: Game, map: TiledMap, player: Player) {
  private[this] var started = false
  private[this] var elapsed = 0.0
  private[this] val components = collection.mutable.ArrayBuffer.empty[BaseComponent]

  private[this] val hudOverlay = HudOverlay(game, player)
  components += hudOverlay

  private[this] val mapService = new MapService(game, map, playMusic = false)
  DebugService.inst.setMap(mapService)

  private[this] val playerSprite = new PlayerSprite(game, mapService.group, player, 100, 100)
  DebugService.inst.addPlayer(playerSprite)
  components += playerSprite

  private[this] val input = new InputService(game, IndexedSeq(playerSprite))

  private[this] val splashComplete = SplashComponent.show(game)
  new NodeLoader(game, mapService.group).load(nodes = mapService.nodes, onComplete = newComponents => {
    components ++= newComponents
    splashComplete()
    playerSprite.sprite.bringToTop()
    started = true
  })

  util.Logging.info("Hawkthore started.")

  def update() = if (started) {
    val dt = game.time.physicsElapsed
    elapsed += dt

    input.update(dt)
    components.foreach(_.update(dt))
  }

  def resize(width: Double, height: Double) = components.collect {
    case r: Resizable => r.resize(width, height)
  }
}

package services.game

import com.definitelyscala.phaserce.Game
import models.component.{BaseComponent, ConsoleLog, HudOverlay, SplashComponent}
import models.game.GameOptions
import models.player.{Player, PlayerSprite}
import services.input.InputService
import services.map.{MapNodeParser, MapService}
import services.node.NodeLoader
import services.ui.DebugService

class GameplayService(game: Game, options: GameOptions, player: Player) {
  private[this] var started = false
  private[this] var elapsed = 0.0
  private[this] val components = collection.mutable.ArrayBuffer.empty[BaseComponent]
  private[this] def addComponent(c: BaseComponent) = components += c

  val nodes = MapNodeParser.parse(game.cache.getTilemapData("map." + options.map.value))

  val instance = GameInstanceFactory.create(
    options = options,
    initialNodes = nodes,
    initialPlayers = Seq(player),
    log = s => util.Logging.info(s),
    notify = s => util.Logging.warn(s)
  )

  private[this] val mapService = new MapService(game = game, map = options.map, playMusic = false)

  private[this] val playerSprite = new PlayerSprite(
    game = game, group = mapService.group, player = player, initialX = instance.spawn.x, initialY = instance.spawn.y, physics = false
  )
  addComponent(playerSprite)

  private[this] val hudOverlay = HudOverlay(game = game, player = player)
  addComponent(hudOverlay)

  private[this] val consoleLog = ConsoleLog(game = game)
  addComponent(consoleLog)

  private[this] val input = new InputService(game, IndexedSeq(playerSprite))

  private[this] val camera = new CameraService(game.camera)
  // private[this] val camera = new GroupCameraService(game, mapService.group)

  private[this] val splashComplete = SplashComponent.show(game)

  new NodeLoader(game, mapService.group).load(nodes = nodes, onComplete = newComponents => {
    newComponents.foreach(addComponent)
    DebugService.inst.foreach(_.setMap(game, mapService, nodes, components, Seq(playerSprite)))
    splashComplete()
    playerSprite.sprite.bringToTop()
    resize(game.width.toInt, game.height.toInt)
    util.Logging.info("Hawkthorne game service started.")
    instance.initialMessages() // TODO
    started = true
  })

  def update() = if (started) {
    val dt = game.time.physicsElapsed
    elapsed += dt

    input.update(menu = false, delta = dt)
    components.foreach(_.update(dt))
    camera.focusOn(playerSprite.sprite.x.toInt, playerSprite.sprite.y.toInt)
  }

  def resize(width: Int, height: Int) = {
    camera.resize(width, height, mapService.mapPxWidth, mapService.mapPxHeight)
    components.collect { case r: BaseComponent.Resizable => r.resize(width, height) }
  }
}

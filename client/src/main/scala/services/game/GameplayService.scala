package services.game

import com.definitelyscala.phaserce.{Camera, Game}
import models.component.BaseComponent.Resizable
import models.component.{BaseComponent, ConsoleLog, HudOverlay, SplashComponent}
import models.game.{GameInstance, GameOptions}
import models.node.DoorNode
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
  val mainDoor = nodes.collect { case n: DoorNode => n }.find(_.name == "main")

  val instance = GameInstance(options, nodes, s => util.Logging.info(s), s => util.Logging.warn(s))

  private[this] val mapService = new MapService(game = game, map = options.map, playMusic = false)

  val (x, y) = mainDoor.map { d =>
    val xr = (d.x * MapService.scaleInt) + (d.width * 2)
    val yr = (d.y * MapService.scaleInt) + (d.height * 2)
    xr -> yr
  }.getOrElse(400 -> 400)
  private[this] val playerSprite = new PlayerSprite(game = game, group = mapService.group, player = player, initialX = x, initialY = y, physics = false)
  addComponent(playerSprite)
  game.camera.follow(target = playerSprite.sprite, style = Camera.FOLLOW_PLATFORMER)

  private[this] val hudOverlay = HudOverlay(game = game, player = player)
  addComponent(hudOverlay)

  private[this] val consoleLog = ConsoleLog(game = game)
  addComponent(consoleLog)

  private[this] val input = new InputService(game, IndexedSeq(playerSprite))

  private[this] val splashComplete = SplashComponent.show(game)

  new NodeLoader(game, mapService.group).load(nodes = nodes, onComplete = newComponents => {
    newComponents.foreach(addComponent)
    DebugService.inst.foreach(_.setMap(mapService, instance.nodes, components, Seq(playerSprite)))
    splashComplete()
    started = true
  })

  util.Logging.info("Hawkthore started.")

  def update() = if (started) {
    val dt = game.time.physicsElapsed
    elapsed += dt

    input.update(menu = false, delta = dt)
    components.foreach(_.update(dt))
  }

  def resize(width: Double, height: Double) = components.collect {
    case r: Resizable => r.resize(width, height)
  }
}

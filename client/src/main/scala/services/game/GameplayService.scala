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
  val (initialX, initialY) = mainDoor.map(d => (d.x + (d.width / 2)) -> (d.y + (d.height / 2))).getOrElse(400 -> 400)

  val instance = GameInstance(options, nodes, s => util.Logging.info(s), s => util.Logging.warn(s))

  private[this] val mapService = new MapService(game = game, map = options.map, playMusic = false)

  private[this] val playerSprite = new PlayerSprite(
    game = game, group = mapService.group, player = player, initialX = initialX, initialY = initialY, physics = false
  )
  addComponent(playerSprite)
  // game.camera.follow(target = playerSprite.sprite, style = Camera.FOLLOW_PLATFORMER)

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
    resize(game.width, game.height)
    started = true
  })

  util.Logging.info("Hawkthore started.")

  def update() = if (started) {
    val dt = game.time.physicsElapsed
    elapsed += dt

    input.update(menu = false, delta = dt)
    components.foreach(_.update(dt))
  }

  private[this] def getScale(width: Double, height: Double) = 1.0

  def resize(width: Double, height: Double) = {
    val scale = getScale(width, height)
    game.camera.scale.x = scale
    game.camera.scale.y = scale

    game.camera.bounds.width = mapService.mapPxWidth * game.camera.scale.x
    game.camera.bounds.height = mapService.mapPxHeight * game.camera.scale.y

    components.collect { case r: Resizable => r.resize(width, height) }
  }
}

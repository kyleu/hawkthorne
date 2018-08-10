package services.game

import com.definitelyscala.phaserce.Game
import io.circe.Json
import models.analytics.AnalyticsActionType
import models.component._
import models.font.Font
import models.gui.{ConsoleLog, HudOverlay}
import models.input.PointerAction
import models.options.GameOptions
import models.player.Player
import services.camera.CameraService
import services.debug.DebugService
import services.input.InputService
import services.map.{MapNodeParser, MapService}
import services.node.NodeLoader
import services.socket.AnalyticsService
import util.Logging
import util.JsonSerializers._

class GameplayService(game: Game, inputService: InputService, options: GameOptions, player: Player) {
  private[this] var started = false
  private[this] var elapsed = 0.0
  private[this] val playerHeight = 48
  private[this] val playerHalfHeight = playerHeight / 2
  private[this] val components = collection.mutable.ArrayBuffer.empty[BaseComponent]
  private[this] def addComponent(c: BaseComponent) = components += c

  AnalyticsService.send(AnalyticsActionType.GameStart, Json.obj("options" -> options.asJson, "players" -> Seq(player).asJson))

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
    game = game, group = mapService.group, idx = 0, player = player,
    initialLoc = instance.spawn.x -> instance.spawn.y, initialBounds = mapService.mapPxWidth -> mapService.mapPxHeight
  )
  addComponent(playerSprite)

  inputService.setPointerEventCallback(Some(pointerAct))
  inputService.addPlayer(playerSprite)

  Font.reset()

  private[this] val hudOverlay = HudOverlay(game = game, player = player)
  addComponent(hudOverlay)

  private[this] val consoleLog = ConsoleLog(game = game)
  addComponent(consoleLog)

  private[this] val camera = new CameraService(game, mapService.group, 400, mapService.mapPxWidth -> mapService.mapPxHeight)

  private[this] val (progress, splashComplete) = SplashScreen.show(game)

  new NodeLoader(game, mapService.group, progress).load(nodes = nodes, onComplete = newComponents => {
    newComponents.foreach(addComponent)
    DebugService.inst.foreach(_.setMap(game, mapService, nodes, components, Seq(playerSprite)))
    playerSprite.as.sprite.bringToTop()
    resize(game.width.toInt, game.height.toInt)
    instance.initialMessages() // TODO

    splashComplete()
    started = true
  })

  def update() = if (started) {
    val dt = game.time.physicsElapsed
    elapsed += dt

    inputService.update(delta = dt)
    components.foreach(_.update(dt))
    camera.focusOn(playerSprite.x + playerHalfHeight, playerSprite.y + playerHalfHeight)
  }

  def resize(width: Int, height: Int) = {
    camera.resize(width, height)
    components.foreach {
      case r: BaseComponent.Resizable => r.resize(width, height)
      case _ => // noop
    }
  }

  private[this] def pointerAct(pa: PointerAction) = {
    val (worldX, worldY) = camera.worldToMap(pa.worldX, pa.worldY)
    nodes.foreach {
      case n if n.x < worldX && n.y < worldY && (n.x + n.width) >= worldX && (n.y + n.height) >= worldY => Logging.info(s"Collision: $n")
      case _ => // noop
    }
  }
}

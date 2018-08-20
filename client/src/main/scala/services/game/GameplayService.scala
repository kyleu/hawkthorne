package services.game

import com.definitelyscala.phaserce.Game
import io.circe.Json
import models.analytics.AnalyticsActionType
import models.component._
import models.options.GameOptions
import models.player.Player
import services.debug.DebugService
import services.input.InputService
import services.map.{MapNodeParser, MapService}
import services.node.NodeLoader
import services.socket.AnalyticsService

class GameplayService(game: Game, inputService: InputService, options: GameOptions, initialPlayers: IndexedSeq[Player]) extends GameplayMessageHandler {
  private[this] var started = false
  private[this] var elapsed = 0.0
  protected[this] var players = initialPlayers
  protected[this] val components = collection.mutable.ArrayBuffer.empty[BaseComponent]
  protected[this] def addComponent(c: BaseComponent) = components += c

  AnalyticsService.send(AnalyticsActionType.GameStart, Json.obj(
    "options" -> util.JsonSerializers.serialize(options),
    "players" -> util.JsonSerializers.serialize(players)
  ))

  val (nodes, collision) = MapNodeParser.parse(options.map.value, game.cache.getTilemapData("map." + options.map.value))

  val instance = GameInstanceFactory.create(
    options = options,
    nodes = nodes,
    initialPlayers = players,
    collision = collision,
    log = s => util.Logging.info(s),
    notify = s => util.Logging.warn(s)
  )
  DebugService.inst.foreach(_.setGameInstance(instance))

  private[this] val mapService = new MapService(game = game, map = options.map, playMusic = false)
  protected[this] val display = new GameplayDisplay(game, mapService, players, instance)
  display.playerSprites.foreach(addComponent)

  inputService.setPointerEventCallback(Some(pointerAct))

  private[this] val (progress, splashComplete) = SplashScreen.show(game)
  new NodeLoader(game, mapService.group, progress).load(nodes = nodes, onComplete = newComponents => {
    newComponents.foreach(addComponent)
    DebugService.inst.foreach(_.setMap(game, mapService, instance, components, display.playerSprites))
    display.playerSprites.foreach(_.bringToTop())
    resize(game.width.toInt, game.height.toInt)
    splashComplete()
    instance.start()
    started = true
  })

  def update() = if (started) {
    val dt = game.time.physicsElapsed
    elapsed += dt

    val gameUpdates = inputService.update(delta = dt)
    val messages = instance.update(delta = dt, gameUpdates: _*)
    instance.apply(messages)
    messages.foreach(applyMessage)
    components.foreach(_.update(dt))
    display.update(dt)
  }

  def resize(width: Int, height: Int) = {
    display.resize(width, height)
    components.foreach {
      case r: BaseComponent.Resizable => r.resize(width, height)
      case _ => // noop
    }
  }
}

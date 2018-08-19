package services.game

import com.definitelyscala.phaserce.Game
import io.circe.Json
import models.analytics.AnalyticsActionType
import models.component._
import models.game.GameMessage
import models.input.PointerAction
import models.options.GameOptions
import models.player.Player
import services.debug.DebugService
import services.input.InputService
import services.map.{MapNodeParser, MapService}
import services.node.NodeLoader
import services.socket.AnalyticsService
import util.Logging

class GameplayService(game: Game, inputService: InputService, options: GameOptions, player: Player) {
  private[this] var started = false
  private[this] var elapsed = 0.0
  private[this] val components = collection.mutable.ArrayBuffer.empty[BaseComponent]
  private[this] def addComponent(c: BaseComponent) = components += c

  AnalyticsService.send(AnalyticsActionType.GameStart, Json.obj(
    "options" -> util.JsonSerializers.serialize(options),
    "players" -> util.JsonSerializers.serialize(Seq(player))
  ))

  val (nodes, collision) = MapNodeParser.parse(options.map.value, game.cache.getTilemapData("map." + options.map.value))

  val instance = GameInstanceFactory.create(
    options = options,
    nodes = nodes,
    initialPlayers = Seq(player),
    collision = collision,
    log = s => util.Logging.info(s),
    notify = s => util.Logging.warn(s)
  )
  DebugService.inst.foreach(_.setGameInstance(instance))

  private[this] val mapService = new MapService(game = game, map = options.map, playMusic = false)
  private[this] val display = new GameplayDisplay(game, mapService, player, instance)
  addComponent(display.playerSprite)

  inputService.setPointerEventCallback(Some(pointerAct))

  private[this] val (progress, splashComplete) = SplashScreen.show(game)
  new NodeLoader(game, mapService.group, progress).load(nodes = nodes, onComplete = newComponents => {
    newComponents.foreach(addComponent)
    DebugService.inst.foreach(_.setMap(game, mapService, instance, components, Seq(display.playerSprite)))
    display.playerSprite.bringToTop()
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

  private[this] def pointerAct(pa: PointerAction) = {
    val (worldX, worldY) = display.camera.worldToMap(pa.worldX, pa.worldY)
    nodes.foreach {
      case n if n.x < worldX && n.y < worldY && (n.x + n.width) >= worldX && (n.y + n.height) >= worldY => Logging.info(s"Collision: $n")
      case _ => // noop
    }
  }

  private[this] def applyMessage(msg: GameMessage) = msg match {
    case pm: GameMessage.PlayerMessage if pm.idx == 0 => pm match {
      case GameMessage.PlayerAnimationUpdated(_, anim) => display.playerSprite.setAnimation(Some(anim))
      case GameMessage.PlayerLocationUpdated(_, x, y) => display.playerSprite.setPosition(newX = x, newY = y)
      case GameMessage.LeaveMap(idx, src, dest) =>
      case x => util.Logging.info(s"Unhandled game player message [$x].")
    }
    case pm: GameMessage.PlayerMessage if pm.idx == -1 => throw new IllegalStateException(s"Received unhandled system player input.")
    case pm: GameMessage.PlayerMessage => throw new IllegalStateException(s"Received input for player [${pm.idx}], but only support single player for now.")
    case n: GameMessage.Notify => n.msgs.foreach(display.console.log)
    case x => util.Logging.info(s"Unhandled game service message [$x].")
  }
}

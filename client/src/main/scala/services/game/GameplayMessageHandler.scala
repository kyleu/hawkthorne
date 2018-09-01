package services.game

import models.data.map.TiledMap
import models.game.msg.GameMessage
import models.input.PointerAction
import models.options.SystemOptions
import services.navigation.NavigationPaths
import services.state.NavigationService
import util.Logging

trait GameplayMessageHandler { this: GameplayService =>
  protected[this] def pointerAct(pa: PointerAction) = if (options.debug) {
    val (worldX, worldY) = display.camera.worldToMap(pa.worldX, pa.worldY)

    val (tileX, tileY) = (worldX / SystemOptions.tileSize, worldY / SystemOptions.tileSize)
    Logging.info(s"Tile [$tileX, $tileY]:")

    mapService.layers.foreach { layer =>
      val tile = layer.getTiles(x = worldX.toDouble, y = worldY.toDouble, width = 1, height = 1).head
      util.Logging.info(s"  [${layer.name}]: [${tile.x}, ${tile.y}]: ${tile.index}")
    }

    val collisions = nodes.collect { case n if n.x < worldX && n.y < worldY && (n.x + n.width) >= worldX && (n.y + n.height) >= worldY => n }
    collisions.foreach(n => Logging.info(s"Node pointer Collision [$worldX / $worldY]: $n"))
  }

  def notifyChannel(n: GameMessage.Notify) = n.channel match {
    case "console" => n.msgs.foreach(display.console.log)
    case "dialog" => display.dialog.show(() => (), n.msgs: _*)
    case x => throw new IllegalStateException(s"Invalid channel [$x]")
  }

  protected[this] def applyMessage(msg: GameMessage) = msg match {
    case pm: GameMessage.PlayerMessage if pm.idx == -1 => throw new IllegalStateException(s"Received unhandled system player input.")
    case pm: GameMessage.PlayerMessage if pm.idx < players.size => pm match {
      case GameMessage.PlayerAnimationUpdated(_, anim) => display.playerSprites(pm.idx).setAnimation(Some(anim))
      case GameMessage.PlayerLocationUpdated(_, x, y) => display.playerSprites(pm.idx).setPosition(newX = x, newY = y)
      case GameMessage.LeaveMap(_, _, dest) =>
        val (tiled, door) = getDestination(dest)
        val newOpts = options.copy(map = tiled, initialSpawn = door)
        val next = NavigationPaths.newGameState(game, inputService, newOpts)
        NavigationService.navigateTo(game, next, path = Some(s"map/${tiled.value}"))
      case x => util.Logging.info(s"Unhandled game player message [$x].")
    }
    case pm: GameMessage.PlayerMessage => throw new IllegalStateException(s"Received input for player [${pm.idx}], but only know [${players.size}] players.")
    case n: GameMessage.Notify => notifyChannel(n)
    case x => util.Logging.info(s"Unhandled game service message [$x].")
  }

  private[this] def getDestination(dest: String) = dest.split(':').toList match {
    case level :: _ :: Nil if level == options.map.value => throw new IllegalStateException(s"Doors to same level [$level] aren't currently supported.")
    case level :: door :: Nil => TiledMap.withValue(level) -> door
    case _ => throw new IllegalStateException(s"Invalid destination [$dest]")
  }
}

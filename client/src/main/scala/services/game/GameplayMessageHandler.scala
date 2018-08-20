package services.game

import models.game.GameMessage
import models.input.PointerAction
import services.state.NavigationService
import util.Logging

trait GameplayMessageHandler { this: GameplayService =>
  protected[this] def pointerAct(pa: PointerAction) = {
    val (worldX, worldY) = display.camera.worldToMap(pa.worldX, pa.worldY)
    val collisions = nodes.collect { case n if n.x < worldX && n.y < worldY && (n.x + n.width) >= worldX && (n.y + n.height) >= worldY => n }
    collisions.foreach(n => Logging.info(s"Pointer Collision [$worldX / $worldY]: $n"))
  }

  protected[this] def applyMessage(msg: GameMessage) = msg match {
    case pm: GameMessage.PlayerMessage if pm.idx == -1 => throw new IllegalStateException(s"Received unhandled system player input.")
    case pm: GameMessage.PlayerMessage if pm.idx < players.size => pm match {
      case GameMessage.PlayerAnimationUpdated(_, anim) => display.playerSprites(pm.idx).setAnimation(Some(anim))
      case GameMessage.PlayerLocationUpdated(_, x, y) => display.playerSprites(pm.idx).setPosition(newX = x, newY = y)
      case GameMessage.LeaveMap(_, _, dest) => NavigationService.newMap(dest)
      case x => util.Logging.info(s"Unhandled game player message [$x].")
    }
    case pm: GameMessage.PlayerMessage => throw new IllegalStateException(s"Received input for player [${pm.idx}], but only know [${players.size}] players.")
    case n: GameMessage.Notify => n.msgs.foreach(display.console.log)
    case x => util.Logging.info(s"Unhandled game service message [$x].")
  }
}

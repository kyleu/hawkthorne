package models.player

import models.game.GameMessage
import models.input.PlayerInputHandler
import services.game.GameInstanceDebug.log

case class PlayerRecord(idx: Int, player: Player, var x: Double, var y: Double, input: PlayerInputHandler) {
  def setAnimation(anim: String) = player.attributes.animation = anim
  def setPosition(newX: Double, newY: Double) = {
    x = newX
    y = newY
  }
  def apply(pm: GameMessage.PlayerMessage) = pm match {
    case GameMessage.PlayerAnimationUpdated(_, anim) => setAnimation(anim)
    case GameMessage.PlayerLocationUpdated(_, newX, newY) => setPosition(newX, newY)
    case unhandled => log(s"Unhandled player message [$unhandled]")
  }
}

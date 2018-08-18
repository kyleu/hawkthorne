package models.player

import models.game.GameMessage
import models.input.PlayerInputHandler
import services.game.GameInstanceDebug.log

case class PlayerRecord(idx: Int, player: Player, input: PlayerInputHandler) {
  private[this] def setAnimation(anim: String) = player.attributes.animation = anim
  private[this] def setPosition(newX: Double, newY: Double) = input.setPosition(newX, newY)

  def apply(pm: GameMessage.PlayerMessage) = pm match {
    case GameMessage.PlayerAnimationUpdated(_, anim) => setAnimation(anim)
    case GameMessage.PlayerLocationUpdated(_, newX, newY) => setPosition(newX, newY)
    case unhandled => log(s"Unhandled player message [$unhandled]")
  }
}

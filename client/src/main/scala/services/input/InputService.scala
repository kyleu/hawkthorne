package services.input

import com.definitelyscala.phaserce.Game
import models.player.PlayerSprite

class InputService(game: Game, players: IndexedSeq[PlayerSprite]) {
  private[this] val keyboardInput = KeyboardInput(game)
  private[this] val gamepadInput = GamepadInput(game)
  private[this] val pointerInput = PointerInput(game)

  def close() = {
    keyboardInput.close()
    gamepadInput.close()
    pointerInput.close()
  }

  def update(menu: Boolean, delta: Double) = {
    pointerInput.update(menu, delta)

    val updates = (keyboardInput.update(menu, delta) +: gamepadInput.update(menu, delta)).groupBy(_._1).values.flatMap {
      case u if u.length > 1 => Seq((u.map(_._1).head, (u.map(_._2._1).sum, u.map(_._2._2).sum), u.flatMap(_._3)))
      case u => u
    }.toSeq

    updates.foreach {
      case u if u._1 == -1 => util.Logging.info("Menu update!") // menu.processInput(delta, u._2, u._3)
      case u => players(u._1).processInput(delta, u._2, u._3)
    }
  }
}

package services.input

import com.definitelyscala.phaserce.Game
import models.component.PlayerSprite
import models.game.GameUpdate
import models.input.{InputCommand, PointerAction}

class InputService(game: Game, systemCommandHandler: InputCommand => Unit) {
  private[this] val keyboardInput = KeyboardInput(game)
  private[this] val gamepadInput = GamepadInput(game)
  private[this] val pointerInput = PointerInput(game)

  private[this] val players = collection.mutable.ArrayBuffer.empty[PlayerSprite]
  private[this] var pointerEventCallback: Option[PointerAction => Unit] = None
  def setPointerEventCallback(f: Option[PointerAction => Unit]) = pointerEventCallback = f

  val menuHandler = new MenuInputHandler()

  def close() = {
    keyboardInput.close()
    gamepadInput.close()
    pointerInput.close()
  }

  def addPlayer(playerSprite: PlayerSprite) = {
    players += playerSprite
  }

  def update(delta: Double) = {
    pointerInput.update(delta).foreach(pointerEvent => pointerEventCallback.foreach(_(pointerEvent)))

    val updates = (keyboardInput.update(delta) +: gamepadInput.update(delta)).groupBy(_.idx).values.flatMap {
      case u if u.length > 1 => Seq(GameUpdate.PlayerInput(u.map(_.idx).head, u.map(_.x).sum, u.map(_.y).sum, u.flatMap(_.commands)))
      case u => u
    }.toSeq

    updates.foreach { u =>
      val (systemCommands, playerCommands) = u.commands.partition(_ == InputCommand.Debug)
      systemCommands.foreach(systemCommandHandler)
      if (menuHandler.enabled) {
        menuHandler.update(u.x, u.y, playerCommands)
      } else {
        if (u.idx < players.size) {
          players(u.idx).processInput(delta, u.copy(commands = playerCommands))
        } else {
          throw new IllegalStateException(s"Received input for player [$u], but only have [${players.size}] players.")
        }
      }
    }
  }
}

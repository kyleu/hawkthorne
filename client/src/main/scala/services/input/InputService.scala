package services.input

import com.definitelyscala.phaserce.Game
import models.game.cmd.GameCommand
import models.input.{InputCommand, PointerAction}

class InputService(game: Game, systemCommandHandler: InputCommand => Unit) {
  private[this] val keyboardInput = KeyboardInput(game)
  private[this] val gamepadInput = GamepadInput(game)
  private[this] val pointerInput = PointerInput(game)

  private[this] var pointerEventCallback: Option[PointerAction => Unit] = None
  def setPointerEventCallback(f: Option[PointerAction => Unit]) = pointerEventCallback = f

  val menuHandler = new MenuInputHandler()

  def close() = {
    keyboardInput.close()
    gamepadInput.close()
    pointerInput.close()
  }

  def update(delta: Double): Seq[GameCommand] = {
    pointerInput.update(delta).foreach(pointerEvent => pointerEventCallback.foreach(_(pointerEvent)))

    val updates = (keyboardInput.update(delta).toSeq ++ gamepadInput.update(delta)).groupBy(_.idx).values.flatMap {
      case u if u.length > 1 => Seq(GameCommand.PlayerInput(u.map(_.idx).head, u.map(_.x).sum, u.map(_.y).sum, u.flatMap(_.commands)))
      case u => u
    }.toSeq

    val remaining = updates.flatMap { u =>
      val (systemCommands, playerCommands) = u.commands.partition(_ == InputCommand.Debug)
      systemCommands.foreach(systemCommandHandler)
      if (menuHandler.enabled) {
        menuHandler.update(u.x, u.y, playerCommands)
        None
      } else {
        Some(u.copy(commands = playerCommands))
      }
    }

    remaining
  }
}

package services.input

import com.definitelyscala.phaserce.Game
import models.input.{InputUpdate, PointerAction}
import models.player.PlayerSprite

class InputService(game: Game) {
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
      case u if u.length > 1 => Seq(InputUpdate(u.map(_.idx).head, u.map(_.x).sum, u.map(_.y).sum, u.flatMap(_.commands)))
      case u => u
    }.toSeq

    updates.foreach {
      case u if menuHandler.enabled => menuHandler.update(u)
      case u => players.size match {
        case x if u.idx < x => players(u.idx).processInput(delta, (u.x, u.y), u.commands)
        case x => throw new IllegalStateException(s"Received input for player [$u], but only have [$x] players.")
      }
    }
  }
}

package services.input

import com.definitelyscala.phaserce.{Game, Sprite}

class InputService(game: Game, sprite: Sprite, handler: InputHandler) {
  private[this] val cursors = game.input.keyboard.createCursorKeys()

  private[this] val keyboardInput = KeyboardInput(game)
  private[this] val gamepadInput = GamepadInput(game)

  def close() = {
    keyboardInput.close()
    gamepadInput.close()
  }

  def update(elapsed: Double) = {
    val updates = (keyboardInput.update(elapsed) +: gamepadInput.update(elapsed)).groupBy(_._1).values.flatMap {
      case u if u.size > 1 => Seq((u.map(_._1).head, (u.map(_._2._1).sum, u.map(_._2._2).sum), u.flatMap(_._3)))
      case u => u
    }.toSeq

    updates.foreach(u => handler.process(elapsed, u._1, u._2, u._3))
  }
}

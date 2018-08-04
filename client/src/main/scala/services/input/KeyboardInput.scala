package services.input

import com.definitelyscala.phaserce.{Game, Key, KeyCode}
import models.input.{InputCommand, InputUpdate}

object KeyboardInput {
  final case class Keymap(
      up: Key, down: Key, left: Key, right: Key,
      jump: Key, attack: Key,
      select: Key, confirm: Key,
      pause: Key, debug: Key
  ) {
    override def toString = s"Up: ${up.isDown}, Down: ${down.isDown}, Left: ${left.isDown}, Right: ${right.isDown}, " +
      s"Jump: ${jump.isDown}, Attack: ${attack.isDown}, " +
      s"Select: ${select.isDown}, Confirm: ${confirm.isDown}, " +
      s"Options: ${pause.isDown}, Debug: ${debug.isDown}"
  }
}

final case class KeyboardInput(game: Game) {
  val keymap = KeyboardInput.Keymap(
    up = game.input.keyboard.addKey(KeyCode.UP),
    down = game.input.keyboard.addKey(KeyCode.DOWN),
    left = game.input.keyboard.addKey(KeyCode.LEFT),
    right = game.input.keyboard.addKey(KeyCode.RIGHT),

    jump = game.input.keyboard.addKey(KeyCode.SPACEBAR),
    attack = game.input.keyboard.addKey(KeyCode.CONTROL),

    select = game.input.keyboard.addKey(KeyCode.ALT),
    confirm = game.input.keyboard.addKey(KeyCode.ENTER),

    pause = game.input.keyboard.addKey(KeyCode.ESC),
    debug = game.input.keyboard.addKey(KeyCode.QUESTION_MARK)
  )

  def update(delta: Double) = {
    val x = if (keymap.left.isDown) { -1.0 } else if (keymap.right.isDown) { 1.0 } else { 0.0 }
    val y = if (keymap.up.isDown) { -1.0 } else if (keymap.down.isDown) { 1.0 } else { 0.0 }
    val commands = Seq(
      if (keymap.jump.justDown) { Some(InputCommand.Jump) } else { None },
      if (keymap.attack.justDown) { Some(InputCommand.Attack) } else { None },

      if (keymap.select.justDown) { Some(InputCommand.Select) } else { None },
      if (keymap.confirm.justDown) { Some(InputCommand.Confirm) } else { None },

      if (keymap.pause.justDown) { Some(InputCommand.Pause) } else { None },
      if (keymap.debug.justDown) { Some(InputCommand.Debug) } else { None }
    ).flatten
    InputUpdate(0, x, y, commands)
  }

  def close() = {}
}

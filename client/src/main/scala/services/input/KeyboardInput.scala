package services.input

import com.definitelyscala.phaserce.{Game, Key, KeyCode}
import services.debug.DebugService
import util.PhaserUtils

object KeyboardInput {
  case class Keymap(
      up: Key, down: Key, left: Key, right: Key,
      jump: Key, attack: Key, select: Key,
      options: Key, debug: Key
  ) {
    override def toString = s"Up: ${up.isDown}, Down: ${down.isDown}, Left: ${left.isDown}, Right: ${right.isDown}, " +
      s"Jump: ${jump.isDown}, Attack: ${attack.isDown}, Select: ${select.isDown}, Options: ${options.isDown}, Debug: ${debug.isDown}, "
  }
}

case class KeyboardInput(game: Game) {
  val keymap = KeyboardInput.Keymap(
    up = game.input.keyboard.addKey(KeyCode.UP),
    down = game.input.keyboard.addKey(KeyCode.DOWN),
    left = game.input.keyboard.addKey(KeyCode.LEFT),
    right = game.input.keyboard.addKey(KeyCode.RIGHT),

    jump = game.input.keyboard.addKey(KeyCode.SPACEBAR),
    attack = game.input.keyboard.addKey(KeyCode.CONTROL),
    select = game.input.keyboard.addKey(KeyCode.ALT),

    options = game.input.keyboard.addKey(KeyCode.ESC),
    debug = game.input.keyboard.addKey(KeyCode.QUESTION_MARK)
  )

  PhaserUtils.addToSignal(keymap.debug.onDown, _ => DebugService.inst.foreach(_.toggle()))

  def update(menu: Boolean, delta: Double) = {
    val x = if (keymap.left.isDown) { -1.0 } else if (keymap.right.isDown) { 1.0 } else { 0.0 }
    val y = if (keymap.up.isDown) { -1.0 } else if (keymap.down.isDown) { 1.0 } else { 0.0 }
    val i = if (menu) { -1 } else { 0 }
    val commands = Seq(
      if (keymap.jump.justDown) { Some("jump") } else { None },
      if (keymap.options.justDown) { Some("options") } else { None }
    ).flatten
    (i, (x, y), commands)
  }

  def close() = {}
}

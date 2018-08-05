package services.input

import com.definitelyscala.phaserce.{Game, Gamepad, SinglePad}
import models.game.GameUpdate
import models.input.InputCommand

object GamepadInput {
  final case class Keymap(
      up: Double, down: Double, left: Double, right: Double,
      leftStickX: Double, leftStickY: Double, rightStickX: Double, rightStickY: Double,
      jump: Double, attack: Double,
      select: Double, confirm: Double,
      options: Double, debug: Double
  )

  def xboxKeymap(p: SinglePad) = Keymap(
    up = Gamepad.XBOX360_DPAD_UP,
    down = Gamepad.XBOX360_DPAD_DOWN,
    left = Gamepad.XBOX360_DPAD_LEFT,
    right = Gamepad.XBOX360_DPAD_RIGHT,
    leftStickX = Gamepad.XBOX360_STICK_LEFT_X,
    leftStickY = Gamepad.XBOX360_STICK_LEFT_Y,
    rightStickX = Gamepad.XBOX360_STICK_RIGHT_X,
    rightStickY = Gamepad.XBOX360_STICK_RIGHT_Y,
    jump = Gamepad.XBOX360_X,
    attack = Gamepad.XBOX360_A,
    select = Gamepad.XBOX360_B,
    confirm = Gamepad.XBOX360_RIGHT_BUMPER,
    options = Gamepad.XBOX360_START,
    debug = Gamepad.XBOX360_BACK
  )

  def psKeymap(p: SinglePad) = Keymap(
    up = Gamepad.PS3XC_DPAD_UP,
    down = Gamepad.PS3XC_DPAD_DOWN,
    left = Gamepad.PS3XC_DPAD_LEFT,
    right = Gamepad.PS3XC_DPAD_RIGHT,
    leftStickX = Gamepad.PS3XC_STICK_LEFT_X,
    leftStickY = Gamepad.PS3XC_STICK_LEFT_Y,
    rightStickX = Gamepad.PS3XC_STICK_RIGHT_X,
    rightStickY = Gamepad.PS3XC_STICK_RIGHT_Y,
    jump = Gamepad.PS3XC_SQUARE,
    attack = Gamepad.PS3XC_X,
    select = Gamepad.PS3XC_CIRCLE,
    confirm = Gamepad.PS3XC_R1,
    options = Gamepad.PS3XC_START,
    debug = Gamepad.PS3XC_SELECT
  )
}

final case class GamepadInput(game: Game) {
  game.input.gamepad.start()

  private[this] val pads = IndexedSeq(game.input.gamepad.pad1, game.input.gamepad.pad2, game.input.gamepad.pad3, game.input.gamepad.pad4)
  pads.zipWithIndex.foreach(pad => pad._1.addCallbacks(pad._1, scalajs.js.Dynamic.literal(
    "onConnect" -> onConnect(pad._1, pad._2) _,
    "onDisconnect" -> onDisconnect(pad._1, pad._2) _
  )))

  private[this] val keymaps = Array(pads.map(GamepadInput.xboxKeymap): _*)
  def setKeymap(idx: Int, keymap: GamepadInput.Keymap) = keymaps(idx) = keymap

  private[this] def onConnect(pad: SinglePad, idx: Int)(x: Any) = util.Logging.info(s"Gamepad [${pad.index.toInt}] connected.")
  private[this] def onDisconnect(pad: SinglePad, idx: Int)(x: Any) = util.Logging.info(s"Gamepad [${pad.index.toInt}] disconnected.")
  def close() = game.input.gamepad.stop()

  def update(delta: Double) = pads.zipWithIndex.collect {
    case (pad, idx) if pad.connected =>
      val map = keymaps(idx)
      val x = if (pad.getButton(map.left).isDown) { -1.0 } else if (pad.getButton(map.right).isDown) { 1.0 } else { 0.0 /* pad.axis(map.leftStickX) */ }
      val y = if (pad.getButton(map.up).isDown) { -1.0 } else if (pad.getButton(map.down).isDown) { 1.0 } else { 0.0 /* pad.axis(map.leftStickY) */ }
      val commands = Seq(
        if (pad.getButton(map.jump).justPressed(delta)) { Some(InputCommand.Jump) } else { None },
        if (pad.getButton(map.attack).justPressed(delta)) { Some(InputCommand.Attack) } else { None },

        if (pad.getButton(map.select).justPressed(delta)) { Some(InputCommand.Select) } else { None },
        if (pad.getButton(map.confirm).justPressed(delta)) { Some(InputCommand.Confirm) } else { None },

        if (pad.getButton(map.options).justPressed(delta)) { Some(InputCommand.Pause) } else { None },
        if (pad.getButton(map.debug).justPressed(delta)) { Some(InputCommand.Debug) } else { None }
      ).flatten
      GameUpdate.PlayerInput(idx, x, y, commands)
  }
}

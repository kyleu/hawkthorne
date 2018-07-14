package services.input

import com.definitelyscala.phaserce.{Game, Gamepad, SinglePad}

object GamepadInput {
  case class Keymap(
    up: Double, down: Double, left: Double, right: Double,
    jump: Double, attack: Double, select: Double,
    options: Double, debug: Double
  )

  def xboxKeymap(p: SinglePad) = Keymap(
    up = Gamepad.XBOX360_DPAD_UP,
    down = Gamepad.XBOX360_DPAD_DOWN,
    left = Gamepad.XBOX360_DPAD_LEFT,
    right = Gamepad.XBOX360_DPAD_RIGHT,
    jump = Gamepad.XBOX360_X,
    attack = Gamepad.XBOX360_A,
    select = Gamepad.XBOX360_B,
    options = Gamepad.XBOX360_START,
    debug = Gamepad.XBOX360_BACK
  )

  def psKeymap(p: SinglePad) = Keymap(
    up = Gamepad.PS3XC_DPAD_UP,
    down = Gamepad.PS3XC_DPAD_DOWN,
    left = Gamepad.PS3XC_DPAD_LEFT,
    right = Gamepad.PS3XC_DPAD_RIGHT,
    jump = Gamepad.PS3XC_SQUARE,
    attack = Gamepad.PS3XC_X,
    select = Gamepad.PS3XC_CIRCLE,
    options = Gamepad.PS3XC_START,
    debug = Gamepad.PS3XC_SELECT
  )
}

case class GamepadInput(game: Game) {
  game.input.gamepad.start()

  val pads = IndexedSeq(game.input.gamepad.pad1, game.input.gamepad.pad2, game.input.gamepad.pad3, game.input.gamepad.pad4)
  pads.zipWithIndex.foreach(pad => pad._1.addCallbacks(pad._1, scalajs.js.Dynamic.literal(
    "onConnect" -> onConnect(pad._1, pad._2) _,
    "onDisconnect" -> onDisconnect(pad._1, pad._2) _,
  )))
  var keymaps = Array(pads.map(GamepadInput.xboxKeymap): _*)

  private[this] def onConnect(pad: SinglePad, idx: Int)(x: Any) = {
    util.Logging.info(s"Gamepad [${pad.index.toInt}] connected.")
  }

  private[this] def onDisconnect(pad: SinglePad, idx: Int)(x: Any) = {
    util.Logging.info(s"Gamepad [${pad.index.toInt}] disconnected.")
  }

  def close() = {
    game.input.gamepad.stop()
  }

  def update(elapsed: Double) = pads.zipWithIndex.collect {
    case (pad, idx) if pad.connected =>
      val map = keymaps(idx)
      val x = if (pad.getButton(map.left).isDown) { -1.0 } else if (pad.getButton(map.right).isDown) { 1.0 } else { 0.0 }
      val y = if (pad.getButton(map.up).isDown) { -1.0 } else if (pad.getButton(map.down).isDown) { 1.0 } else { 0.0 }
      (idx, (x, y), Seq.empty[String])
  }.toSeq
}

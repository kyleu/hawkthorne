package services.input

import com.definitelyscala.phaserce.{Game, SinglePad}

case class GamepadInput(game: Game) {
  game.input.gamepad.start()

  private[this] def onConnect(pad: SinglePad)(x: Any) = {
    util.Logging.info(s"Gamepad [${pad.index.toInt}] connected.")
  }

  val pad1 = game.input.gamepad.pad1
  val pad2 = game.input.gamepad.pad2
  val pad3 = game.input.gamepad.pad3
  val pad4 = game.input.gamepad.pad4

  val all = IndexedSeq(pad1, pad2, pad3, pad4)
  all.foreach(pad => pad1.addCallbacks(pad, scalajs.js.Dynamic.literal("onConnect" -> onConnect(pad) _)))

  def close() = {
    game.input.gamepad.stop()
  }

  def update(elapsed: Double) = all.zipWithIndex.flatMap {
    case (pad, idx) if pad.connected =>
      val x = if (pad.isDown(14)) { -1.0 } else if (pad.isDown(15)) { 1.0 } else { 0.0 }
      val y = if (pad.isDown(12)) { -1.0 } else if (pad.isDown(13)) { 1.0 } else { 0.0 }
      Some((idx, (x, y), Seq.empty[String]))
    case _ => None
  }
}

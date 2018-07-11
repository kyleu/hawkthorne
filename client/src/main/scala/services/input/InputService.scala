package services.input

import com.definitelyscala.phaserce.{Game, SinglePad, Sprite}

class InputService(phaser: Game, sprite: Sprite) {
  phaser.input.gamepad.start()

  private[this] def onConnectOne(x: Any) = onConnect(phaser.input.gamepad.pad1)
  phaser.input.gamepad.pad1.addCallbacks(phaser.input.gamepad.pad1, scalajs.js.Dynamic.literal("onConnect" -> onConnectOne _))

  private[this] def onConnectTwo(x: Any) = onConnect(phaser.input.gamepad.pad2)
  phaser.input.gamepad.pad2.addCallbacks(phaser.input.gamepad.pad2, scalajs.js.Dynamic.literal("onConnect" -> onConnectTwo _))

  private[this] def onConnectThree(x: Any) = onConnect(phaser.input.gamepad.pad3)
  phaser.input.gamepad.pad3.addCallbacks(phaser.input.gamepad.pad3, scalajs.js.Dynamic.literal("onConnect" -> onConnectThree _))

  private[this] def onConnectFour(x: Any) = onConnect(phaser.input.gamepad.pad4)
  phaser.input.gamepad.pad4.addCallbacks(phaser.input.gamepad.pad4, scalajs.js.Dynamic.literal("onConnect" -> onConnectFour _))

  private[this] val cursors = phaser.input.keyboard.createCursorKeys()

  def close() = {
    phaser.input.gamepad.stop()
  }

  private[this] def onConnect(pad: SinglePad) = {
    util.Logging.info(s"Gamepad [${pad.index.toInt}] connected.")
  }

  def update(elapsed: Double) = {
    if (cursors.left.isDown) {
      sprite.x -= 4
    } else if (cursors.right.isDown) {
      sprite.x += 4
    }

    if (cursors.up.isDown) {
      sprite.y -= 4
    } else if (cursors.down.isDown) {
      sprite.y += 4
    }
  }
}

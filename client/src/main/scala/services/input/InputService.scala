package services.input

import com.definitelyscala.phaserce.{Game, SinglePad, Sprite}

class InputService(phaser: Game, sprite: Sprite, handler: InputHandler) {
  phaser.input.gamepad.start()

  private[this] def onConnect(pad: SinglePad)(x: Any) = {
    util.Logging.info(s"Gamepad [${pad.index.toInt}] connected.")
  }

  phaser.input.gamepad.pad1.addCallbacks(phaser.input.gamepad.pad1, scalajs.js.Dynamic.literal("onConnect" -> onConnect(phaser.input.gamepad.pad1) _))
  phaser.input.gamepad.pad2.addCallbacks(phaser.input.gamepad.pad2, scalajs.js.Dynamic.literal("onConnect" -> onConnect(phaser.input.gamepad.pad2) _))
  phaser.input.gamepad.pad3.addCallbacks(phaser.input.gamepad.pad3, scalajs.js.Dynamic.literal("onConnect" -> onConnect(phaser.input.gamepad.pad3) _))
  phaser.input.gamepad.pad4.addCallbacks(phaser.input.gamepad.pad4, scalajs.js.Dynamic.literal("onConnect" -> onConnect(phaser.input.gamepad.pad4) _))

  private[this] val cursors = phaser.input.keyboard.createCursorKeys()

  def close() = {
    phaser.input.gamepad.stop()
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

    if (phaser.input.gamepad.pad1.connected) {
      if (phaser.input.gamepad.pad1.isDown(14)) {
        sprite.x -= 4
      } else if (phaser.input.gamepad.pad1.isDown(15)) {
        sprite.x += 4
      }
      if (phaser.input.gamepad.pad1.isDown(12)) {
        sprite.y -= 4
      } else if (phaser.input.gamepad.pad1.isDown(13)) {
        sprite.y += 4
      }
    }
  }
}

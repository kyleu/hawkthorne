package services.test

import com.definitelyscala.phaserce.Game
import models.font.Font
import models.input.VirtualKeyboard
import models.modal.{BaseModal, Dialog}
import services.input.InputService
import services.state.{GameState, LoadingState}
import util.IntPoint

object TestState {
  def load(phaser: Game, inputService: InputService) = {
    new LoadingState(next = new TestState(phaser, inputService), phaser = phaser, assets = Font.assets ++ BaseModal.assets)
  }
}

class TestState(phaser: Game, inputService: InputService) extends GameState("test", phaser) {
  private[this] var dialog: Option[Dialog] = None
  private[this] var kb: Option[VirtualKeyboard] = None

  override def create(game: Game) = {
    val message = "Hello, {{green}}world{{white}}! The quick {{red_dark}}brown {{orange}}fox{{white}} jumped over the lazy {{blue}}dog{{white}}."
    Font.fonts.map(Font.getFont(_, game)).zipWithIndex.foreach {
      case (f, idx) =>
        val i1 = f.renderSimple(name = s"test.$idx.all", text = Font.chars.tail, game = game, x = 10, y = 10 + (idx * 100.0))
        val i2 = f.renderSimple(name = s"test.$idx.phrase", text = message, game = game, x = 10, y = 60 + (idx * 100.0))

        game.add.existing(i1.group)
        game.add.existing(i2.group)
    }

    dialog = Some(new Dialog(phaser, inputService))
    val longWinded = "There's a slight chance that this excessively long line will cause the text to wrap, perhaps even to more than three lines"
    dialog.foreach(_.show(onComplete = () => util.Logging.info("Dialog complete!"), longWinded, "...but will it work?", message))

    kb = Some(new VirtualKeyboard(
      game = phaser,
      name = "keyboard",
      initial = IntPoint(0, 410),
      onChar = c => util.Logging.info(s"Keypress: [$c]"),
      onEnter = () => util.Logging.info(s"On Enter!")
    ))
    kb.foreach(k => game.add.existing(k.group))
    onResize(game.width.toInt, game.height.toInt)
  }

  override def update(game: Game) = {
    val dt = game.time.physicsElapsed
    inputService.update(dt)
    dialog.foreach(_.update(dt))
  }

  override def onResize(width: Int, height: Int) = {
    dialog.foreach(_.resize(width, height, 3.1))
  }
}

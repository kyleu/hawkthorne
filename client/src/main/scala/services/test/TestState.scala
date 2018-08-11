package services.test

import com.definitelyscala.phaserce.Game
import models.component.BaseModal
import models.font.Font
import models.input.VirtualKeyboard
import org.scalajs.dom
import services.state.{GameState, LoadingState}

object TestState {
  def load(phaser: Game) = new LoadingState(next = new TestState(phaser), phaser = phaser, assets = Font.assets)
}

class TestState(phaser: Game) extends GameState("test", phaser) {
  private[this] var modal: Option[BaseModal] = None
  private[this] var kb: Option[VirtualKeyboard] = None

  override def create(game: Game) = {
    val message = "Hello, {{green}}world{{white}}! The quick {{red_dark}}brown {{orange}}fox{{white}} jumped over the lazy {{blue}}dog{{white}}."
    Font.fonts.map(Font.getFont(_, game)).zipWithIndex.foreach {
      case (f, idx) =>
        val i1 = f.render(s"test.$idx.all", Font.chars.tail, game, 10, 10 + (idx * 100.0))
        val i2 = f.render(s"test.$idx.phrase", message, game, 10, 60 + (idx * 100.0))

        game.add.existing(i1.group)
        game.add.existing(i2.group)
    }

    // modal = Some(new BaseModal(phaser, "test"))
    modal.foreach { m =>
      m.open(onOpen = () => util.Logging.info("Modal opened"))
      dom.window.setTimeout(handler = () => {
        //m.close(() => util.Logging.info("Modal closed"))
      }, timeout = 10.0)
    }

    kb = Some(new VirtualKeyboard(phaser, "keyboard", 0, 410))
    kb.foreach(k => game.add.existing(k.group))
  }

  override def update(game: Game) = {
    val dt = game.time.physicsElapsed
    modal.foreach(_.update(dt))
  }
}

package models.modal

import com.definitelyscala.phaserce.Game
import models.font.{Font, MultilineText}
import models.input.{MenuAction, PointerAction}
import services.input.InputService

class Prompt(game: Game, inputService: InputService) extends BaseModal(game, "prompt") {
  private[this] val font = Font.getFont("arial", game)
  private[this] var active: Option[String => Unit] = None
  private[this] var currentText: Option[MultilineText] = None

  def show(onComplete: String => Unit, msg: String, options: Seq[String] = Seq("Yes", "No")) = {
    if (group.visible || active.isDefined) { throw new IllegalStateException("Prompt is already open") }

    active = Some(onComplete)

    val text = newText(name = "prompt.text", msg = msg)
    currentText = Some(text)

    open(() => {
      inputService.menuHandler.setCallback(Some(acts => acts.foreach(menuAction)))
      inputService.setPointerEventCallback(Some(act => pointerAction(act)))
    })
  }

  def menuAction(x: MenuAction) = {}

  def pointerAction(x: PointerAction) = {}

  def finish(answer: String) = close(() => {
    currentText.foreach(_.destroy())
    currentText = None
    active.getOrElse(throw new IllegalStateException("No active prompt callback"))(answer)
    active = None
  })

  private[this] def newText(name: String, msg: String) = {
    val text = font.renderMultiline(name = "dialog.text", text = msg, game = game, x = BaseModal.padding.toDouble, maxWidth = BaseModal.textWidth)
    text.group.position.y = text.lines match {
      case 1 => BaseModal.padding + 16.0
      case 2 => BaseModal.padding + 9.0
      case 3 => BaseModal.padding + 2.0
    }
    group.add(text.group)
    text
  }
}

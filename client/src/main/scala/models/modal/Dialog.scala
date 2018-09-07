package models.modal

import com.definitelyscala.phaserce.Game
import models.font.{Font, MultilineText}
import services.input.InputService

class Dialog(game: Game, inputService: InputService) extends BaseModal(game, "dialog") {
  private[this] val font = Font.getFont("arial", game)
  private[this] var active: Option[() => Unit] = None
  private[this] var latest: Option[MultilineText] = None
  private[this] var remaining = List.empty[String]

  def show(onComplete: () => Unit, msgs: String*) = {
    // if (group.visible || active.isDefined) { throw new IllegalStateException("Dialog is already open") }
    if (msgs.isEmpty) { throw new IllegalStateException("No messages provided to dialog") }

    active = Some(onComplete)
    remaining = msgs.toList
    next()

    open(() => {
      remaining = msgs.tail.toList
      inputService.menuHandler.setCallback(Some(_ => next()))
      inputService.setPointerEventCallback(Some(_ => next()))
    })
  }

  def next() = {
    remaining match {
      case Nil => close(() => active.foreach(f => {
        active = None
        inputService.menuHandler.setCallback(None)
        inputService.setPointerEventCallback(None)
        latest.foreach(_.destroy())
        latest = None
        f()
      }))
      case h :: t =>
        val text = newText(name = "dialog.text", msg = h)
        latest.foreach(_.destroy())
        latest = Some(text)
        remaining = t
    }
  }

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

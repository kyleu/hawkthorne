package models.modal

import com.definitelyscala.phaserce.{Game, Point}
import models.font.{Font, MultilineText}
import models.input.MenuAction
import services.input.InputService

object Dialog {
  val padding = 8
  val textWidth = BaseModal.width - (padding * 2)
}

class Dialog(game: Game, inputService: InputService) extends BaseModal(game, "dialog") {
  private[this] val font = Font.getFont("arial", game)
  private[this] var active: Option[() => Unit] = None
  private[this] var latest: Option[MultilineText] = None
  private[this] var remaining = List.empty[String]

  def show(onComplete: () => Unit, msgs: String*) = {
    if (visible || active.isDefined) { throw new IllegalStateException("Dialog is already open") }
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
      case Nil => close(() => {
        val f = active.getOrElse(throw new IllegalStateException("Dialog close already called"))
        active = None
        inputService.menuHandler.setCallback(None)
        inputService.setPointerEventCallback(None)
        latest.foreach(_.destroy())
        latest = None
        f()
      })
      case h :: t =>
        val text = font.renderMultiline(name = "dialog.text", text = h, game = game, x = Dialog.padding.toDouble, maxWidth = Dialog.textWidth)
        text.group.position.y = text.lines match {
          case 1 => Dialog.padding + 16.0
          case 2 => Dialog.padding + 8.0
          case 3 => Dialog.padding.toDouble
        }
        comp.add(text.group)
        latest.foreach(_.destroy())
        latest = Some(text)
        remaining = t
    }
  }
}

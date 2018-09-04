package services.event

import models.ResponseMessage
import org.scalajs.dom.raw.Event

trait EventHandler {
  def onConnect(): Unit

  def onResponseMessage(msg: ResponseMessage): Unit

  def onError(err: Event): Unit
  def onClose(): Unit
}

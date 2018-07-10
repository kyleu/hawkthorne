package services.socket

import models.RequestMessage
import org.scalajs.dom
import util.Logging

object NetworkMessage {
  var latencyMs: Option[Int] = None
  private[this] lazy val latencyContainer = Option(dom.document.getElementById("ping-stats-display"))

  var sentMessageCount = 0
  var sentBytes = 0

  var receivedMessageCount = 0
  var receivedBytes = 0

  private[this] var sendF: Option[RequestMessage => Unit] = None

  def register(f: RequestMessage => Unit) = sendF match {
    case Some(_) => throw new IllegalStateException("Double registration.")
    case None => sendF = Some(f)
  }

  def sendMessage(requestMessage: RequestMessage) = sendF match {
    case Some(f) => f(requestMessage)
    case None => throw new IllegalStateException("Message send before start.")
  }

  def setLatencyMs(ms: Int) = {
    Logging.info(s"Latency update: ${ms}ms")
    latencyMs = Some(ms)
    latencyContainer.foreach(_.innerHTML = ms.toString)
  }
}

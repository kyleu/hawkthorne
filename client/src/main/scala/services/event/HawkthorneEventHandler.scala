package services.event

import io.circe.Json
import models.RequestMessage.ClientTrace
import models.ResponseMessage
import models.ResponseMessage.{Pong, SendClientTrace, ServerError, SystemBroadcast, SystemReady, UserSettings}
import org.scalajs.dom.raw.Event
import services.socket.{NetworkMessage, NotificationService, UserManager}
import util.{DateUtils, Logging}

import scala.scalajs.js.timers.setTimeout

object HawkthorneEventHandler {
  var phaserStarted = false
  var networkStarted = false
  var networkConnected = false
}

class HawkthorneEventHandler(onReady: Boolean => HawkthorneSystem) extends EventHandler {
  private[this] var systemOpt: Option[HawkthorneSystem] = None
  def system = systemOpt.getOrElse(throw new IllegalStateException("HawkthorneSystem is not ready."))

  private[this] def sendPing(): Unit = {
    NetworkMessage.sendMessage(models.RequestMessage.Ping(DateUtils.nowMillis))
    setTimeout(10000)(sendPing())
  }

  override def onConnect() = {
    Logging.debug("Socket connected.")
    setTimeout(1000)(sendPing())
    HawkthorneEventHandler.networkConnected = true
  }

  override def onResponseMessage(msg: ResponseMessage) = msg match {
    case p: Pong => onLatency((System.currentTimeMillis - p.ts).toInt)
    case us: UserSettings => UserManager.onUserSettings(us)
    case se: ServerError => NotificationService.err(se.reason + ": " + se.content)
    case sb: SystemBroadcast => NotificationService.log(sb.channel + ": " + sb.msg)
    case ctr: SendClientTrace => sendClientTrace(ctr.t)
    case SystemReady => onSystemReady()
    case _ => Logging.warn(s"Received unknown response message of type [${msg.getClass.getSimpleName}].")
  }

  override def onError(err: Event) = {
    if (systemOpt.isEmpty) { systemOpt = Some(onReady(false)) }
    Logging.error(s"Socket error")
    Logging.logJs(err)
  }

  override def onClose() = {
    Logging.info("Socket closed.")
    HawkthorneEventHandler.networkConnected = false
  }

  private[this] def onSystemReady() = systemOpt match {
    case Some(sys) => util.Logging.error("System initialized twice!")
    case None => systemOpt = Some(onReady(true))
  }

  private[this] def onLatency(ms: Int): Unit = NetworkMessage.setLatencyMs(ms)

  private[this] def sendClientTrace(t: String) = {
    val payload = Json.fromString("!!!")
    NetworkMessage.sendMessage(ClientTrace(payload))
  }
}

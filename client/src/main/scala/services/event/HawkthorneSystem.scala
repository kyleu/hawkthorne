package services.event

import com.definitelyscala.phaserce.Game
import io.circe.Json
import models.RequestMessage.ClientTrace
import models.ResponseMessage
import models.ResponseMessage.{SendClientTrace, SystemBroadcast}
import services.socket.{NetworkMessage, NotificationService, SocketConnection, UserManager}
import services.state.GameState

import scala.scalajs.js.JSON

case class HawkthorneSystem(socket: SocketConnection, phaser: Game, startMs: Long) {
  util.Logging.info(s"Hawkthorne system started in [${System.currentTimeMillis - startMs}ms]")

  UserManager.setSystemReady() // TODO Remove

  def onMessage(msg: ResponseMessage) = msg match {
    case sb: SystemBroadcast => NotificationService.log(sb.channel + ": " + sb.msg)
    case ctr: SendClientTrace => sendClientTrace(ctr.t)
    case _ => phaser.state.getCurrentState().asInstanceOf[GameState].onMessage(msg)
  }

  private[this] def sendClientTrace(t: String) = {
    val payload = io.circe.scalajs.convertJsToJson(phaser.device).right.get
    NetworkMessage.sendMessage(ClientTrace(payload))
  }
}

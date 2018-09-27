package services.socket

import java.util.UUID

import models.RequestMessage.SetPlayer
import models.ResponseMessage.UserSettings
import models.settings.ActivePlayers

object UserManager {
  private[this] var ready = false
  def setSystemReady() = ready = true
  def isSystemReady = ready
  def awaitSystemReady(f: () => Unit, count: Int = 0): Unit = {
    if (isSystemReady) {
      f()
    } else if (count > 100) {
      throw new IllegalStateException("Timed out waiting for system ready")
    } else {
      scala.scalajs.js.timers.setTimeout(100)(awaitSystemReady(f, count + 1))
    }
  }

  private[this] var userId: Option[UUID] = None
  private[this] var username: Option[String] = None
  private[this] var email: Option[String] = None

  def onUserSettings(us: UserSettings) = {
    util.Logging.debug(s"Received user settings for [${us.userId}].")
    userId = Some(us.userId)
    username = Some(us.username)
    email = Some(us.email)

    if (ActivePlayers.getPlayers.isEmpty) {
      util.Logging.warn("No active players available")
    } else {
      NetworkMessage.sendMessage(SetPlayer(ActivePlayers.networkPlayer))
    }
  }
}

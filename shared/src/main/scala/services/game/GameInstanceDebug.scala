package services.game

import java.util.UUID

import models.game.obj.GameObject
import models.options.GameOptions
import models.player.PlayerRecord
import services.map.GameMap
import util.JsonSerializers._

object GameInstanceDebug {
  private[this] var isDebug = true

  private[this] var logger: Option[String => Unit] = None
  def log(s: String) = logger.getOrElse(throw new IllegalStateException("Logger not initialized."))(s)
  def debug(s: => String) = if (isDebug) { logger.getOrElse(throw new IllegalStateException("Logger not initialized."))(s) }

  private[this] var notification: Option[String => Unit] = None
  protected[this] def notify(s: String) = notification.getOrElse(throw new IllegalStateException("Notifications not initialized."))(s)

  def setCallbacks(showDebug: Boolean, log: String => Unit, notify: String => Unit) = {
    isDebug = showDebug
    logger = Some(log)
    notification = Some(notify)
  }

  implicit val jsonEncoder: Encoder[GameInstanceDebug] = deriveEncoder
}

case class GameInstanceDebug(id: UUID, options: GameOptions, players: Seq[PlayerRecord], gameMap: GameMap, elapsedSeconds: Double)

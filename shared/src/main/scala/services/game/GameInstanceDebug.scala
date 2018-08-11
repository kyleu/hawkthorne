package services.game

import java.util.UUID

import models.game.GameStage
import models.options.GameOptions

object GameInstanceDebug {
  private[this] var initialized = false

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

  def debugString(id: UUID, options: GameOptions, stage: GameStage) = {
    import util.JsonSerializers._
    s"""[$id]: {
      |  options: ${options.asJson.noSpaces},
      |  objects: ${stage.objects.size}
      |}
    """.stripMargin.trim
  }
}

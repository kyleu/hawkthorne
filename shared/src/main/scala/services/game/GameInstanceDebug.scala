package services.game

trait GameInstanceDebug {
  private[this] val isDebug = true

  private[this] var logger: Option[String => Unit] = None
  def log(s: String) = logger.getOrElse(throw new IllegalStateException("Logger not initialized."))(s)
  def debug(s: String) = if (isDebug) { logger.getOrElse(throw new IllegalStateException("Logger not initialized."))(s) }

  private[this] var notification: Option[String => Unit] = None
  def notify(s: String) = notification.getOrElse(throw new IllegalStateException("Notifications not initialized."))(s)

  def setCallbacks(log: String => Unit, notify: String => Unit) = {
    logger = Some(log)
    notification = Some(notify)
  }
}

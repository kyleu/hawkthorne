package services.game

trait GameInstanceDebug {
  protected[this] val startMs = System.currentTimeMillis
  private[this] val isDebug = true

  private[this] var logger: Option[String => Unit] = None
  def log(s: String) = logger.getOrElse(throw new IllegalStateException("Not initialized."))(s)
  def debug(s: String) = if (isDebug) { logger.getOrElse(throw new IllegalStateException("Not initialized."))(s) }

  private[this] var notification: Option[String => Unit] = None
  def notify(s: String) = notification.getOrElse(throw new IllegalStateException("Not initialized."))(s)

  def setCallbacks(log: String => Unit, notify: String => Unit) = {
    logger = Some(log)
    notification = Some(notify)
  }
}

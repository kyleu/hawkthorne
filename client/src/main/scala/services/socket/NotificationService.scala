package services.socket

object NotificationService {
  private[this] var logCallback: Option[String => Unit] = None
  private[this] var errCallback: Option[String => Unit] = None

  def register(log: String => Unit, err: String => Unit) = {
    logCallback = Some(log)
    errCallback = Some(err)
  }

  def log(s: String) = logCallback match {
    case Some(cb) => cb(s)
    case None => util.Logging.info("Notification: " + s)
  }

  def err(s: String) = errCallback match {
    case Some(cb) => cb(s)
    case None => util.Logging.error("Notification: " + s)
  }
}

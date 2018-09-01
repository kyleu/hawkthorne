package services.socket

import util.ExceptionHandler

object NotificationService {
  private[this] var logCallback: Option[String => Unit] = None
  private[this] var errCallback: Option[String => Unit] = None

  def register(log: String => Unit, err: String => Unit) = {
    logCallback.foreach(_ => throw new IllegalStateException("Double init"))
    logCallback = Some(log)
    errCallback = Some(err)
    ExceptionHandler.addHandler((msg, _) => err("Script Error: " + msg))
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

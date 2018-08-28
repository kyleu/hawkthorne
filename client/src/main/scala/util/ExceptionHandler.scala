package util

import org.scalajs.dom

object ExceptionHandler {
  private[this] def onError(msg: String, url: String, line: Int, col: Int) = {
    util.Logging.error(s"Unhandled error [$msg] at line [$line:$col] of url [$url]")
    true
  }

  def install() = {
    dom.window.addEventListener("error", (e: dom.ErrorEvent) => {
      onError(e.message, e.filename, e.lineno, e.colno)
      util.Logging.logJs(e)
      e.preventDefault
    })
  }
}

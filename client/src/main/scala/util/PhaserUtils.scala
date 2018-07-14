package util

import com.definitelyscala.phaserce.Signal

import scala.scalajs.js

object PhaserUtils {
  def addToSignal(signal: Signal, x: () => Unit) = signal.add(x, 0, 1.0)

  def expose(x: js.Any) = {
    util.Logging.info("Exposing model as [window.obj].")
    util.Logging.logJs(x)
    js.Dynamic.global.obj = x
  }

  def textStyle(fontSize: Int = 32, fill: String = "fff") = js.Dynamic.literal(font = fontSize + "px Roboto", fill = s"#$fill")
}

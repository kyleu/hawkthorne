package util

import com.definitelyscala.phaserce.{PhaserTextStyle, Signal}

import scala.scalajs.js

object PhaserUtils {
  //private[this] val font = """Consolas, "Andale Mono WT", "Andale Mono", "Lucida Console", "Lucida Sans Typewriter", "DejaVu Sans Mono", "Bitstream Vera Sans Mono", "Liberation Mono", "Nimbus Mono L", Monaco, "Courier New", Courier, monospace"""
  private[this] val font = """Arial bold"""

  def addToSignal(signal: Signal, x: () => Unit) = signal.add(x, 0, 1.0)

  def expose(x: js.Any) = {
    util.Logging.info("Exposing model as [window.obj].")
    util.Logging.logJs(x)
    js.Dynamic.global.obj = x
  }

  def textStyle(fontSize: Int = 32, fill: String = "fff") = {
    js.Dynamic.literal(font = s"${fontSize}px $font", fill = s"#$fill").asInstanceOf[PhaserTextStyle]
  }
}

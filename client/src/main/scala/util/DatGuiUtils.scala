package util

import com.definitelyscala.datgui.GUI

import scala.scalajs.js

object DatGuiUtils {
  def addChoices(gui: GUI, title: String, defaultVal: String, opts: Seq[String], onSelect: String => Unit) = {
    val opt = gui.add(js.Dynamic.literal(title -> defaultVal), title, items = js.Array(opts: _*))
    opt.asInstanceOf[js.Dynamic].__onFinishChange = (v: js.Any) => onSelect(v.toString)
  }

  def addFunction(gui: GUI, title: String, f: () => Unit) = gui.add(js.Dynamic.literal(title -> f), title)
}

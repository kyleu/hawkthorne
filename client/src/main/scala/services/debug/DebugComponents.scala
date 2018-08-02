package services.debug

import com.definitelyscala.datgui.GUI
import models.component._
import util.DatGuiUtils

object DebugComponents {
  @scala.annotation.tailrec
  def addFolder(root: GUI, name: String, depth: Int = 0): GUI = try {
    root.addFolder(depth match {
      case 0 => name
      case _ => name + "[" + depth + "]"
    })
  } catch {
    case _: Throwable => addFolder(root, name, depth + 1)
  }

  def add(root: GUI, c: BaseComponent) = try {
    val f = addFolder(root, c.name)
    f.add(c, "visible")
    DatGuiUtils.addFunction(gui = f, title = "Debug", f = () => util.Logging.info(c.toString))
  } catch {
    case t: Throwable => throw new IllegalStateException(s"Error creating components for [${c.name}].", t)
  }

  def toggleDebug(components: Seq[BaseComponent]) = components.foreach(_.visible = true)
}

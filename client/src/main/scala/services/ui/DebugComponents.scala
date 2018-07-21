package services.ui

import com.definitelyscala.datgui.GUI
import models.component._
import util.DatGuiUtils

object DebugComponents {
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
    c match {
      case as: AnimatedSprite => f.add(as.sprite, "visible")
      case cl: ConsoleLog => f.add(cl.group, "visible")
      case ho: HudOverlay => f.add(ho.group, "visible")
      case lc: LiquidComponent => // TODO
      case si: StaticImage => f.add(si.image, "visible")
      case ss: StaticSprite => f.add(ss.sprite, "visible")
    }
    DatGuiUtils.addFunction(gui = f, title = "Debug", f = () => util.Logging.info(c.toString))
  } catch {
    case t: Throwable => throw new IllegalStateException(s"Error creating components for [${c.name}].", t)
  }
}

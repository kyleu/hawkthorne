package services.debug

import com.definitelyscala.datgui.GUI
import com.definitelyscala.phaserce.{Camera, World}
import util.DatGuiUtils

object DebugPhaser {
  def addPoint(gui: GUI, o: AnyRef) = {
    gui.add(o, "x", 0.0, 10000).listen()
    gui.add(o, "y", 0.0, 10000).listen()
  }

  def addRect(gui: GUI, o: AnyRef) = {
    addPoint(gui, o)
    gui.add(o, "width", 0.0, 4096.0).listen()
    gui.add(o, "height", 0.0, 4096.0).listen()
  }

  def addWorld(gui: GUI, world: World) = {
    val cw = gui.addFolder("World")
    DatGuiUtils.addFunction(cw, "Scale", () => util.Logging.info("World Scale: " + world.scale))
    DatGuiUtils.addFunction(cw, "Bounds", () => util.Logging.info("World Bounds: " + world.bounds))
  }

  def addCamera(gui: GUI, camera: Camera) = {
    val cf = gui.addFolder("Camera")
    addRect(cf, camera)
    addPoint(cf.addFolder("Scale"), camera.scale)
    addRect(cf.addFolder("Bounds"), camera.bounds)
  }
}

package services.map

import com.definitelyscala.phaserce.{Game, Group, Point, Sprite}
import models.input.MenuAction
import util.PhaserUtils

case class OverworldMap(game: Game, initialZone: String) {
  private[this] val dimensions = 2328 -> (1344 + 200)
  private[this] val size = 600.0
  private[this] var zoom = 1.0

  val group = new Group(game, name = "overworld")

  val backdrop = PhaserUtils.makeBackdrop(game = game, width = dimensions._1.toDouble, height = dimensions._2.toDouble, color = OverworldMapAssets.bgColor)
  group.add(backdrop)

  private[this] def onChange(z: OverworldZones.Zone) = {
    util.Logging.info("New Zone: " + z.name)
  }

  val staticComponents = new OverworldStaticComponents(game, group)
  val movement = new OverworldMovement(game, group, initialZone, onChange)
  staticComponents.addOverlays()

  def menuAct(a: MenuAction) = a match {
    case _ => movement.onInput(a)
  }

  def update(dt: Double) = {
    staticComponents.update(dt)
    movement.update(dt, zoom)
  }

  def resize(width: Int, height: Int) = {
    zoom = Math.min(width / size, height / size)
    group.scale = new Point(zoom, zoom)
    movement.resize(zoom)
  }
}

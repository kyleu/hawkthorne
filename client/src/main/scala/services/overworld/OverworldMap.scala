package services.overworld

import com.definitelyscala.phaserce.{Game, Group, Point, TileSprite}
import models.input.MenuAction
import models.player.Player

case class OverworldMap(game: Game, player: Player, initialZone: String) {
  private[this] val padding = 200.0
  private[this] val dimensions = (2328.0 + padding) -> (1344.0 + padding)
  private[this] val size = 600.0
  private[this] var zoom = 1.0
  private[this] var elapsed = 0.0

  val group = new Group(game, name = "overworld")

  val background = new TileSprite(game = game, x = 0, y = 0, width = dimensions._1, height = dimensions._2, key = "overworld.water")
  group.add(background)

  val staticComponents = new OverworldStaticComponents(game, group)
  val movement = new OverworldMovement(game, group, player, initialZone, dimensions._1, dimensions._2)
  staticComponents.addOverlays()

  val clouds = (0 until 15).map(idx => OverworldCloud(idx, group, dimensions))

  def menuAct(a: MenuAction) = a match {
    case _ => movement.onInput(a)
  }

  def update(dt: Double) = {
    elapsed = elapsed + dt
    val mod = (elapsed * 1000).toInt % 1000
    background.frame = if (mod > 500) { 0 } else { 1 }
    clouds.foreach(_.update(dt))
    staticComponents.update(dt)
    movement.update(dt, zoom)
  }

  def resize(width: Int, height: Int) = {
    zoom = Math.min(width / size, height / size)
    group.scale = new Point(zoom, zoom)
    movement.resize(zoom)
  }
}

package services.map

import com.definitelyscala.phaserce.{Game, Group, Point, Sprite}
import models.component.StaticSprite
import models.input.MenuAction

class OverworldMovement(game: Game, group: Group, initialZone: String, onChange: OverworldZones.Zone => Unit) {
  private[this] var currentZone: OverworldZones.Zone = OverworldZones.byKey(initialZone)
  private[this] var targetZone: Option[OverworldZones.Zone] = None
  private[this] val maxSpeed = 4.0

  val player = StaticSprite(game, group, s"overworld.player", s"overworld.flag")
  player.setPositionInt(currentZone.x, currentZone.y)

  val titleboard = new Sprite(game, 0, 0, "overworld.titleboard")
  titleboard.name = "overworld.titleboard"
  game.stage.add(titleboard)

  def onInput(a: MenuAction) = if (targetZone.isEmpty) {
    val tgt = a match {
      case MenuAction.Up => currentZone.up
      case MenuAction.Right => currentZone.right
      case MenuAction.Down => currentZone.down
      case MenuAction.Left => currentZone.left
      case _ => None
    }
    tgt.foreach { t =>
      util.Logging.info(s"Moving [${a.value}] from [${currentZone.key}] to [$t].")
      targetZone = Some(OverworldZones.byKey(t))
    }
  }

  def update(dt: Double, zoom: Double) = {
    targetZone.foreach { z =>
      val xDelta = Math.max(-maxSpeed, Math.min(maxSpeed, z.x - player.x))
      val yDelta = Math.max(-maxSpeed, Math.min(maxSpeed, z.y - player.y))
      util.Logging.info(s"Target [${z.key}], xDelta [$xDelta], yDelta [$yDelta]")

      val dir = if (xDelta < 0) { "left" } else if (xDelta > 0) { "right" } else if (yDelta < 0) { "up" } else if (yDelta > 0) { "down" } else { "none" }
      util.Logging.info(dir)

      player.x = if (xDelta > 0) {
        if (player.x + xDelta > z.x) { z.x.toDouble } else { player.x + xDelta }
      } else if (xDelta < 0) {
        if (player.x + xDelta < z.x) { z.x.toDouble } else { player.x + xDelta }
      } else {
        player.x
      }

      player.y = if (yDelta > 0) {
        if (player.y + yDelta > z.y) { z.y.toDouble } else { player.y + yDelta }
      } else if (yDelta < 0) {
        if (player.y + yDelta < z.y) { z.y.toDouble } else { player.y + yDelta }
      } else {
        player.y
      }

      if (player.x == z.x && player.y == z.y) {
        z.bypass.find(_._1 == dir) match {
          case Some(bypassTarget) =>
            val tgt = z.tgtForDir(bypassTarget._2).getOrElse(throw new IllegalStateException(s"Zone [${z.key}] has no target in direction [$dir]."))
            targetZone = Some(OverworldZones.byKey(tgt))
            currentZone = z
          case None =>
            targetZone = None
            currentZone = z
            onChange(z)
        }
      }
    }

    val target = new Point((player.x * zoom) - (game.width / 2), (player.y * zoom) - (game.height / 2))
    val newPos = new Point(-target.x.toInt.toDouble, -target.y.toInt.toDouble) // TODO clamp
    group.position = newPos
  }

  def resize(zoom: Double) = {
    titleboard.scale = new Point(zoom, zoom)
    titleboard.position = new Point((game.width - titleboard.width) / 2, game.height - (titleboard.height * 1.5))
  }
}

package services.overworld

import com.definitelyscala.phaserce.{Game, Group, Point}
import models.input.MenuAction
import models.player.Player

class OverworldMovement(game: Game, group: Group, player: Player, initialZone: String, width: Double, height: Double) {
  private[this] var currentZone: OverworldZones.Zone = OverworldZones.byKey(initialZone)
  private[this] var targetZone: Option[OverworldZones.Zone] = None

  private[this] val overworldPlayer = new OverworldPlayer(game, group, player, currentZone)

  private[this] val titleboard = new OverworldTitleboard(game)
  titleboard.setText(currentZone.name)

  private[this] def setTargetZone(x: Option[OverworldZones.Zone]) = x match {
    case None =>
      util.Logging.debug(s"Completed movement to [${currentZone.key}].")
      targetZone = None
      overworldPlayer.stop()
    case Some(zone) =>
      util.Logging.debug(s"Moving from [${currentZone.key}] to [${zone.key}].")
      targetZone = Some(zone)
      overworldPlayer.start()
  }

  def onInput(a: MenuAction) = if (targetZone.isEmpty) {
    val tgt = a match {
      case MenuAction.Up => currentZone.up
      case MenuAction.Right => currentZone.right
      case MenuAction.Down => currentZone.down
      case MenuAction.Left => currentZone.left
      case _ => None
    }
    tgt.foreach { t =>
      setTargetZone(Some(OverworldZones.byKey(t)))
    }
  }

  private[this] var (lastX, lastY) = 0 -> 0

  def update(dt: Double, zoom: Double) = {
    targetZone.foreach(z => overworldPlayer.updateLocation(z) match {
      case Right(_) => // Noop
      case Left(x) => x match {
        case Some(bypassTarget) =>
          val tgt = z.tgtForDir(bypassTarget).getOrElse(throw new IllegalStateException(s"Zone [${z.key}] has no target."))
          setTargetZone(Some(OverworldZones.byKey(tgt)))
          currentZone = z
        case None =>
          setTargetZone(None)
          currentZone = z
          overworldPlayer.stop()
          titleboard.setText(z.name)
      }
    })

    overworldPlayer.update(dt, zoom)

    val target = new Point((overworldPlayer.sprite.x * zoom) - (game.width / 2), (overworldPlayer.sprite.y * zoom) - (game.height / 2))
    val (newX, newY) = (target.x.toInt.toDouble, target.y.toInt.toDouble)

    val maxX = 1000000.0 // TODO Arrgh
    val maxY = 1000000.0 // TODO Arrgh

    val clampedX = Math.max(0.0, Math.min(maxX, newX)).toInt
    val clampedY = Math.max(0.0, Math.min(maxY, newY)).toInt
    if (clampedX != lastX || clampedY != lastY) {
      util.Logging.info(s"zoom: [$zoom] clamped: [$clampedX, $clampedY] max: [$maxX, $maxY] game: [${game.width}, ${game.height}]")
      lastX = clampedX
      lastY = clampedY
      group.position = new Point(-clampedX.toDouble, -clampedY.toDouble)
    }
  }

  def resize(zoom: Double) = titleboard.resize(zoom)
}

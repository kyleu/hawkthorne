package services.overworld

import com.definitelyscala.phaserce.{Game, Group, Point}
import models.input.MenuAction
import models.player.Player
import services.camera.PositionHelper

class OverworldMovement(game: Game, group: Group, player: Player, initialZone: String, width: Double, height: Double) {
  private[this] var currentZone: OverworldZones.Zone = OverworldZones.byKey(initialZone)
  private[this] var targetZone: Option[OverworldZones.Zone] = None

  private[this] val overworldPlayer = new OverworldPlayer(game, group, player, currentZone)
  private[this] val positionHelper = new PositionHelper(game)

  val titleboard = new OverworldTitleboard(game)
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

    positionHelper.newCameraOffset(dt, zoom, overworldPlayer.sprite.x + 18, overworldPlayer.sprite.y + 18).foreach(p => group.position = p)
  }
}

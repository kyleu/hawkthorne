package services.map

import com.definitelyscala.phaserce.{Game, Group, Point}
import models.animation.Animation
import models.component.AnimatedSprite
import models.input.MenuAction
import models.player.Player

class OverworldMovement(game: Game, group: Group, player: Player, initialZone: String) {
  private[this] var currentZone: OverworldZones.Zone = OverworldZones.byKey(initialZone)
  private[this] var targetZone: Option[OverworldZones.Zone] = None
  private[this] val maxSpeed = 4.0

  private[this] val initialFrame = 0
  private[this] var (playerX, playerY) = (currentZone.x.toDouble, currentZone.y.toDouble)
  private[this] val (playerXOffset, playerYOffset) = (-17, 4)

  private[this] val playerSprite = {
    val anim = Animation(id = "overworld.walk", frames = IndexedSeq(1, 0, 2, 0), delay = 0.2, loop = true).newCopy
    AnimatedSprite.single(game, group, s"overworld.player", s"overworld.player.${player.templateKey}", animation = anim)
  }
  playerSprite.setAnimation(None)
  playerSprite.setPosition(playerX + playerXOffset, playerY + playerYOffset)

  private[this] val titleboard = new OverworldTitleboard(game)
  titleboard.setText(currentZone.name)

  private[this] def setTargetZone(x: Option[OverworldZones.Zone]) = x match {
    case None =>
      util.Logging.debug(s"Completed movement to [${currentZone.key}].")
      targetZone = None
      playerSprite.setAnimation(None)
      playerSprite.sprite.frame = initialFrame
    case Some(zone) =>
      util.Logging.debug(s"Moving from [${currentZone.key}] to [${zone.key}].")
      targetZone = Some(zone)
      playerSprite.setAnimation(Some("overworld.walk"))
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
    targetZone.foreach { z =>
      val xDelta = Math.max(-maxSpeed, Math.min(maxSpeed, z.x - playerX))
      val yDelta = Math.max(-maxSpeed, Math.min(maxSpeed, z.y - playerY))

      val dir = if (xDelta < 0) { "left" } else if (xDelta > 0) { "right" } else if (yDelta < 0) { "up" } else if (yDelta > 0) { "down" } else { "none" }

      playerX = if (xDelta > 0) {
        if (playerX + xDelta > z.x) { z.x.toDouble } else { playerX + xDelta }
      } else if (xDelta < 0) {
        if (playerX + xDelta < z.x) { z.x.toDouble } else { playerX + xDelta }
      } else {
        playerX
      }

      playerY = if (yDelta > 0) {
        if (playerY + yDelta > z.y) { z.y.toDouble } else { playerY + yDelta }
      } else if (yDelta < 0) {
        if (playerY + yDelta < z.y) { z.y.toDouble } else { playerY + yDelta }
      } else {
        playerY
      }

      playerSprite.setPosition(playerX + playerXOffset, playerY + playerYOffset)

      if (playerX == z.x && playerY == z.y) {
        z.bypass.find(_._1 == dir) match {
          case Some(bypassTarget) =>
            val tgt = z.tgtForDir(bypassTarget._2).getOrElse(throw new IllegalStateException(s"Zone [${z.key}] has no target in direction [$dir]."))
            setTargetZone(Some(OverworldZones.byKey(tgt)))
            currentZone = z
          case None =>
            setTargetZone(None)
            currentZone = z
            playerSprite.setAnimation(None)
            titleboard.setText(z.name)
        }
      }
    }

    playerSprite.update(dt)

    val target = new Point((playerX * zoom) - (game.width / 2), (playerY * zoom) - (game.height / 2))
    val newPos = new Point(-target.x.toInt.toDouble, -target.y.toInt.toDouble) // TODO clamp
    group.position = newPos
  }

  def resize(zoom: Double) = titleboard.resize(zoom)
}

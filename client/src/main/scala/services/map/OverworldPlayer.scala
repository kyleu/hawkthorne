package services.map

import com.definitelyscala.phaserce.{Game, Group, Point}
import models.animation.Animation
import models.component.AnimatedSprite
import models.input.MenuAction
import models.player.Player

class OverworldPlayer(game: Game, group: Group, player: Player, initialZone: OverworldZones.Zone) {
  private[this] val maxSpeed = 4.0

  private[this] var (playerX, playerY) = (initialZone.x.toDouble, initialZone.y.toDouble)
  private[this] val (playerXOffset, playerYOffset) = (-17, 4)

  private[this] val spriteKey = s"overworld.player.${player.templateKey}"
  private[this] val costumeOffset = 0
  private[this] val stride = (game.cache.getFrameCount(spriteKey) / 3).toInt
  private[this] val initialFrame = 0

  val sprite = {
    val frames = IndexedSeq(stride + costumeOffset, costumeOffset, (2 * stride) + costumeOffset, costumeOffset)
    val anim = Animation(id = "overworld.walk", frames = frames, delay = 0.1, loop = true).newCopy
    AnimatedSprite.single(game = game, group = group, name = s"overworld.player", spriteKey, animation = anim)
  }
  sprite.setAnimation(None)
  sprite.setPosition(playerX + playerXOffset, playerY + playerYOffset)

  def stop() = {
    sprite.setAnimation(None)
    sprite.sprite.frame = initialFrame
  }

  def start() = sprite.setAnimation(Some("overworld.walk"))

  def updateLocation(z: OverworldZones.Zone) = {
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

    sprite.setPosition(playerX + playerXOffset, playerY + playerYOffset)

    if (playerX == z.x && playerY == z.y) {
      Left(z.bypass.find(_._1 == dir).map(_._2))
    } else {
      Right(())
    }
  }

  def update(dt: Double, zoom: Double) = {
    sprite.update(dt)
  }
}

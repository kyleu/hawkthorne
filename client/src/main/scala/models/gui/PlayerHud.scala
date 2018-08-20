package models.gui

import com.definitelyscala.phaserce.{Color, Game, Group, Math, Rectangle, Sprite}
import models.data.character.{Annie, Britta, Shirley, Troy}
import models.font.Font
import models.player.Player

case class PlayerHud(game: Game, player: Player, group: Group) {
  val idx = player.idx
  val offsetY = 64.0 * idx

  private[this] val chevron = new Sprite(game, 0, offsetY, s"hud.chevron")
  chevron.name = s"hud.$idx.chevron"
  group.add(chevron)

  private[this] val headData = game.make.bitmapData(32, 32)
  private[this] val headshotY = player.template match {
    case Annie => 12.0
    case Britta => 8.0
    case Shirley => 10.0
    case Troy => 8.0
    case _ => 2.0
  }
  headData.copyRect(player.spritesheet._1, new Rectangle(8, headshotY + 48, 32, 32), 0, 0)

  private[this] val headshot = new Sprite(game, 14, 16 + offsetY, headData)
  headshot.name = s"hud.$idx.headshot"
  group.add(headshot)

  private[this] val lens = new Sprite(game, 0, offsetY, "hud.lens")
  lens.name = s"hud.$idx.lens"
  group.add(lens)

  private[this] val energyMeter = new Sprite(game, 50, 27 + offsetY, "hud.energy")
  energyMeter.name = s"hud.$idx.energy"
  group.add(energyMeter)
  updateEnergyMeter(1.0, 0x00ff00)

  private[this] val font = Font.getFont("small", game)

  private[this] val nameText = font.render(name = "hud.name", text = player.template.name, game = game, x = 58, y = 15 + offsetY, color = Some(0x000000))
  group.add(nameText.group)

  private[this] val pointsText = font.render("hud.currency", "0", game, 67, 41 + offsetY, Some(0x000000))
  group.add(pointsText.group)

  private[this] var (energy, maxEnergy) = (-1, 0)

  def setEnergy(amt: Int, max: Int) = if (energy != amt || maxEnergy != max) {
    energy = amt
    maxEnergy = max
    val ratio = energy / maxEnergy.toDouble
    if (ratio > 1.0 || ratio < 0.0) {
      throw new IllegalStateException(s"Illegal ratio [$ratio] for [$energy / $maxEnergy]")
    }
    val color = if (ratio < 0.5) {
      Color.getColor32(alpha = 0.8, red = 255, green = (ratio * 255).floor, blue = 0)
    } else {
      Color.getColor32(alpha = 0.8, red = 0, green = (ratio * 192).floor, blue = 0)
    }
    updateEnergyMeter(ratio, color)
  }

  def debugString() = s"$idx: [${nameText.text}] - [${pointsText.text}] points, [$energy / $maxEnergy] energy"

  private[this] def updateEnergyMeter(ratio: Double, color: Double) = {
    energyMeter.cropRect = new Rectangle(50, 27, (ratio * 59).floor, 9)
    energyMeter.updateCrop()
    energyMeter.tint = color
  }
}

package models.gui

import com.definitelyscala.phaserce.{Game, Group}
import models.font.{Font, FontText}

object ConsoleLog {
  val lineHeight = 14.0
  val lifetime = 4
  val maxLines = 5
  val bottomMargin = 6
}

final case class ConsoleLog(game: Game) {

  import ConsoleLog._

  val group = new Group(game, name = "console.log")
  game.stage.add(group)
  group.visible = false

  val font = Font.getFont("arial", game)

  private[this] var elapsed = 0.0
  private[this] var nextIdx = 0
  private[this] var textGroups = Seq.empty[(Double, String, FontText)]

  def log(s: String) = {
    val textGroup = font.render(name = s"console.log.text.$nextIdx", text = s, game = game, x = 4)
    group.add(textGroup.group)
    textGroups = (elapsed, s, textGroup) +: textGroups
    textGroups.drop(maxLines).foreach(remove)
    group.visible = true
    rebalance()
    nextIdx += 1
  }

  def update(delta: Double) = if (textGroups.nonEmpty) {
    elapsed += delta
    val toRemove = textGroups.flatMap { img =>
      if (elapsed > img._1 + lifetime) {
        Some(img)
      } else {
        val progress = elapsed - img._1
        if (progress > (lifetime - 1)) {
          img._3.group.alpha = 1.0 - (progress - (lifetime - 1))
        }
        None
      }
    }
    if (toRemove.nonEmpty) {
      toRemove.foreach(remove)
      if (textGroups.isEmpty) {
        group.visible = false
      }
    }
  }

  def resize(width: Int, height: Int, zoom: Double) = {
    val newZoom = Math.max(1.0, Math.min(6.0, zoom.floor))
    group.scale.set(newZoom, newZoom)

    val yOffset = (lineHeight * maxLines) * newZoom
    group.y = height - yOffset
  }

  def debug() = {
    util.Logging.info(s"Console: [${textGroups.size}] active images.")
  }

  private[this] def remove(removal: (Double, String, FontText)) = {
    group.remove(removal._3.group)
    removal._3.group.destroy()
    textGroups = textGroups.filterNot(_ == removal)
    rebalance()
  }

  private[this] def rebalance() = textGroups.zipWithIndex.foreach { kept =>
    kept._1._3.group.y = ((maxLines - kept._2 - 1) * lineHeight) - bottomMargin
  }
}

package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.FireAlarmNode

object FireAlarmComponents {
  def apply(game: Game, group: Group, n: FireAlarmNode) = {
    val s = StaticSprite(game = game, group = group, name = n.actualName, key = "fire.alarm")
    s.setPositionInt(n.actualX, n.actualY)
    Seq(s)
  }
}

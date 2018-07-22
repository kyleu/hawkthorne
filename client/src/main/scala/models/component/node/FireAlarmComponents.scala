package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.FireAlarmNode

object FireAlarmComponents {
  def apply(game: Game, group: Group, n: FireAlarmNode) = Seq(
    StaticSprite(game = game, group = group, name = n.actualName, x = n.actualX, y = n.actualY, key = "fire.alarm")
  )
}

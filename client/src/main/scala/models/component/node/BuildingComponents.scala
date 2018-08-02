package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.BuildingNode

object BuildingComponents {
  def apply(game: Game, group: Group, n: BuildingNode) = {
    val s = StaticSprite(game = game, group = group, name = n.actualName, key = s"building.${n.actualName}")
    s.setPositionInt(n.actualX, n.actualY)
    Seq(s)
  }
}

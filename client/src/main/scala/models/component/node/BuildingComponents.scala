package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.BuildingNode

object BuildingComponents {
  def apply(game: Game, group: Group, n: BuildingNode) = Seq(
    StaticSprite(game = game, group = group, name = n.actualName, x = n.actualX, y = n.actualY, key = s"building.${n.actualName}")
  )
}

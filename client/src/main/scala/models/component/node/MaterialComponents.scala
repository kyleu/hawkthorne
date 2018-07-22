package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.MaterialNode

object MaterialComponents {
  def apply(game: Game, group: Group, n: MaterialNode) = Seq(
    StaticSprite(game = game, group = group, name = "material." + n.actualName, x = n.actualX, y = n.actualY, key = s"material.${n.actualName}")
  )
}

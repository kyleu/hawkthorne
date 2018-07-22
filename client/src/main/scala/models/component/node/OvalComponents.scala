package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.{BaseComponent, StaticSprite}
import models.node.OvalNode

object OvalComponents {
  def apply(game: Game, group: Group, n: OvalNode) = Seq(
    StaticSprite(game = game, group = group, name = n.actualName, x = n.actualX, y = n.actualY, key = "cornelius.oval")
  )
}

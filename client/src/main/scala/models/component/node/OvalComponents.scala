package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.OvalNode

object OvalComponents {
  def apply(game: Game, group: Group, n: OvalNode) = {
    val s = StaticSprite(game = game, group = group, name = "cornelius." + n.actualName, key = "cornelius.oval")
    s.setPositionInt(n.actualX, n.actualY)
    Seq(s)
  }
}

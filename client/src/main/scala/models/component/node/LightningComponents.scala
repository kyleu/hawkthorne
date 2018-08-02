package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.LightningNode

object LightningComponents {
  def apply(game: Game, group: Group, n: LightningNode) = {
    val s = StaticSprite(game = game, group = group, name = "cornelius." + n.actualName, key = "cornelius.lightning")
    s.setPositionInt(n.actualX, n.actualY)
    Seq(s)
  }
}

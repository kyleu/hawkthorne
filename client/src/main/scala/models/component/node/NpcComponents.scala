package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.AnimatedSprite
import models.node.NpcNode

object NpcComponents {
  def apply(game: Game, group: Group, n: NpcNode) = {
    val as = AnimatedSprite(
      game = game, group = group, name = n.actualName, key = s"npc.${n.actualName}",
      animations = n.template.animationMap.mapValues(_.newCopy), defAnim = Some("default")
    )
    as.setPositionInt(n.actualX, n.actualY)
    Seq(as)
  }
}

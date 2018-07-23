package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.AnimatedSprite
import models.node.NpcNode

object NpcComponents {
  def apply(game: Game, group: Group, n: NpcNode) = Seq(
    AnimatedSprite(
      game = game, group = group, name = n.actualName, x = n.actualX, y = n.actualY, key = s"npc.${n.actualName}",
      animations = n.template.animationMap.mapValues(_.newCopy), defAnim = Some("default")
    )
  )
}

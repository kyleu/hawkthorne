package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.NpcNode

object NpcComponents {
  def apply(game: Game, group: Group, n: NpcNode) = Seq(
    StaticSprite(game = game, group = group, name = n.nameWithDefault, x = n.x, y = n.y, key = s"npc.${n.nameWithDefault}")
  )
}

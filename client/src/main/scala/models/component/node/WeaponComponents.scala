package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.WeaponNode

object WeaponComponents {
  def apply(game: Game, group: Group, n: WeaponNode) = Seq(
    StaticSprite(game = game, group = group, name = n.nameWithDefault, x = n.x, y = n.y, key = s"weapon.${n.nameWithDefault}")
  )
}

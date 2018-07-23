package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.AnimatedSprite
import models.node.WeaponNode

object WeaponComponents {
  def apply(game: Game, group: Group, n: WeaponNode) = Seq(
    AnimatedSprite(
      game = game, group = group, name = n.actualName, x = n.actualX, y = n.actualY, key = s"weapon.${n.actualName}",
      animations = n.template.animationMap.mapValues(_.newCopy), defAnim = Some("default")
    )
  )
}

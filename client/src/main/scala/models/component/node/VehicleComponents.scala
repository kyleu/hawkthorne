package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.AnimatedSprite
import models.node.VehicleNode

object VehicleComponents {
  def apply(game: Game, group: Group, n: VehicleNode) = Seq(
    AnimatedSprite(
      game = game, group = group, name = n.actualName, x = n.actualX, y = n.actualY, key = s"vehicle.${n.actualName}",
      animations = n.template.animationMap.mapValues(_.newCopy), defAnim = Some("default")
    )
  )
}

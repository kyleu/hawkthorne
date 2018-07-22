package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.VehicleNode

object VehicleComponents {
  def apply(game: Game, group: Group, n: VehicleNode) = Seq(
    StaticSprite(game = game, group = group, name = n.actualName, x = n.actualX, y = n.actualY, key = s"vehicle.${n.actualName}")
  )
}

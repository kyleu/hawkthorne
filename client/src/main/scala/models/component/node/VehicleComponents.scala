package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.VehicleNode

object VehicleComponents {
  def apply(game: Game, group: Group, n: VehicleNode) = Seq(
    StaticSprite(game = game, group = group, name = n.nameWithDefault, x = n.x, y = n.y, key = s"vehicle.${n.nameWithDefault}")
  )
}

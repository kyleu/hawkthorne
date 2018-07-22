package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.HiddenDoorTriggerNode

object HiddenDoorTriggerComponents {
  def apply(game: Game, group: Group, n: HiddenDoorTriggerNode) = Seq(
    StaticSprite(game = game, group = group, name = "hidden.door." + n.actualName, x = n.actualX, y = n.actualY, key = s"hidden.door.${n.properties.sprite}")
  )
}

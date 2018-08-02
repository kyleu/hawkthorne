package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.StaticSprite
import models.node.HiddenDoorTriggerNode

object HiddenDoorTriggerComponents {
  def apply(game: Game, group: Group, n: HiddenDoorTriggerNode) = {
    val s = StaticSprite(game = game, group = group, name = "hidden.door." + n.actualName, key = s"hidden.door.${n.properties.sprite}")
    s.setPositionInt(n.actualX, n.actualY)
    Seq(s)
  }
}

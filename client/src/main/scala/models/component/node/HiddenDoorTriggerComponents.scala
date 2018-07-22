package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.HiddenDoorTriggerNode

object HiddenDoorTriggerComponents {
  def apply(game: Game, group: Group, n: HiddenDoorTriggerNode) = Seq.empty[BaseComponent]
}

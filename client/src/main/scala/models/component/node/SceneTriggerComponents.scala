package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.SceneTriggerNode

object SceneTriggerComponents {
  def apply(game: Game, group: Group, n: SceneTriggerNode) = Seq.empty[BaseComponent]
}

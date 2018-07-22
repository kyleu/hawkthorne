package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.ConsumableNode

object ConsumableComponents {
  def apply(game: Game, group: Group, n: ConsumableNode) = Seq.empty[BaseComponent]
}

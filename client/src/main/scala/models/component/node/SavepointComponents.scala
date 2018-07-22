package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.SavepointNode

object SavepointComponents {
  def apply(game: Game, group: Group, n: SavepointNode) = Seq.empty[BaseComponent]
}

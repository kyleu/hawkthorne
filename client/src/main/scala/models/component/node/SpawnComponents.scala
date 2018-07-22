package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.SpawnNode

object SpawnComponents {
  def apply(game: Game, group: Group, n: SpawnNode) = Seq.empty[BaseComponent]
}

package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.CowNode

object CowComponents {
  def apply(game: Game, group: Group, n: CowNode) = Seq.empty[BaseComponent]
}

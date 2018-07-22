package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.CeilingNode

object CeilingComponents {
  def apply(game: Game, group: Group, n: CeilingNode) = Seq.empty[BaseComponent]
}

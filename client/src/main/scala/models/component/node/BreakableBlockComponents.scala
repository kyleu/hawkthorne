package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.BreakableBlockNode

object BreakableBlockComponents {
  def apply(game: Game, group: Group, n: BreakableBlockNode) = Seq.empty[BaseComponent]
}

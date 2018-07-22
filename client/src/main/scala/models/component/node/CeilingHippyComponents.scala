package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.CeilingHippyNode

object CeilingHippyComponents {
  def apply(game: Game, group: Group, n: CeilingHippyNode) = Seq.empty[BaseComponent]
}

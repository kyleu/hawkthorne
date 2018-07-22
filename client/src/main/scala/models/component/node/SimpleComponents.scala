package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.SimpleNode

object SimpleComponents {
  def apply(game: Game, group: Group, n: SimpleNode) = Seq.empty[BaseComponent]
}

package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.HeadNode

object HeadComponents {
  def apply(game: Game, group: Group, n: HeadNode) = Seq.empty[BaseComponent]
}

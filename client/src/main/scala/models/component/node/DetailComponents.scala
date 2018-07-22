package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.DetailNode

object DetailComponents {
  def apply(game: Game, group: Group, n: DetailNode) = Seq.empty[BaseComponent]
}

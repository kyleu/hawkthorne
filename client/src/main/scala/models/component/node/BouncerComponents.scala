package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.BouncerNode

object BouncerComponents {
  def apply(game: Game, group: Group, n: BouncerNode) = Seq.empty[BaseComponent]
}

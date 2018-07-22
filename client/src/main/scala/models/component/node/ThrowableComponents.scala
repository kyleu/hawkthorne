package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.ThrowableNode

object ThrowableComponents {
  def apply(game: Game, group: Group, n: ThrowableNode) = Seq.empty[BaseComponent]
}

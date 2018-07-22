package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.KeyNode

object KeyComponents {
  def apply(game: Game, group: Group, n: KeyNode) = Seq.empty[BaseComponent]
}

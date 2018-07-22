package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.MaterialNode

object MaterialComponents {
  def apply(game: Game, group: Group, n: MaterialNode) = Seq.empty[BaseComponent]
}

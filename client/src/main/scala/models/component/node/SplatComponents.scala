package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.SplatNode

object SplatComponents {
  def apply(game: Game, group: Group, n: SplatNode) = Seq.empty[BaseComponent]
}

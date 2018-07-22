package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.OvalNode

object OvalComponents {
  def apply(game: Game, group: Group, n: OvalNode) = Seq.empty[BaseComponent]
}

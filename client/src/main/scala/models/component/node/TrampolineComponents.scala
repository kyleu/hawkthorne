package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.TrampolineNode

object TrampolineComponents {
  def apply(game: Game, group: Group, n: TrampolineNode) = Seq.empty[BaseComponent]
}

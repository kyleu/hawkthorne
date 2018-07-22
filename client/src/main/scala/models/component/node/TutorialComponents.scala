package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.TutorialNode

object TutorialComponents {
  def apply(game: Game, group: Group, n: TutorialNode) = Seq.empty[BaseComponent]
}

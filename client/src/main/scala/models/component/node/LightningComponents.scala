package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.LightningNode

object LightningComponents {
  def apply(game: Game, group: Group, n: LightningNode) = Seq.empty[BaseComponent]
}

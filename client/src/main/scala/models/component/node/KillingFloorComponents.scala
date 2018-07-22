package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.KillingFloorNode

object KillingFloorComponents {
  def apply(game: Game, group: Group, n: KillingFloorNode) = Seq.empty[BaseComponent]
}

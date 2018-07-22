package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.SparkleNode

object SparkleComponents {
  def apply(game: Game, group: Group, n: SparkleNode) = Seq.empty[BaseComponent]
}

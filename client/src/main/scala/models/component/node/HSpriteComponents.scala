package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.HSpriteNode

object HSpriteComponents {
  def apply(game: Game, group: Group, n: HSpriteNode) = Seq.empty[BaseComponent]
}

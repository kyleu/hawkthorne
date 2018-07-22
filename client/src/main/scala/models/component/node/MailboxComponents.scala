package models.component.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.MailboxNode

object MailboxComponents {
  def apply(game: Game, group: Group, n: MailboxNode) = Seq.empty[BaseComponent]
}

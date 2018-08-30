package models.modal

import com.definitelyscala.phaserce.Game
import models.input.MenuAction
import services.input.InputService

class Dialog(game: Game, inputService: InputService) extends BaseModal(game, "dialog") {
  private[this] var remaining = Seq.empty[String]

  def show(msgs: String*) = open(() => {
    remaining = msgs
    inputService.menuHandler.setCallback(Some(acts => menuActs(acts)))
    util.Logging.info("Dialog open!")
  })

  private[this] def menuActs(acts: Seq[MenuAction]) = {
    util.Logging.info(s"Dialog input: ${acts.mkString(", ")}")
  }
}

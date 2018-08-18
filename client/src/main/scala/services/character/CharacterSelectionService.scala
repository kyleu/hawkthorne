package services.character

import com.definitelyscala.phaserce.Game
import models.gui.VerticalParticles
import models.input.{MenuAction, PointerAction}

case class CharacterSelectionService(phaser: Game, var character: String, var costume: String = "base") {
  private[this] val particles = new VerticalParticles(phaser)

  def menuActions(acts: Seq[MenuAction]) = {
    // TODO
  }

  def onPointer(pointerAction: PointerAction) = {
    // TODO
  }

  def update(delta: Double) = {
    particles.update(delta)
  }

  def resize(width: Int, height: Int) = {

  }
}

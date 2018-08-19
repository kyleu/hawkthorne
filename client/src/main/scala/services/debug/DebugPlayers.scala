package services.debug

import com.definitelyscala.datgui.GUI
import models.component.PlayerSprite
import models.input.PlayerInputHandler
import services.game.GameInstance
import util.{DatGuiUtils, Logging}

import scala.util.Random

object DebugPlayers {
  def addPlayers(gui: GUI, instance: GameInstance, players: Seq[PlayerSprite]) = players.zipWithIndex.foreach {
    case (playerSprite, idx) =>
      val f = gui.addFolder(s"Player $idx")
      val anims = PlayerSprite.animations.keys.toSeq.sorted
      DatGuiUtils.addFunction(f, "Debug", () => util.Logging.info(playerSprite.toString))
      f.add(playerSprite, "visible").listen()
      f.add(playerSprite, "x", 0.0, 10000).listen()
      f.add(playerSprite, "y", 0.0, 10000).listen()
      DatGuiUtils.addFunction(f, "Bring To Top", () => playerSprite.bringToTop())
      DatGuiUtils.addFunction(f, "Render Bounds", () => playerSprite.displayBounds(instance.boundsForPlayer(idx)))
      DatGuiUtils.addChoices(f, "Animation", "No Animation", "No Animation" +: anims, v => playerSprite.setAnimation(Some(v)))
      DatGuiUtils.addFunction(f, "Random Anim", () => {
        val anim = anims(Random.nextInt(anims.size))
        Logging.info(s"Random animation: [$anim]")
        playerSprite.setAnimation(Some(anim))
      })
  }
}

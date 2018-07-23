package services.debug

import com.definitelyscala.datgui.GUI
import models.player.PlayerSprite
import util.{DatGuiUtils, Logging}

import scala.util.Random

object DebugPlayers {
  def addPlayers(gui: GUI, players: Seq[PlayerSprite]) = players.zipWithIndex.foreach {
    case (playerSprite, idx) =>
      val f = gui.addFolder(s"Player $idx")
      val anims = PlayerSprite.animations.keys.toSeq.sorted
      f.add(playerSprite.sprite, "x", 0.0, 10000).listen()
      f.add(playerSprite.sprite, "y", 0.0, 10000).listen()
      DatGuiUtils.addChoices(f, "Animation", "No Animation", "No Animation" +: anims, v => playerSprite.setAnimation(Some(v)))
      DatGuiUtils.addFunction(f, "Random Anim", () => {
        val anim = anims(Random.nextInt(anims.size))
        Logging.info(s"Random animation: [$anim]")
        playerSprite.setAnimation(Some(anim))
      })
  }
}
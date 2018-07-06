package services.state

import com.definitelyscala.phaserce.Game
import models.data.character.Annie
import models.player.Player

class SandboxState() extends GameState("initial") {
  override def create(game: Game) = {
    val t = Annie.template
    val p = new Player(t, t.costume("base"))
    println("Sandbox started.")
  }

  override def preload(game: Game) = {
    println("Sandbox preloading...")
  }
}

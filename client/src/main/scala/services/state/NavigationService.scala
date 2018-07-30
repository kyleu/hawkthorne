package services.state

import com.definitelyscala.phaserce.Game
import models.data.map.TiledMap
import models.game.GameOptions
import models.player.Player

object NavigationService {
  def initialState(phaser: Game, path: String) = {
    path.trim match {
      case "" => GameplayState.load(phaser = phaser, options = GameOptions(map = TiledMap.BlackCaverns2, scenario = "new"), player = Player.default)
      case "intro" => IntroState.load(phaser = phaser)
      case "menu" => IntroState.load(phaser = phaser, skipToMenu = true)
      case "test" => TestState.load(phaser = phaser)
      case "sandbox" => SandboxState.load(phaser = phaser)

      case x if x.startsWith("map/") =>
        val opts = GameOptions(map = TiledMap.withValue(x.stripPrefix("map/")), scenario = "new")
        GameplayState.load(phaser, opts, Player.default)
      case x if x.startsWith("test/") => MapTestState.load(phaser = phaser, map = TiledMap.withValue(x.stripPrefix("test/")))
      case _ => throw new IllegalStateException(s"Unknown path [$path]")
    }
  }
}

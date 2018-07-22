package services.ui

import models.data.map.TiledMap
import models.game.GameOptions
import models.phaser.PhaserGame
import models.player.Player
import services.state._

object NavigationService {
  def initialState(phaser: PhaserGame, path: String) = path.trim match {
    case "" => GameplayState.load(phaser, GameOptions(map = TiledMap.BlackCaverns2, scenario = "new"), Player.default)
    case "intro" => IntroState.load(phaser)
    // case "menu" => MenuState.load(phaser)
    case "test" => TestState.load(phaser)
    case "sandbox" => SandboxState.load(phaser)
    case x if x.startsWith("map/") => GameplayState.load(phaser, GameOptions(map = TiledMap.withValue(x.stripPrefix("map/")), scenario = "new"), Player.default)
    case x if x.startsWith("test/") => MapTestState.load(phaser, TiledMap.withValue(x.stripPrefix("test/")))
    case _ => throw new IllegalStateException(s"Unknown path [$path]")
  }
}

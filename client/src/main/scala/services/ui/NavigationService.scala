package services.ui

import models.data.map.TiledMap
import models.phaser.PhaserGame
import services.state._

object NavigationService {
  def initialState(phaser: PhaserGame, path: String) = path.trim match {
    case "" => GameplayState.load(phaser)
    case "intro" => IntroScanState.load(phaser)
    case "test" => TestState.load(phaser)
    case "sandbox" => SandboxState.load(phaser)
    case x if x.startsWith("map/") => MapState.load(phaser, TiledMap.withValue(x.stripPrefix("map/")))
    case _ => throw new IllegalStateException(s"Unknown path [$path]")
  }
}

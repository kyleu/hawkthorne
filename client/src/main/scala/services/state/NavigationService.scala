package services.state

import com.definitelyscala.phaserce.Game
import models.data.map.TiledMap
import models.game.GameOptions
import models.player.Player
import org.scalajs.dom

object NavigationService {
  def stateFromPath(game: Game, path: String, debug: Boolean) = {
    path.trim match {
      case "" =>
        setPath("intro")
        IntroState.load(phaser = game, debug = debug)
      case "intro" => IntroState.load(phaser = game, debug = debug)
      case "menu" => IntroState.load(phaser = game, skipToMenu = true, debug = debug)
      case "options" => OptionsState.load(phaser = game, debug = debug)
      case "test" => TestState.load(phaser = game)
      case "sandbox" => SandboxState.load(phaser = game)

      case x if x.startsWith("test/") => MapTestState.load(phaser = game, map = TiledMap.withValue(x.stripPrefix("test/")))

      case x if x.startsWith("map/") => GameplayState.load(
        phaser = game, options = GameOptions(map = TiledMap.withValue(x.stripPrefix("map/")), scenario = "new"), player = Player.default
      )

      case _ => throw new IllegalStateException(s"Unknown path [$path]")
    }
  }

  def setPath(path: String) = if (!dom.window.location.pathname.endsWith(path)) {
    dom.window.history.replaceState(statedata = 0, title = path, url = s"/play/$path")
  }

  def init(game: Game, path: String, debug: Boolean) = {
    val nextState = stateFromPath(game, path, debug)
    val is = new InitialGameState(nextState = nextState, phaser = game, debug = debug)
    game.state.add("initial", is)
    game.state.start(is.key, clearWorld = true, clearCache = false)
  }

  def navigateTo(game: Game, path: String, debug: Boolean) = {
    val nextState = stateFromPath(game, path, debug)
    game.state.add(nextState.key, nextState)
    setPath(path)
    game.state.start(nextState.key, clearWorld = true, clearCache = false)
  }
}

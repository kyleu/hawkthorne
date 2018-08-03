package services.state

import com.definitelyscala.phaserce.Game
import models.data.map.TiledMap
import models.game.GameOptions
import models.player.Player
import org.scalajs.dom
import services.game.GameplayState
import services.input.InputService
import services.intro.{IntroState, PortalState}
import services.options.OptionsState
import services.test.{SandboxState, TestState}

object NavigationService {
  def stateFromPath(game: Game, input: InputService, path: String, debug: Boolean) = {
    path.trim match {
      case "" =>
        setPath("intro")
        IntroState.load(phaser = game, input = input, debug = debug)
      case "intro" => IntroState.load(phaser = game, input = input, debug = debug)
      case "menu" => IntroState.load(phaser = game, input = input, skipToMenu = true, debug = debug)
      case "options" => OptionsState.load(phaser = game, inputService = input, debug = debug)
      case "portal" => PortalState.load(phaser = game, inputService = input, debug = debug)
      case "test" => TestState.load(phaser = game)
      case "sandbox" => SandboxState.load(phaser = game)

      case x if x.startsWith("map/") => GameplayState.load(
        phaser = game, input = input, options = GameOptions(map = TiledMap.withValue(x.stripPrefix("map/"))), player = Player.default
      )

      case _ => throw new IllegalStateException(s"Unknown path [$path]")
    }
  }

  def setPath(path: String) = if (!dom.window.location.pathname.endsWith(path)) {
    dom.window.history.replaceState(statedata = 0, title = path, url = s"/play/$path")
  }

  def init(game: Game, path: String, debug: Boolean) = {
    def nextState(input: InputService) = stateFromPath(game = game, input = input, path = path, debug = debug)
    val is = new InitialGameState(nextState = nextState, phaser = game, debug = debug)
    game.state.add("initial", is)
    game.state.start(is.key, clearWorld = true, clearCache = false)
  }

  def navigateTo(game: Game, input: InputService, path: String, debug: Boolean) = {
    val nextState = stateFromPath(game = game, input = input, path = path, debug = debug)
    game.state.add(nextState.key, nextState)
    setPath(path)
    game.state.start(nextState.key, clearWorld = true, clearCache = false)
  }
}

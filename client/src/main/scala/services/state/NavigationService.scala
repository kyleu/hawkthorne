package services.state

import java.util.UUID

import com.definitelyscala.phaserce.Game
import models.data.map.TiledMap
import models.options.GameOptions
import models.player.Player
import org.scalajs.dom
import services.character.CharacterSelectionState
import services.game.GameplayState
import services.input.InputService
import services.intro.{IntroState, PortalState}
import services.options.OptionsState
import services.overworld.OverworldMapState
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
      case "character" => CharacterSelectionState.load(phaser = game, input = input, debug = debug)
      case "portal" => PortalState.load(phaser = game, inputService = input, debug = debug)
      case "test" => TestState.load(phaser = game)
      case "sandbox" => SandboxState.load(phaser = game)

      case "overworld" => OverworldMapState.load(
        phaser = game,
        inputService = input,
        player = Player.random(id = UUID.randomUUID /* TODO */ , idx = 0),
        debug = debug
      )
      case x if x.startsWith("map/") => GameplayState.load(
        phaser = game,
        input = input,
        options = GameOptions(map = TiledMap.withValue(x.stripPrefix("map/")), debug = debug),
        player = Player.random(id = UUID.randomUUID /* TODO */ , idx = 0)
      )

      case "multiplayer" =>
        util.Logging.info("TODO: Multiplayer")
        TestState.load(phaser = game)
      case "credits" =>
        util.Logging.info("TODO: Credits")
        TestState.load(phaser = game)
      case "help" =>
        util.Logging.info("TODO: Help")
        TestState.load(phaser = game)

      case _ =>
        dom.window.location.href = "/"
        throw new IllegalStateException(s"Unknown path [$path]")
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

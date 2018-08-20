package services.navigation

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
import services.matchmaking.MatchmakingState
import services.options.OptionsState
import services.overworld.OverworldMapState
import services.state.NavigationService.setPath
import services.test.{SandboxState, TestState}

object NavigationPaths {
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

      case "multiplayer/list" => MatchmakingState.load(phaser = game, inputService = input, debug = debug)
      case "multiplayer/host" => MatchmakingState.load(phaser = game, inputService = input, debug = debug, skipToHost = true)
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
}

package services.navigation

import com.definitelyscala.phaserce.Game
import models.data.map.TiledMap
import models.options.GameOptions
import models.settings.ActivePlayers
import services.character.CharacterSelectionState
import services.game.GameplayState
import services.input.InputService
import services.intro.{IntroState, PortalState}
import services.matchmaking.MatchmakingState
import services.options.OptionsState
import services.overworld.OverworldMapState
import services.state.NavigationService.setPath
import services.state.{CreditsState, GameState, HelpState}
import services.test.{SandboxState, TestState}

object NavigationPaths {
  def stateFromPath(game: Game, input: InputService, path: String, debug: Boolean) = {
    path.trim match {
      case "intro" => IntroState.load(phaser = game, input = input, debug = debug)
      case "menu" => IntroState.load(phaser = game, input = input, skipToMenu = true, debug = debug)
      case "options" => OptionsState.load(phaser = game, inputService = input, debug = debug)
      case "character" => CharacterSelectionState.load(phaser = game, input = input, debug = debug)
      case "portal" => PortalState.load(phaser = game, inputService = input, debug = debug)
      case "test" => TestState.load(phaser = game, inputService = input)
      case "sandbox" => SandboxState.load(phaser = game)

      case "overworld" => OverworldMapState.load(
        phaser = game,
        inputService = input,
        player = ActivePlayers.getPlayers.head,
        debug = debug
      )
      case x if x.startsWith("map/") => newGameState(
        game = game,
        input = input,
        options = GameOptions(map = TiledMap.withValue(x.stripPrefix("map/")), debug = debug)
      )
      case "multiplayer/list" => MatchmakingState.load(phaser = game, inputService = input, debug = debug)
      case "multiplayer/host" => MatchmakingState.load(phaser = game, inputService = input, debug = debug)
      case "credits" => CreditsState.load(phaser = game, inputService = input, debug = debug)
      case "help" => HelpState.load(phaser = game, inputService = input, debug = debug)

      case _ =>
        setPath("intro")
        IntroState.load(phaser = game, input = input, debug = debug)
    }
  }

  def newGameState(
    game: Game,
    input: InputService,
    options: GameOptions
  ): GameState = GameplayState.load(phaser = game, input = input, options = options, players = ActivePlayers.getPlayers)
}

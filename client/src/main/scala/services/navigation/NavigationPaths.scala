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
import services.state.{CreditsState, HelpState}
import services.test.{SandboxState, TestState}

object NavigationPaths {
  def titleForPath(path: String) = path match {
    case "intro" => "Introduction"
    case "menu" => "Main Menu"
    case "options" => "Options"
    case "character" => "Select Your Character"
    case "portal" => "Portal"
    case "test" => "Test"
    case "sandbox" => "Sandbox Test"
    case "overworld" => "Overworld"
    case x if x.startsWith("map/") => TiledMap.withValue(x.stripPrefix("map/")).title
    case "multiplayer/list" => "Multiplayer Games"
    case "multiplayer/host" => "Host Multiplayer Game"
    case "credits" => "Credits"
    case "help" => "Help"
    case x => x
  }

  def stateFromPath(game: Game, input: InputService, path: String, debug: Boolean) = {
    path.trim match {
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
        player = Player.random(id = UUID.randomUUID, idx = 0),
        debug = debug
      )
      case x if x.startsWith("map/") => newGameState(game, input, GameOptions(map = TiledMap.withValue(x.stripPrefix("map/")), debug = debug))
      case "multiplayer/list" => MatchmakingState.load(phaser = game, inputService = input, debug = debug)
      case "multiplayer/host" => MatchmakingState.load(phaser = game, inputService = input, debug = debug, skipToHost = true)
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
    options: GameOptions,
    initialPlayers: IndexedSeq[Player] = IndexedSeq(Player.random(id = UUID.randomUUID, idx = 0))
  ) = GameplayState.load(phaser = game, input = input, options = options, players = initialPlayers)
}

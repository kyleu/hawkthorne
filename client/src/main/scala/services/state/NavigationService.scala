package services.state

import java.util.UUID

import com.definitelyscala.phaserce.Game
import models.player.Player
import models.settings.ActivePlayers
import org.scalajs.dom
import services.input.InputService
import services.navigation.{NavigationPaths, NavigationTitles}
import util.Version

object NavigationService {
  def setPath(path: String) = {
    dom.document.title = s"${NavigationTitles.titleForPath(path)} - ${Version.projectName}"
    if (!dom.window.location.pathname.endsWith(path)) {
      dom.window.history.replaceState(statedata = 0, title = path, url = s"/play/$path")
    }
  }

  def init(game: Game, path: String, debug: Boolean) = {
    ActivePlayers.setPlayers(IndexedSeq(Player.random(id = UUID.randomUUID, idx = 0)))
    def nextState(input: InputService) = NavigationPaths.stateFromPath(game = game, input = input, path = path, debug = debug)
    val is = new InitialGameState(nextState = nextState, phaser = game, debug = debug)
    game.state.add("initial", is)
    game.state.start(is.key, clearWorld = true, clearCache = false)
  }

  def navigateToPath(game: Game, input: InputService, path: String, debug: Boolean) = {
    val nextState = NavigationPaths.stateFromPath(game = game, input = input, path = path, debug = debug)
    setPath(path)
    navigateTo(game, nextState)
  }

  def navigateTo(game: Game, nextState: GameState, path: Option[String] = None) = {
    path.foreach(setPath)
    game.state.add(nextState.key, nextState)
    game.state.start(nextState.key, clearWorld = true, clearCache = false)
  }
}

package services.state

import com.definitelyscala.phaserce.Game
import org.scalajs.dom
import services.input.InputService
import services.navigation.NavigationPaths
import util.Version

object NavigationService {
  def setPath(path: String) = {
    dom.document.title = s"${NavigationPaths.titleForPath(path)} - ${Version.projectName}"
    if (!dom.window.location.pathname.endsWith(path)) {
      dom.window.history.replaceState(statedata = 0, title = path, url = s"/play/$path")
    }
  }

  def init(game: Game, path: String, debug: Boolean) = {
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

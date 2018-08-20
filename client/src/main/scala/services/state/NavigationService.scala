package services.state

import com.definitelyscala.phaserce.Game
import org.scalajs.dom
import services.input.InputService
import services.navigation.NavigationPaths

object NavigationService {
  def setPath(path: String) = if (!dom.window.location.pathname.endsWith(path)) {
    dom.window.history.replaceState(statedata = 0, title = path, url = s"/play/$path")
  }

  def init(game: Game, path: String, debug: Boolean) = {
    def nextState(input: InputService) = NavigationPaths.stateFromPath(game = game, input = input, path = path, debug = debug)
    val is = new InitialGameState(nextState = nextState, phaser = game, debug = debug)
    game.state.add("initial", is)
    game.state.start(is.key, clearWorld = true, clearCache = false)
  }

  def navigateTo(game: Game, input: InputService, path: String, debug: Boolean) = {
    val nextState = NavigationPaths.stateFromPath(game = game, input = input, path = path, debug = debug)
    game.state.add(nextState.key, nextState)
    setPath(path)
    game.state.start(nextState.key, clearWorld = true, clearCache = false)
  }

  def newMap(dest: String) = dest.split(':').toList match {
    case level :: door :: Nil => println(s"Headed to [$level :: $door]...")
    case _ => throw new IllegalStateException(s"Invalid destination [$dest]")
  }
}

package services.node

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.Node
import services.state.LoadingState
import util.PhaserUtils

class NodeLoader(game: Game, group: Group) {
  def load(
    nodes: Seq[Node],
    onFileComplete: (Int, Int) => Unit = (_, _) => (),
    onComplete: Seq[BaseComponent] => Unit = _ => ()
  ) = {
    val startNanos = System.nanoTime

    val assets = nodes.flatMap(_.assets).distinct
    assets.foreach(LoadingState.load(_, game))

    var filesCompleted = 0

    PhaserUtils.addToSignal(game.load.onFileComplete, _ => {
      filesCompleted += 1
      onFileComplete(filesCompleted, assets.size)
    })

    PhaserUtils.addToSignal(game.load.onLoadComplete, _ => {
      game.load.onFileComplete.removeAll()
      game.load.onLoadComplete.removeAll()

      val components = ComponentLoadService.fromNodes(nodes, game, group)

      val msg = s"Loaded [${components.size}] components from [${assets.size}] assets in [${((System.nanoTime - startNanos) / 1000000).toString.take(8)}ms]."
      util.Logging.info(msg)
      onComplete(components)
    })
    game.load.start()
  }
}

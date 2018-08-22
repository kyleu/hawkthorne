package services.node

import com.definitelyscala.phaserce.{Game, Group, Sprite}
import models.asset.Asset
import models.component.BaseComponent
import models.node.Node
import services.state.LoadingState
import util.PhaserUtils

class NodeLoader(game: Game, group: Group, progress: Sprite) {
  def load(nodes: Seq[Node], onFileComplete: (Int, Int) => Unit = (_, _) => (), onComplete: Seq[BaseComponent] => Unit = _ => ()) = {
    val startNanos = System.nanoTime

    val assets = nodes.flatMap(_.assets).distinct
    val loaders = assets.flatMap(LoadingState.load(_, game))

    if (loaders.isEmpty) {
      stuff(nodes, assets, onComplete, startNanos)
    } else {
      var filesCompleted = 0

      PhaserUtils.addToSignal(game.load.onFileComplete, _ => {
        filesCompleted += 1
        onFileComplete(filesCompleted, assets.size)
        progress.frame = ((filesCompleted / assets.size.toDouble) * 17).toInt
      })

      PhaserUtils.addToSignal(game.load.onLoadComplete, _ => {
        progress.frame = 16
        game.load.onFileComplete.removeAll()
        game.load.onLoadComplete.removeAll()
        stuff(nodes, assets, onComplete, startNanos)
      })
      game.load.start()

    }
  }

  private[this] def stuff(nodes: Seq[Node], assets: Seq[Asset], onComplete: Seq[BaseComponent] => Unit, startNanos: Long) = {
    val components = ComponentLoadService.fromNodes(nodes, game, group)
    def msg = s"Loaded [${components.size}] components from [${assets.size}] assets in [${((System.nanoTime - startNanos) / 1000000).toString.take(8)}ms]."
    util.Logging.debug(msg)
    onComplete(components)
  }
}

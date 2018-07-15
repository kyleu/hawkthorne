package models.phaser

import com.definitelyscala.phaserce.{Game, Group}
import models.component.BaseComponent
import models.node.Node
import util.PhaserUtils

class NodeLoader(game: Game, group: Group) {
  def load(
    nodes: Seq[Node],
    onFileComplete: (Int, Int) => Unit = (_, _) => (),
    onComplete: Seq[BaseComponent] => Unit = _ => ()
  ) = {
    val startNanos = System.nanoTime

    val assets = nodes.flatMap(_.assets)

    var filesCompleted = 0

    val fileSignal = PhaserUtils.addToSignal(game.load.onFileComplete, () => {
      filesCompleted += 1
      onFileComplete(filesCompleted, assets.size)
    })

    PhaserUtils.addToSignal(game.load.onLoadComplete, () => {
      game.load.onFileComplete.removeAll()
      game.load.onLoadComplete.removeAll()

      val components = ComponentLoadService.fromNodes(nodes, game, group)

      println(s"Loaded [${components.size}] components from [${assets.size}] assets in [${((System.nanoTime - startNanos) / 1000000).toString.take(8)}ms].")
      onComplete(components)
    })
    game.load.start()
  }
}

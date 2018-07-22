package services.game

import models.game.GameOptions
import models.node.{DoorNode, Node}
import models.player.Player
import util.Point

object GameInstanceFactory {
  def create(options: GameOptions, initialNodes: Seq[Node], initialPlayers: Seq[Player], log: String => Unit, notify: String => Unit) = {
    val spawn = initialNodes.collectFirst { case n: DoorNode if n.name == "main" => n }.map { d =>
      Point(d.x.toInt + (d.width / 2), d.y.toInt + (d.height / 2))
    }.getOrElse(throw new IllegalStateException("No spawn point detected."))

    val initialObjects = initialNodes.map(_.asNewGameObject)

    var lastId = initialNodes.map(_.id).max + 1
    def nextId() = {
      lastId += 1
      lastId
    }

    val playerObjects = initialPlayers.zipWithIndex.map(p => p._1.asNewGameObject(nextId(), p._2, spawn))

    val finalObjects = (initialObjects ++ playerObjects).toIndexedSeq

    val i = GameInstance(options, finalObjects, spawn)
    i.setCallbacks(log, notify)
    i
  }
}

package services.game

import java.util.UUID

import models.collision.{CollisionGrid, CollisionPoly}
import models.game.GameStage
import models.node.{DoorNode, Node}
import models.options.GameOptions
import models.player.Player
import util.Point

object GameInstanceFactory {
  def create(
    options: GameOptions,
    initialNodes: Seq[Node],
    initialPlayers: Seq[Player],
    collision: Either[CollisionPoly, CollisionGrid],
    log: String => Unit, notify: String => Unit
  ) = {
    val id = UUID.randomUUID

    val spawn = initialNodes.collectFirst { case n: DoorNode if n.name == "main" => n }.map { d =>
      Point(d.x.toInt + (d.width / 2), d.y.toInt + d.height - 24)
    }.getOrElse(throw new IllegalStateException("No spawn point detected."))

    val objs = initialNodes.map(_.asNewGameObject).toIndexedSeq

    val i = GameInstance(id = id, options = options, stage = GameStage(sourceMap = options.map, objects = objs, collision = collision), spawn = spawn)
    GameInstanceDebug.setCallbacks(options.debug, log, notify)
    initialPlayers.foreach(i.addPlayer)
    i
  }
}

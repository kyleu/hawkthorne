package services.game

import java.util.UUID

import models.collision.{CollisionGrid, CollisionPoly}
import models.game.cmd.GameCommand
import models.node.{DoorNode, Node}
import models.options.GameOptions
import models.player.Player

object GameInstanceFactory {
  def create(
    options: GameOptions,
    nodes: Seq[Node],
    initialPlayers: Seq[Player],
    collision: Either[CollisionPoly, CollisionGrid],
    log: String => Unit,
    notify: String => Unit
  ) = {
    val newGameId = UUID.randomUUID

    val objs = nodes.flatMap(_.asNewGameObject).toIndexedSeq

    val m = GameMap(newGameId, map = options.map, objects = objs)
    m.setCollision(coll = collision)

    val spawns = nodes.collect { case n: DoorNode => n }.map { d =>
      d.actualName -> util.IntPoint(d.x.toInt + (d.width / 2), d.y.toInt + d.height)
    }.toMap
    m.setSpawns(spawns)

    val i = GameInstance(gameId = newGameId, options = options)
    i.addMap(m)
    GameInstanceDebug.setCallbacks(options.debug, log, notify)
    i.start(initialPlayers.map(p => GameCommand.AddPlayer(p, options.map)))
    i
  }
}

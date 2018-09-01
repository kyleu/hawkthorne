package services.game

import java.util.UUID

import models.collision.{CollisionGrid, CollisionPoly}
import models.game.cmd.GameCommand
import models.node.{DoorNode, Node}
import models.options.GameOptions
import models.player.Player
import services.map.GameMap

object GameInstanceFactory {
  def create(
    options: GameOptions,
    nodes: Seq[Node],
    initialPlayers: Seq[Player],
    collision: Either[CollisionPoly, CollisionGrid],
    log: String => Unit,
    notify: String => Unit
  ) = {
    GameInstanceDebug.setCallbacks(options.debug, log, notify)

    val newGameId = UUID.randomUUID

    val objs = nodes.flatMap(_.asNewGameObject).toIndexedSeq

    val m = GameMap(newGameId, map = options.map, objects = objs)
    m.setCollision(coll = collision)

    val spawns = nodes.collect { case n: DoorNode => n }.map { d =>
      d.actualName -> util.IntPoint(d.x.toInt + (d.width / 2), d.y.toInt + d.height)
    }.toMap
    m.setSpawns(spawns)

    GameInstance(gameId = newGameId, map = m, options = options).start(
      initialCommands = initialPlayers.map(p => GameCommand.AddPlayer(player = p, spawn = options.initialSpawn))
    )
  }
}

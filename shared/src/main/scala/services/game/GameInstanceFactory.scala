package services.game

import java.util.UUID

import models.collision.{CollisionGrid, CollisionPoly}
import models.game.{GameStage, GameCommand}
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
    val newGameId = UUID.randomUUID

    val spawn = initialNodes.collectFirst { case n: DoorNode if n.name == "main" => n }.map { d =>
      Point(d.x.toInt + (d.width / 2), d.y.toInt + d.height - 24)
    }.getOrElse(throw new IllegalStateException("No spawn point detected."))

    val objs = initialNodes.flatMap(_.asNewGameObject).toIndexedSeq

    val i = GameInstance(gameId = newGameId, options = options, stage = GameStage(sourceMap = options.map, objects = objs, collision = collision), spawn = spawn)
    GameInstanceDebug.setCallbacks(options.debug, log, notify)

    initialPlayers.foreach(p => i.update(0, GameCommand.AddPlayer(p)))

    i
  }
}

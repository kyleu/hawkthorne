package services.game

import java.util.UUID

import models.collision.{CollisionGrid, CollisionPoly}
import models.game.{GameStage, GameCommand}
import models.node.{DoorNode, Node}
import models.options.GameOptions
import models.player.Player

object GameInstanceFactory {
  def create(
    options: GameOptions,
    nodes: Seq[Node],
    initialPlayers: Seq[Player],
    collision: Either[CollisionPoly, CollisionGrid],
    log: String => Unit, notify: String => Unit
  ) = {
    val newGameId = UUID.randomUUID

    val spawn = nodes.collectFirst { case n: DoorNode if n.name == "main" => n }.map { d =>
      util.IntPoint(d.x.toInt + (d.width / 2), d.y.toInt + d.height)
    }.getOrElse(throw new IllegalStateException("No spawn point detected."))

    val objs = nodes.flatMap(_.asNewGameObject).toIndexedSeq

    val i = GameInstance(gameId = newGameId, options = options, stage = GameStage(sourceMap = options.map, objects = objs), spawn = spawn)
    i.stage.setCollision(coll = collision)
    GameInstanceDebug.setCallbacks(options.debug, log, notify)

    val initialMessages = i.update(delta = 0, initialPlayers.map(GameCommand.AddPlayer.apply): _*)
    i.apply(initialMessages)
    i
  }
}

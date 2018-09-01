package services.game

import java.util.UUID

import models.game.msg.GameMessage
import models.input.PlayerInputHandler
import models.player.{Player, PlayerRecord}
import services.game.GameInstanceDebug.{debug, log}

trait GameInstancePlayers { this: GameInstance =>
  protected[this] var players = IndexedSeq.empty[PlayerRecord]
  protected[this] def indexOfPlayerId(id: UUID) = players.indexWhere(_.player.id == id)

  protected[this] def addPlayer(player: Player, spawnPoint: String = "main") = {
    val spawn = map.spawnPoints(spawnPoint)
    val box = player.template.boundingBox
    indexOfPlayerId(player.id) match {
      case -1 => players = players :+ {
        val pih = new PlayerInputHandler(instance = this, map = map, playerIdx = players.size, boundingBox = box, initial = spawn.tupled, log = log)
        PlayerRecord(player = player, input = pih)
      }
      case idx if idx == player.idx => players = players.map(record => if (record.player.idx == idx) {
        val pih = new PlayerInputHandler(instance = this, map = map, playerIdx = idx, boundingBox = box, initial = spawn.tupled, log = log)
        record.copy(player = player, input = pih)
      } else {
        record
      })
      case idx => throw new IllegalStateException(s"Got request to add player with index [${player.idx}] to index [$idx].")
    }

    debug(s"Added player [$player] to game, making [${players.size}] total players ([${players.count(_.player.attributes.connected)}] active).")

    GameMessage.PlayerAdded(player = player, x = spawn.x, y = spawn.y)
  }

  def boundsForPlayer(idx: Int) = players(idx).input.bounds
  def positionForPlayer(idx: Int) = players(idx).input.getPosition

  protected[this] def removePlayer(id: UUID) = {
    players.collectFirst {
      case x if x.player.id == id => x.player.attributes.connected = false
    }
    debug(s"Removed player [$id] from game, making [${players.size}] total players ([${players.count(_.player.attributes.connected)}] active).")
    GameMessage.PlayerRemoved(players.size - 1, id)
  }
}

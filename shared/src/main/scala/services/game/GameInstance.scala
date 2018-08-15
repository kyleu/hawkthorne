package services.game

import java.util.UUID

import models.game.{GameCommand, GameMessage, GameStage}
import models.input.{InputCommand, PlayerInputHandler}
import models.options.GameOptions
import models.player.Player
import services.game.GameInstanceDebug._
import util.Point

object GameInstance {
  case class PlayerRecord(idx: Int, player: Player, var x: Double, var y: Double, input: PlayerInputHandler)
}

final case class GameInstance(gameId: UUID, options: GameOptions, stage: GameStage, spawn: Point) {
  private[this] var elapsedSeconds = 0.0
  val bounds = (options.map.width * 24) -> (options.map.height * 24)

  private[this] var players = IndexedSeq.empty[GameInstance.PlayerRecord]

  private[this] def indexOfPlayerId(id: UUID) = players.indexWhere(_.player.id == id)

  private[this] def addPlayer(player: Player) = {
    val playerIndex = indexOfPlayerId(player.id) match {
      case -1 =>
        val idx = players.size - 1
        players = players :+ GameInstance.PlayerRecord(idx, player, 0, 0, new PlayerInputHandler(bounds._1, bounds._2, log))
        idx
      case x =>
        players = players.zipWithIndex.map { record =>
          if (record._1.idx == x) {
            // TODO Notify replaced player?
            record._1.copy(player = player)
          } else {
            record._1
          }
        }
        x
    }

    debug(s"Added player [$player] to game, making [${players.size}] total players ([${players.count(_.player.attributes.connected)}] active).")
    GameMessage.PlayerAdded(playerIndex, player)
  }
  private[this] def removePlayer(id: UUID) = {
    players.collectFirst {
      case x if x.player.id == id => x.player.attributes.connected = false
    }
    debug(s"Removed player [$id] from game, making [${players.size}] total players ([${players.count(_.player.attributes.connected)}] active).")
    GameMessage.PlayerRemoved(players.size - 1, id)
  }

  def start() = {
    log(toString)
  }

  private[this] def onInput(delta: Double, pi: GameCommand.PlayerInput) = {
    val record = players(pi.idx)
    val (anim, loc) = record.input.process(delta, record.x, record.y, pi)
    loc.map {
      case (newX, newY) => GameMessage.PlayerLocationUpdated(pi.idx, newX, newY)
    }.toSeq
  }

  def update(delta: Double, gu: GameCommand*): Seq[GameMessage] = {
    elapsedSeconds += delta
    gu.flatMap {
      case GameCommand.AddPlayer(player) => Seq(addPlayer(player))
      case GameCommand.RemovePlayer(id) => Seq(removePlayer(id))
      case pi: GameCommand.PlayerInput => onInput(delta, pi)
      case x => throw new IllegalStateException(s"Unhandled update [$x].")
    }
  }

  override def toString = GameInstanceDebug.debugString(gameId, options, players, stage, elapsedSeconds)
}

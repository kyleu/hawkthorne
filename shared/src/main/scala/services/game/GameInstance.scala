package services.game

import java.util.UUID

import models.game.{GameStage, GameUpdate}
import models.options.GameOptions
import models.player.Player
import services.game.GameInstanceDebug._
import util.Point

final case class GameInstance(id: UUID, options: GameOptions, stage: GameStage, spawn: Point) {
  protected[this] val startMs = System.currentTimeMillis
  protected[this] var elapsedSeconds = 0.0

  private[this] val whoops = stage.objects.filter(o => o.t == "player")
  if (whoops.nonEmpty) {
    throw new IllegalStateException(s"Illegal game object for initial state: [${whoops.mkString(", ")}]")
  }

  private[this] var players = IndexedSeq.empty[Player]
  def addPlayer(p: Player) = {
    players = players :+ p
    debug(s"Added player [$p] to game, making [${players.size}] total players.")
  }

  val bounds = (options.map.width * 24) -> (options.map.height * 24)

  val startupTime = System.currentTimeMillis - startMs

  def start() = {
    log(s"Game [$this] started.")
  }

  def onMessage(gu: GameUpdate) = gu match {
    case x => throw new IllegalStateException(s"Unhandled update [$x].")
  }

  override def toString = GameInstanceDebug.debugString(id, options, stage)
}

package services.game

import java.util.UUID

import models.game.{GameObject, GameOptions, GameUpdate}
import util.Point

final case class GameInstance(id: UUID, options: GameOptions, var objects: IndexedSeq[GameObject], spawn: Point) extends GameInstanceDebug {
  private[this] var _lastId = objects.map(_.id).max + 1
  protected def nextId() = {
    _lastId += 1
    _lastId
  }

  private[this] var players = objects.filter(o => o.t == "player")

  val bounds = (options.map.width * 24) -> (options.map.height * 24)

  val startupTime = System.currentTimeMillis - startMs

  def initialMessages() = {
    val systemTime = System.currentTimeMillis - startMs - startupTime
    log(s"System loaded in [${systemTime}ms]. Game [$id] started in [${startupTime}ms].")
  }

  def onMessage(gu: GameUpdate) = gu match {
    case GameUpdate.AddPlayer(_, p) => players = players :+ p.asNewGameObject(nextId(), players.size, spawn)
    case x => throw new IllegalStateException(s"Unhandled update [$x].")
  }
}

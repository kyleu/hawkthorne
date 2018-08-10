package services.game

import java.util.UUID

import models.game.{GameStage, GameUpdate}
import models.options.GameOptions
import util.Point

final case class GameInstance(id: UUID, options: GameOptions, stage: GameStage, spawn: Point) extends GameInstanceDebug {
  protected[this] val startMs = System.currentTimeMillis

  private[this] var players = stage.objects.filter(o => o.t == "player")

  val bounds = (options.map.width * 24) -> (options.map.height * 24)

  val startupTime = System.currentTimeMillis - startMs

  def initialMessages() = {
    val systemTime = System.currentTimeMillis - startMs - startupTime
    log(s"System loaded in [${systemTime}ms]. Game [$id] started in [${startupTime}ms].")
  }

  def onMessage(gu: GameUpdate) = gu match {
    case x => throw new IllegalStateException(s"Unhandled update [$x].")
  }
}

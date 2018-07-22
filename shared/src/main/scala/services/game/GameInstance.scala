package services.game

import models.game.{GameObject, GameOptions, GameUpdate}
import models.scenario.Scenario
import util.Point

case class GameInstance(options: GameOptions, var objects: IndexedSeq[GameObject], spawn: Point) {
  private[this] val startMs = System.currentTimeMillis

  private[this] var logger: Option[String => Unit] = None
  def log(s: String) = logger.getOrElse(throw new IllegalStateException("Not initialized."))(s)

  private[this] var notification: Option[String => Unit] = None
  def notify(s: String) = notification.getOrElse(throw new IllegalStateException("Not initialized."))(s)

  def setCallbacks(log: String => Unit, notify: String => Unit) = {
    logger = Some(log)
    notification = Some(notify)
  }

  private[this] var _lastId = objects.map(_.id).max + 1
  protected def nextId() = {
    _lastId += 1
    _lastId
  }

  private[this] var players = objects.filter(o => o.t == "player")

  val scenario = options.scenario match {
    case "new" => Scenario.fromOptions(options, players)
    case x => throw new IllegalStateException(s"Unhandled scenario [$x].")
  }

  val bounds = (options.map.width * 24) -> (options.map.height * 24)

  val startupTime = System.currentTimeMillis - startMs

  def initialMessages() = {
    log(s"Game [${options.id}] started in [${startupTime}ms].")
  }

  def onMessage(gu: GameUpdate) = gu match {
    case GameUpdate.AddPlayer(_, p) => players = players :+ p.asNewGameObject(nextId(), players.size, spawn)
    case x => throw new IllegalStateException(s"Unhandled update [$x].")
  }
}

package models.game

import models.player.Player
import models.scenario.Scenario

class GameInstance(val options: GameOptions, initialPlayers: Seq[Player]) {
  private[this] var logger: Option[String => Unit] = None
  private[this] def log(s: String) = logger.getOrElse(throw new IllegalStateException("Not initialized."))(s)

  private[this] var notification: Option[String => Unit] = None
  private[this] def notify(s: String) = logger.getOrElse(throw new IllegalStateException("Not initialized."))(s)

  def setCallbacks(log: String => Unit, notify: String => Unit) = {
    logger = Some(log)
    notification = Some(notify)
  }

  val scenario = options.scenario match {
    case "new" => Scenario.fromOptions(options, initialPlayers)
    case x => throw new IllegalStateException(s"Unhandled scenario [$x].")
  }

  private[this] var players = initialPlayers

  def onMessage(gu: GameUpdate) = gu match {
    case GameUpdate.AddPlayer(_, p) => players = players :+ p
    case x => throw new IllegalStateException(s"Unhandled update [$x].")
  }
}

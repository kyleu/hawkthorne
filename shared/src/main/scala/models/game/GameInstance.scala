package models.game

import models.node.Node
import models.player.Player

case class GameInstance(
    options: GameOptions,
    nodes: Seq[Node],
    logger: String => Unit,
    notification: String => Unit
) {
  options.scenario match {
    case "new" => logger("Starting default game...")
    case x => throw new IllegalStateException(s"Unhandled scenario [$x].")
  }

  private[this] var players = Seq.empty[Player]

  def onMessage(gu: GameUpdate) = gu match {
    case GameUpdate.AddPlayer(_, p) => players = players :+ p
    case x => throw new IllegalStateException(s"Unhandled update [$x].")
  }
}

package models.settings

import models.player.Player

object ActivePlayers {
  private[this] var players = IndexedSeq.empty[Player]

  def getPlayers = {
    if (players.isEmpty) { throw new IllegalStateException("No active players") }
    players
  }

  def setPlayers(p: IndexedSeq[Player]) = {
    players = p
  }
}

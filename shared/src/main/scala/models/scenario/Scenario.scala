package models.scenario

import java.util.UUID

import models.data.map.TiledMap
import models.game.GameOptions
import models.player.Player

object Scenario {
  def fromOptions(options: GameOptions, players: Seq[Player]) = {
    Scenario(options.id, options.map, options.maxPlayers, !options.offline, players)
  }
}

case class Scenario(
    id: UUID,
    map: TiledMap,
    maxPlayers: Int = 1,
    networked: Boolean = false,
    initialPlayers: Seq[Player]
)

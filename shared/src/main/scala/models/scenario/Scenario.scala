package models.scenario

import java.util.UUID

import models.data.map.TiledMap
import models.game.{GameObject, GameOptions}

object Scenario {
  def fromOptions(options: GameOptions, players: Seq[GameObject]) = {
    Scenario(options.id, options.map, options.maxPlayers, !options.offline, players)
  }
}

final case class Scenario(
    id: UUID,
    map: TiledMap,
    maxPlayers: Int = 1,
    networked: Boolean = false,
    initialPlayers: Seq[GameObject]
)

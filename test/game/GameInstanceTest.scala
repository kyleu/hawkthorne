package game

import java.util.UUID

import models.data.map.TiledMap
import models.options.GameOptions
import models.player.Player
import org.scalatest._
import services.game.GameInstanceFactory
import services.map.ServerMapCache

class GameInstanceTest extends FlatSpec with Matchers {
  def startGame(tiled: TiledMap) = GameInstanceFactory.create(
    options = GameOptions(map = tiled),
    nodes = ServerMapCache.apply(tiled).nodes,
    initialPlayers = Seq(Player.random(id = UUID.randomUUID, idx = 0)),
    collision = ServerMapCache.apply(tiled).collision,
    log = println,
    notify = println
  ).start()

  "GameInstance" should "start and stop correctly" in {
    val game = startGame(TiledMap.ACSchool)
    game.stop()
  }
}

package services.game

import java.util.UUID

import models.{GameHistoryType, GameSnapshotType}
import models.auth.Credentials
import models.history.{GameHistory, GamePlayer, GameSnapshot}
import services.history.HistoryServiceRegistry
import util.FutureUtils.serviceContext
import util.JsonSerializers._
import util.tracing.TraceData

import scala.concurrent.Future

class GameHistoryHelper(services: HistoryServiceRegistry) {
  private[this] val creds = Credentials.system
  private[this] implicit val td: TraceData = new TraceData

  def writeInitialGameHistory(game: GameInstance, players: Seq[GameService.PlayerEntry]) = {
    services.gameHistoryService.insert(creds, GameHistory.empty(id = game.gameId, t = GameHistoryType.Server, options = game.options.asJson)).flatMap {
      case Some(h) =>
        val snapshotF = services.gameSnapshotService.insert(creds, toSnapshot(GameSnapshotType.Initial, game))
        players.foldLeft(Future.successful(())) { (ret, player) =>
          ret.flatMap { _ =>
            services.gamePlayerService.insert(creds, toPlayer(game.gameId, player)).map(_ => ())
          }
        }.flatMap(_ => snapshotF.map(_ => ()))
      case None => throw new IllegalStateException("Cannot read newly-inserted game history.")
    }
  }

  private[this] def toSnapshot(t: GameSnapshotType, game: GameInstance) = GameSnapshot.empty(
    gameId = game.gameId, t = t, snapshot = game.toDebug.asJson
  )

  private[this] def toPlayer(gameId: UUID, r: GameService.PlayerEntry) = GamePlayer.empty(
    gameId = gameId, userId = r.userId, idx = r.idx, template = r.player.templateKey, costume = r.player.costumeKey, attributes = r.player.attributes.asJson
  )
}

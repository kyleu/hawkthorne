/* Generated File */
package services.history

import java.time.LocalDateTime
import java.util.UUID
import models.auth.Credentials
import models.history.GamePlayer
import models.queries.history.GamePlayerQueries
import models.result.data.DataField
import models.result.filter.Filter
import models.result.orderBy.OrderBy
import scala.concurrent.Future
import services.ModelServiceHelper
import services.database.ApplicationDatabase
import util.FutureUtils.serviceContext
import util.tracing.{TraceData, TracingService}

@javax.inject.Singleton
class GamePlayerService @javax.inject.Inject() (override val tracing: TracingService) extends ModelServiceHelper[GamePlayer]("gamePlayer") {
  def getByPrimaryKey(creds: Credentials, gameId: UUID, idx: Int)(implicit trace: TraceData) = {
    traceF("get.by.primary.key")(td => ApplicationDatabase.queryF(GamePlayerQueries.getByPrimaryKey(gameId, idx))(td))
  }
  def getByPrimaryKeySeq(creds: Credentials, pkSeq: Seq[(UUID, Int)])(implicit trace: TraceData) = {
    traceF("get.by.primary.key.seq")(td => ApplicationDatabase.queryF(GamePlayerQueries.getByPrimaryKeySeq(pkSeq))(td))
  }

  override def countAll(creds: Credentials, filters: Seq[Filter] = Nil)(implicit trace: TraceData) = {
    traceF("get.all.count")(td => ApplicationDatabase.queryF(GamePlayerQueries.countAll(filters))(td))
  }
  override def getAll(creds: Credentials, filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = {
    traceF("get.all")(td => ApplicationDatabase.queryF(GamePlayerQueries.getAll(filters, orderBys, limit, offset))(td))
  }

  // Search
  override def searchCount(creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil)(implicit trace: TraceData) = {
    traceF("search.count")(td => ApplicationDatabase.queryF(GamePlayerQueries.searchCount(q, filters))(td))
  }
  override def search(
    creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None
  )(implicit trace: TraceData) = {
    traceF("search")(td => ApplicationDatabase.queryF(GamePlayerQueries.search(q, filters, orderBys, limit, offset))(td))
  }

  def searchExact(
    creds: Credentials, q: String, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None
  )(implicit trace: TraceData) = {
    traceF("search.exact")(td => ApplicationDatabase.queryF(GamePlayerQueries.searchExact(q, orderBys, limit, offset))(td))
  }

  def countByCostume(creds: Credentials, costume: String)(implicit trace: TraceData) = traceF("count.by.costume") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.CountByCostume(costume))(td)
  }
  def getByCostume(creds: Credentials, costume: String, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.costume") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.GetByCostume(costume, orderBys, limit, offset))(td)
  }
  def getByCostumeSeq(creds: Credentials, costumeSeq: Seq[String])(implicit trace: TraceData) = traceF("get.by.costume.seq") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.GetByCostumeSeq(costumeSeq))(td)
  }

  def countByGameId(creds: Credentials, gameId: UUID)(implicit trace: TraceData) = traceF("count.by.gameId") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.CountByGameId(gameId))(td)
  }
  def getByGameId(creds: Credentials, gameId: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.gameId") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.GetByGameId(gameId, orderBys, limit, offset))(td)
  }
  def getByGameIdSeq(creds: Credentials, gameIdSeq: Seq[UUID])(implicit trace: TraceData) = traceF("get.by.gameId.seq") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.GetByGameIdSeq(gameIdSeq))(td)
  }

  def countByIdx(creds: Credentials, idx: Int)(implicit trace: TraceData) = traceF("count.by.idx") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.CountByIdx(idx))(td)
  }
  def getByIdx(creds: Credentials, idx: Int, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.idx") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.GetByIdx(idx, orderBys, limit, offset))(td)
  }
  def getByIdxSeq(creds: Credentials, idxSeq: Seq[Int])(implicit trace: TraceData) = traceF("get.by.idx.seq") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.GetByIdxSeq(idxSeq))(td)
  }

  def countByJoined(creds: Credentials, joined: LocalDateTime)(implicit trace: TraceData) = traceF("count.by.joined") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.CountByJoined(joined))(td)
  }
  def getByJoined(creds: Credentials, joined: LocalDateTime, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.joined") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.GetByJoined(joined, orderBys, limit, offset))(td)
  }
  def getByJoinedSeq(creds: Credentials, joinedSeq: Seq[LocalDateTime])(implicit trace: TraceData) = traceF("get.by.joined.seq") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.GetByJoinedSeq(joinedSeq))(td)
  }

  def countByTemplate(creds: Credentials, template: String)(implicit trace: TraceData) = traceF("count.by.template") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.CountByTemplate(template))(td)
  }
  def getByTemplate(creds: Credentials, template: String, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.template") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.GetByTemplate(template, orderBys, limit, offset))(td)
  }
  def getByTemplateSeq(creds: Credentials, templateSeq: Seq[String])(implicit trace: TraceData) = traceF("get.by.template.seq") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.GetByTemplateSeq(templateSeq))(td)
  }

  def countByUserId(creds: Credentials, userId: UUID)(implicit trace: TraceData) = traceF("count.by.userId") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.CountByUserId(userId))(td)
  }
  def getByUserId(creds: Credentials, userId: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.userId") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.GetByUserId(userId, orderBys, limit, offset))(td)
  }
  def getByUserIdSeq(creds: Credentials, userIdSeq: Seq[UUID])(implicit trace: TraceData) = traceF("get.by.userId.seq") { td =>
    ApplicationDatabase.queryF(GamePlayerQueries.GetByUserIdSeq(userIdSeq))(td)
  }

  // Mutations
  def insert(creds: Credentials, model: GamePlayer)(implicit trace: TraceData) = traceF("insert") { td =>
    ApplicationDatabase.executeF(GamePlayerQueries.insert(model))(td).flatMap {
      case 1 => getByPrimaryKey(creds, model.gameId, model.idx)(td)
      case _ => throw new IllegalStateException("Unable to find newly-inserted Game Player.")
    }
  }
  def insertBatch(creds: Credentials, models: Seq[GamePlayer])(implicit trace: TraceData) = {
    traceF("insertBatch")(td => ApplicationDatabase.executeF(GamePlayerQueries.insertBatch(models))(td))
  }
  def create(creds: Credentials, fields: Seq[DataField])(implicit trace: TraceData) = traceF("create") { td =>
    ApplicationDatabase.executeF(GamePlayerQueries.create(fields))(td).flatMap { _ =>
      getByPrimaryKey(creds, UUID.fromString(fieldVal(fields, "gameId")), fieldVal(fields, "idx").toInt)
    }
  }

  def remove(creds: Credentials, gameId: UUID, idx: Int)(implicit trace: TraceData) = {
    traceF("remove")(td => getByPrimaryKey(creds, gameId, idx)(td).flatMap {
      case Some(current) =>
        ApplicationDatabase.executeF(GamePlayerQueries.removeByPrimaryKey(gameId, idx))(td).map(_ => current)
      case None => throw new IllegalStateException(s"Cannot find GamePlayer matching [$gameId, $idx].")
    })
  }

  def update(creds: Credentials, gameId: UUID, idx: Int, fields: Seq[DataField])(implicit trace: TraceData) = {
    traceF("update")(td => getByPrimaryKey(creds, gameId, idx)(td).flatMap {
      case Some(current) if fields.isEmpty => Future.successful(current -> s"No changes required for Game Player [$gameId, $idx].")
      case Some(_) => ApplicationDatabase.executeF(GamePlayerQueries.update(gameId, idx, fields))(td).flatMap { _ =>
        getByPrimaryKey(creds, gameId, idx)(td).map {
          case Some(newModel) =>
            newModel -> s"Updated [${fields.size}] fields of Game Player [$gameId, $idx]."
          case None => throw new IllegalStateException(s"Cannot find GamePlayer matching [$gameId, $idx].")
        }
      }
      case None => throw new IllegalStateException(s"Cannot find GamePlayer matching [$gameId, $idx].")
    })
  }

  def csvFor(totalCount: Int, rows: Seq[GamePlayer])(implicit trace: TraceData) = {
    traceB("export.csv")(td => util.CsvUtils.csvFor(Some(key), totalCount, rows, GamePlayerQueries.fields)(td))
  }
}

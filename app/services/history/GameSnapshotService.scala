/* Generated File */
package services.history

import java.time.LocalDateTime
import java.util.UUID
import models.GameSnapshotType
import models.auth.Credentials
import models.history.GameSnapshot
import models.queries.history.GameSnapshotQueries
import models.result.data.DataField
import models.result.filter.Filter
import models.result.orderBy.OrderBy
import scala.concurrent.Future
import services.ModelServiceHelper
import services.database.ApplicationDatabase
import util.FutureUtils.serviceContext
import util.tracing.{TraceData, TracingService}

@javax.inject.Singleton
class GameSnapshotService @javax.inject.Inject() (override val tracing: TracingService) extends ModelServiceHelper[GameSnapshot]("gameSnapshot") {
  def getByPrimaryKey(creds: Credentials, id: UUID)(implicit trace: TraceData) = {
    traceF("get.by.primary.key")(td => ApplicationDatabase.queryF(GameSnapshotQueries.getByPrimaryKey(id))(td))
  }
  def getByPrimaryKeyRequired(creds: Credentials, id: UUID)(implicit trace: TraceData) = getByPrimaryKey(creds, id).map { opt =>
    opt.getOrElse(throw new IllegalStateException(s"Cannot load gameSnapshot with id [$id]."))
  }
  def getByPrimaryKeySeq(creds: Credentials, idSeq: Seq[UUID])(implicit trace: TraceData) = {
    traceF("get.by.primary.key.seq")(td => ApplicationDatabase.queryF(GameSnapshotQueries.getByPrimaryKeySeq(idSeq))(td))
  }

  override def countAll(creds: Credentials, filters: Seq[Filter] = Nil)(implicit trace: TraceData) = {
    traceF("get.all.count")(td => ApplicationDatabase.queryF(GameSnapshotQueries.countAll(filters))(td))
  }
  override def getAll(creds: Credentials, filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = {
    traceF("get.all")(td => ApplicationDatabase.queryF(GameSnapshotQueries.getAll(filters, orderBys, limit, offset))(td))
  }

  // Search
  override def searchCount(creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil)(implicit trace: TraceData) = {
    traceF("search.count")(td => ApplicationDatabase.queryF(GameSnapshotQueries.searchCount(q, filters))(td))
  }
  override def search(
    creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None
  )(implicit trace: TraceData) = {
    traceF("search")(td => ApplicationDatabase.queryF(GameSnapshotQueries.search(q, filters, orderBys, limit, offset))(td))
  }

  def searchExact(
    creds: Credentials, q: String, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None
  )(implicit trace: TraceData) = {
    traceF("search.exact")(td => ApplicationDatabase.queryF(GameSnapshotQueries.searchExact(q, orderBys, limit, offset))(td))
  }

  def countByGameId(creds: Credentials, gameId: UUID)(implicit trace: TraceData) = traceF("count.by.gameId") { td =>
    ApplicationDatabase.queryF(GameSnapshotQueries.CountByGameId(gameId))(td)
  }
  def getByGameId(creds: Credentials, gameId: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.gameId") { td =>
    ApplicationDatabase.queryF(GameSnapshotQueries.GetByGameId(gameId, orderBys, limit, offset))(td)
  }
  def getByGameIdSeq(creds: Credentials, gameIdSeq: Seq[UUID])(implicit trace: TraceData) = traceF("get.by.gameId.seq") { td =>
    ApplicationDatabase.queryF(GameSnapshotQueries.GetByGameIdSeq(gameIdSeq))(td)
  }

  def countById(creds: Credentials, id: UUID)(implicit trace: TraceData) = traceF("count.by.id") { td =>
    ApplicationDatabase.queryF(GameSnapshotQueries.CountById(id))(td)
  }
  def getById(creds: Credentials, id: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.id") { td =>
    ApplicationDatabase.queryF(GameSnapshotQueries.GetById(id, orderBys, limit, offset))(td)
  }
  def getByIdSeq(creds: Credentials, idSeq: Seq[UUID])(implicit trace: TraceData) = traceF("get.by.id.seq") { td =>
    ApplicationDatabase.queryF(GameSnapshotQueries.GetByIdSeq(idSeq))(td)
  }

  def countByOccurred(creds: Credentials, occurred: LocalDateTime)(implicit trace: TraceData) = traceF("count.by.occurred") { td =>
    ApplicationDatabase.queryF(GameSnapshotQueries.CountByOccurred(occurred))(td)
  }
  def getByOccurred(creds: Credentials, occurred: LocalDateTime, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.occurred") { td =>
    ApplicationDatabase.queryF(GameSnapshotQueries.GetByOccurred(occurred, orderBys, limit, offset))(td)
  }
  def getByOccurredSeq(creds: Credentials, occurredSeq: Seq[LocalDateTime])(implicit trace: TraceData) = traceF("get.by.occurred.seq") { td =>
    ApplicationDatabase.queryF(GameSnapshotQueries.GetByOccurredSeq(occurredSeq))(td)
  }

  def countByGameSnapshotType(creds: Credentials, t: GameSnapshotType)(implicit trace: TraceData) = traceF("count.by.t") { td =>
    ApplicationDatabase.queryF(GameSnapshotQueries.CountByGameSnapshotType(t))(td)
  }
  def getByGameSnapshotType(creds: Credentials, t: GameSnapshotType, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.t") { td =>
    ApplicationDatabase.queryF(GameSnapshotQueries.GetByGameSnapshotType(t, orderBys, limit, offset))(td)
  }
  def getByGameSnapshotTypeSeq(creds: Credentials, tSeq: Seq[GameSnapshotType])(implicit trace: TraceData) = traceF("get.by.t.seq") { td =>
    ApplicationDatabase.queryF(GameSnapshotQueries.GetByGameSnapshotTypeSeq(tSeq))(td)
  }

  // Mutations
  def insert(creds: Credentials, model: GameSnapshot)(implicit trace: TraceData) = traceF("insert") { td =>
    ApplicationDatabase.executeF(GameSnapshotQueries.insert(model))(td).flatMap {
      case 1 => getByPrimaryKey(creds, model.id)(td)
      case _ => throw new IllegalStateException("Unable to find newly-inserted Game Snapshot.")
    }
  }
  def insertBatch(creds: Credentials, models: Seq[GameSnapshot])(implicit trace: TraceData) = {
    traceF("insertBatch")(td => ApplicationDatabase.executeF(GameSnapshotQueries.insertBatch(models))(td))
  }
  def create(creds: Credentials, fields: Seq[DataField])(implicit trace: TraceData) = traceF("create") { td =>
    ApplicationDatabase.executeF(GameSnapshotQueries.create(fields))(td).flatMap { _ =>
      getByPrimaryKey(creds, UUID.fromString(fieldVal(fields, "id")))
    }
  }

  def remove(creds: Credentials, id: UUID)(implicit trace: TraceData) = {
    traceF("remove")(td => getByPrimaryKey(creds, id)(td).flatMap {
      case Some(current) =>
        ApplicationDatabase.executeF(GameSnapshotQueries.removeByPrimaryKey(id))(td).map(_ => current)
      case None => throw new IllegalStateException(s"Cannot find GameSnapshot matching [$id].")
    })
  }

  def update(creds: Credentials, id: UUID, fields: Seq[DataField])(implicit trace: TraceData) = {
    traceF("update")(td => getByPrimaryKey(creds, id)(td).flatMap {
      case Some(current) if fields.isEmpty => Future.successful(current -> s"No changes required for Game Snapshot [$id].")
      case Some(_) => ApplicationDatabase.executeF(GameSnapshotQueries.update(id, fields))(td).flatMap { _ =>
        getByPrimaryKey(creds, id)(td).map {
          case Some(newModel) =>
            newModel -> s"Updated [${fields.size}] fields of Game Snapshot [$id]."
          case None => throw new IllegalStateException(s"Cannot find GameSnapshot matching [$id].")
        }
      }
      case None => throw new IllegalStateException(s"Cannot find GameSnapshot matching [$id].")
    })
  }

  def csvFor(totalCount: Int, rows: Seq[GameSnapshot])(implicit trace: TraceData) = {
    traceB("export.csv")(td => util.CsvUtils.csvFor(Some(key), totalCount, rows, GameSnapshotQueries.fields)(td))
  }
}

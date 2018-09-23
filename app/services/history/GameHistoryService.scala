/* Generated File */
package services.history

import java.time.LocalDateTime
import java.util.UUID
import models.GameHistoryType
import models.auth.Credentials
import models.history.GameHistory
import models.queries.history.GameHistoryQueries
import models.result.data.DataField
import models.result.filter.Filter
import models.result.orderBy.OrderBy
import scala.concurrent.Future
import services.ModelServiceHelper
import services.database.ApplicationDatabase
import util.FutureUtils.serviceContext
import util.tracing.{TraceData, TracingService}

@javax.inject.Singleton
class GameHistoryService @javax.inject.Inject() (override val tracing: TracingService) extends ModelServiceHelper[GameHistory]("gameHistory") {
  def getByPrimaryKey(creds: Credentials, id: UUID)(implicit trace: TraceData) = {
    traceF("get.by.primary.key")(td => ApplicationDatabase.queryF(GameHistoryQueries.getByPrimaryKey(id))(td))
  }
  def getByPrimaryKeyRequired(creds: Credentials, id: UUID)(implicit trace: TraceData) = getByPrimaryKey(creds, id).map { opt =>
    opt.getOrElse(throw new IllegalStateException(s"Cannot load gameHistory with id [$id]."))
  }
  def getByPrimaryKeySeq(creds: Credentials, idSeq: Seq[UUID])(implicit trace: TraceData) = {
    traceF("get.by.primary.key.seq")(td => ApplicationDatabase.queryF(GameHistoryQueries.getByPrimaryKeySeq(idSeq))(td))
  }

  override def countAll(creds: Credentials, filters: Seq[Filter] = Nil)(implicit trace: TraceData) = {
    traceF("get.all.count")(td => ApplicationDatabase.queryF(GameHistoryQueries.countAll(filters))(td))
  }
  override def getAll(creds: Credentials, filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = {
    traceF("get.all")(td => ApplicationDatabase.queryF(GameHistoryQueries.getAll(filters, orderBys, limit, offset))(td))
  }

  // Search
  override def searchCount(creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil)(implicit trace: TraceData) = {
    traceF("search.count")(td => ApplicationDatabase.queryF(GameHistoryQueries.searchCount(q, filters))(td))
  }
  override def search(
    creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None
  )(implicit trace: TraceData) = {
    traceF("search")(td => ApplicationDatabase.queryF(GameHistoryQueries.search(q, filters, orderBys, limit, offset))(td))
  }

  def searchExact(
    creds: Credentials, q: String, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None
  )(implicit trace: TraceData) = {
    traceF("search.exact")(td => ApplicationDatabase.queryF(GameHistoryQueries.searchExact(q, orderBys, limit, offset))(td))
  }

  def countByCreator(creds: Credentials, creator: UUID)(implicit trace: TraceData) = traceF("count.by.creator") { td =>
    ApplicationDatabase.queryF(GameHistoryQueries.CountByCreator(creator))(td)
  }
  def getByCreator(creds: Credentials, creator: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.creator") { td =>
    ApplicationDatabase.queryF(GameHistoryQueries.GetByCreator(creator, orderBys, limit, offset))(td)
  }
  def getByCreatorSeq(creds: Credentials, creatorSeq: Seq[UUID])(implicit trace: TraceData) = traceF("get.by.creator.seq") { td =>
    ApplicationDatabase.queryF(GameHistoryQueries.GetByCreatorSeq(creatorSeq))(td)
  }

  def countById(creds: Credentials, id: UUID)(implicit trace: TraceData) = traceF("count.by.id") { td =>
    ApplicationDatabase.queryF(GameHistoryQueries.CountById(id))(td)
  }
  def getById(creds: Credentials, id: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.id") { td =>
    ApplicationDatabase.queryF(GameHistoryQueries.GetById(id, orderBys, limit, offset))(td)
  }
  def getByIdSeq(creds: Credentials, idSeq: Seq[UUID])(implicit trace: TraceData) = traceF("get.by.id.seq") { td =>
    ApplicationDatabase.queryF(GameHistoryQueries.GetByIdSeq(idSeq))(td)
  }

  def countByStarted(creds: Credentials, started: LocalDateTime)(implicit trace: TraceData) = traceF("count.by.started") { td =>
    ApplicationDatabase.queryF(GameHistoryQueries.CountByStarted(started))(td)
  }
  def getByStarted(creds: Credentials, started: LocalDateTime, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.started") { td =>
    ApplicationDatabase.queryF(GameHistoryQueries.GetByStarted(started, orderBys, limit, offset))(td)
  }
  def getByStartedSeq(creds: Credentials, startedSeq: Seq[LocalDateTime])(implicit trace: TraceData) = traceF("get.by.started.seq") { td =>
    ApplicationDatabase.queryF(GameHistoryQueries.GetByStartedSeq(startedSeq))(td)
  }

  def countByGameHistoryType(creds: Credentials, t: GameHistoryType)(implicit trace: TraceData) = traceF("count.by.t") { td =>
    ApplicationDatabase.queryF(GameHistoryQueries.CountByGameHistoryType(t))(td)
  }
  def getByGameHistoryType(creds: Credentials, t: GameHistoryType, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.t") { td =>
    ApplicationDatabase.queryF(GameHistoryQueries.GetByGameHistoryType(t, orderBys, limit, offset))(td)
  }
  def getByGameHistoryTypeSeq(creds: Credentials, tSeq: Seq[GameHistoryType])(implicit trace: TraceData) = traceF("get.by.t.seq") { td =>
    ApplicationDatabase.queryF(GameHistoryQueries.GetByGameHistoryTypeSeq(tSeq))(td)
  }

  // Mutations
  def insert(creds: Credentials, model: GameHistory)(implicit trace: TraceData) = traceF("insert") { td =>
    ApplicationDatabase.executeF(GameHistoryQueries.insert(model))(td).flatMap {
      case 1 => getByPrimaryKey(creds, model.id)(td)
      case _ => throw new IllegalStateException("Unable to find newly-inserted Game History.")
    }
  }
  def insertBatch(creds: Credentials, models: Seq[GameHistory])(implicit trace: TraceData) = {
    traceF("insertBatch")(td => ApplicationDatabase.executeF(GameHistoryQueries.insertBatch(models))(td))
  }
  def create(creds: Credentials, fields: Seq[DataField])(implicit trace: TraceData) = traceF("create") { td =>
    ApplicationDatabase.executeF(GameHistoryQueries.create(fields))(td).flatMap { _ =>
      getByPrimaryKey(creds, UUID.fromString(fieldVal(fields, "id")))
    }
  }

  def remove(creds: Credentials, id: UUID)(implicit trace: TraceData) = {
    traceF("remove")(td => getByPrimaryKey(creds, id)(td).flatMap {
      case Some(current) =>
        ApplicationDatabase.executeF(GameHistoryQueries.removeByPrimaryKey(id))(td).map(_ => current)
      case None => throw new IllegalStateException(s"Cannot find GameHistory matching [$id].")
    })
  }

  def update(creds: Credentials, id: UUID, fields: Seq[DataField])(implicit trace: TraceData) = {
    traceF("update")(td => getByPrimaryKey(creds, id)(td).flatMap {
      case Some(current) if fields.isEmpty => Future.successful(current -> s"No changes required for Game History [$id].")
      case Some(_) => ApplicationDatabase.executeF(GameHistoryQueries.update(id, fields))(td).flatMap { _ =>
        getByPrimaryKey(creds, id)(td).map {
          case Some(newModel) =>
            newModel -> s"Updated [${fields.size}] fields of Game History [$id]."
          case None => throw new IllegalStateException(s"Cannot find GameHistory matching [$id].")
        }
      }
      case None => throw new IllegalStateException(s"Cannot find GameHistory matching [$id].")
    })
  }

  def csvFor(totalCount: Int, rows: Seq[GameHistory])(implicit trace: TraceData) = {
    traceB("export.csv")(td => util.CsvUtils.csvFor(Some(key), totalCount, rows, GameHistoryQueries.fields)(td))
  }
}

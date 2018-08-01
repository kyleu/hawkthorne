/* Generated File */
package services.analytics

import java.time.LocalDateTime
import java.util.UUID
import models.analytics.{AnalyticsAction, AnalyticsActionType}
import models.auth.Credentials
import models.queries.analytics.AnalyticsActionQueries
import models.result.data.DataField
import models.result.filter.Filter
import models.result.orderBy.OrderBy
import scala.concurrent.Future
import services.ModelServiceHelper
import services.database.ApplicationDatabase
import util.FutureUtils.serviceContext
import util.tracing.{TraceData, TracingService}

@javax.inject.Singleton
class AnalyticsActionService @javax.inject.Inject() (override val tracing: TracingService) extends ModelServiceHelper[AnalyticsAction]("analyticsAction") {
  def getByPrimaryKey(creds: Credentials, id: UUID)(implicit trace: TraceData) = {
    traceF("get.by.primary.key")(td => ApplicationDatabase.queryF(AnalyticsActionQueries.getByPrimaryKey(id))(td))
  }
  def getByPrimaryKeyRequired(creds: Credentials, id: UUID)(implicit trace: TraceData) = getByPrimaryKey(creds, id).map { opt =>
    opt.getOrElse(throw new IllegalStateException(s"Cannot load analyticsAction with id [$id]."))
  }
  def getByPrimaryKeySeq(creds: Credentials, idSeq: Seq[UUID])(implicit trace: TraceData) = {
    traceF("get.by.primary.key.seq")(td => ApplicationDatabase.queryF(AnalyticsActionQueries.getByPrimaryKeySeq(idSeq))(td))
  }

  override def countAll(creds: Credentials, filters: Seq[Filter] = Nil)(implicit trace: TraceData) = {
    traceF("get.all.count")(td => ApplicationDatabase.queryF(AnalyticsActionQueries.countAll(filters))(td))
  }
  override def getAll(creds: Credentials, filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = {
    traceF("get.all")(td => ApplicationDatabase.queryF(AnalyticsActionQueries.getAll(filters, orderBys, limit, offset))(td))
  }

  // Search
  override def searchCount(creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil)(implicit trace: TraceData) = {
    traceF("search.count")(td => ApplicationDatabase.queryF(AnalyticsActionQueries.searchCount(q, filters))(td))
  }
  override def search(
    creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None
  )(implicit trace: TraceData) = {
    traceF("search")(td => ApplicationDatabase.queryF(AnalyticsActionQueries.search(q, filters, orderBys, limit, offset))(td))
  }

  def searchExact(
    creds: Credentials, q: String, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None
  )(implicit trace: TraceData) = {
    traceF("search.exact")(td => ApplicationDatabase.queryF(AnalyticsActionQueries.searchExact(q, orderBys, limit, offset))(td))
  }

  def countByAuthor(creds: Credentials, author: UUID)(implicit trace: TraceData) = traceF("count.by.author") { td =>
    ApplicationDatabase.queryF(AnalyticsActionQueries.CountByAuthor(author))(td)
  }
  def getByAuthor(creds: Credentials, author: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.author") { td =>
    ApplicationDatabase.queryF(AnalyticsActionQueries.GetByAuthor(author, orderBys, limit, offset))(td)
  }
  def getByAuthorSeq(creds: Credentials, authorSeq: Seq[UUID])(implicit trace: TraceData) = traceF("get.by.author.seq") { td =>
    ApplicationDatabase.queryF(AnalyticsActionQueries.GetByAuthorSeq(authorSeq))(td)
  }

  def countById(creds: Credentials, id: UUID)(implicit trace: TraceData) = traceF("count.by.id") { td =>
    ApplicationDatabase.queryF(AnalyticsActionQueries.CountById(id))(td)
  }
  def getById(creds: Credentials, id: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.id") { td =>
    ApplicationDatabase.queryF(AnalyticsActionQueries.GetById(id, orderBys, limit, offset))(td)
  }
  def getByIdSeq(creds: Credentials, idSeq: Seq[UUID])(implicit trace: TraceData) = traceF("get.by.id.seq") { td =>
    ApplicationDatabase.queryF(AnalyticsActionQueries.GetByIdSeq(idSeq))(td)
  }

  def countByOccurred(creds: Credentials, occurred: LocalDateTime)(implicit trace: TraceData) = traceF("count.by.occurred") { td =>
    ApplicationDatabase.queryF(AnalyticsActionQueries.CountByOccurred(occurred))(td)
  }
  def getByOccurred(creds: Credentials, occurred: LocalDateTime, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.occurred") { td =>
    ApplicationDatabase.queryF(AnalyticsActionQueries.GetByOccurred(occurred, orderBys, limit, offset))(td)
  }
  def getByOccurredSeq(creds: Credentials, occurredSeq: Seq[LocalDateTime])(implicit trace: TraceData) = traceF("get.by.occurred.seq") { td =>
    ApplicationDatabase.queryF(AnalyticsActionQueries.GetByOccurredSeq(occurredSeq))(td)
  }

  def countByStatus(creds: Credentials, status: String)(implicit trace: TraceData) = traceF("count.by.status") { td =>
    ApplicationDatabase.queryF(AnalyticsActionQueries.CountByStatus(status))(td)
  }
  def getByStatus(creds: Credentials, status: String, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.status") { td =>
    ApplicationDatabase.queryF(AnalyticsActionQueries.GetByStatus(status, orderBys, limit, offset))(td)
  }
  def getByStatusSeq(creds: Credentials, statusSeq: Seq[String])(implicit trace: TraceData) = traceF("get.by.status.seq") { td =>
    ApplicationDatabase.queryF(AnalyticsActionQueries.GetByStatusSeq(statusSeq))(td)
  }

  def countByAnalyticsActionType(creds: Credentials, t: AnalyticsActionType)(implicit trace: TraceData) = traceF("count.by.t") { td =>
    ApplicationDatabase.queryF(AnalyticsActionQueries.CountByAnalyticsActionType(t))(td)
  }
  def getByAnalyticsActionType(creds: Credentials, t: AnalyticsActionType, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.t") { td =>
    ApplicationDatabase.queryF(AnalyticsActionQueries.GetByAnalyticsActionType(t, orderBys, limit, offset))(td)
  }
  def getByAnalyticsActionTypeSeq(creds: Credentials, tSeq: Seq[AnalyticsActionType])(implicit trace: TraceData) = traceF("get.by.t.seq") { td =>
    ApplicationDatabase.queryF(AnalyticsActionQueries.GetByAnalyticsActionTypeSeq(tSeq))(td)
  }

  // Mutations
  def insert(creds: Credentials, model: AnalyticsAction)(implicit trace: TraceData) = traceF("insert") { td =>
    ApplicationDatabase.executeF(AnalyticsActionQueries.insert(model))(td).flatMap {
      case 1 => getByPrimaryKey(creds, model.id)(td)
      case _ => throw new IllegalStateException("Unable to find newly-inserted Analytics Action.")
    }
  }
  def insertBatch(creds: Credentials, models: Seq[AnalyticsAction])(implicit trace: TraceData) = {
    traceF("insertBatch")(td => ApplicationDatabase.executeF(AnalyticsActionQueries.insertBatch(models))(td))
  }
  def create(creds: Credentials, fields: Seq[DataField])(implicit trace: TraceData) = traceF("create") { td =>
    ApplicationDatabase.executeF(AnalyticsActionQueries.create(fields))(td).flatMap { _ =>
      getByPrimaryKey(creds, UUID.fromString(fieldVal(fields, "id")))
    }
  }

  def remove(creds: Credentials, id: UUID)(implicit trace: TraceData) = {
    traceF("remove")(td => getByPrimaryKey(creds, id)(td).flatMap {
      case Some(current) =>
        ApplicationDatabase.executeF(AnalyticsActionQueries.removeByPrimaryKey(id))(td).map(_ => current)
      case None => throw new IllegalStateException(s"Cannot find AnalyticsAction matching [$id].")
    })
  }

  def update(creds: Credentials, id: UUID, fields: Seq[DataField])(implicit trace: TraceData) = {
    traceF("update")(td => getByPrimaryKey(creds, id)(td).flatMap {
      case Some(current) if fields.isEmpty => Future.successful(current -> s"No changes required for Analytics Action [$id].")
      case Some(_) => ApplicationDatabase.executeF(AnalyticsActionQueries.update(id, fields))(td).flatMap { _ =>
        getByPrimaryKey(creds, id)(td).map {
          case Some(newModel) =>
            newModel -> s"Updated [${fields.size}] fields of Analytics Action [$id]."
          case None => throw new IllegalStateException(s"Cannot find AnalyticsAction matching [$id].")
        }
      }
      case None => throw new IllegalStateException(s"Cannot find AnalyticsAction matching [$id].")
    })
  }

  def csvFor(totalCount: Int, rows: Seq[AnalyticsAction])(implicit trace: TraceData) = {
    traceB("export.csv")(td => util.CsvUtils.csvFor(Some(key), totalCount, rows, AnalyticsActionQueries.fields)(td))
  }
}

/* Generated File */
package services.trace

import java.time.LocalDateTime
import java.util.UUID
import models.TraceTypeEnum
import models.auth.Credentials
import models.queries.trace.TraceResultQueries
import models.result.data.DataField
import models.result.filter.Filter
import models.result.orderBy.OrderBy
import models.trace.TraceResult
import scala.concurrent.Future
import services.ModelServiceHelper
import services.database.ApplicationDatabase
import util.FutureUtils.serviceContext
import util.tracing.{TraceData, TracingService}

@javax.inject.Singleton
class TraceResultService @javax.inject.Inject() (override val tracing: TracingService) extends ModelServiceHelper[TraceResult]("traceResult") {
  def getByPrimaryKey(creds: Credentials, id: UUID)(implicit trace: TraceData) = {
    traceF("get.by.primary.key")(td => ApplicationDatabase.queryF(TraceResultQueries.getByPrimaryKey(id))(td))
  }
  def getByPrimaryKeyRequired(creds: Credentials, id: UUID)(implicit trace: TraceData) = getByPrimaryKey(creds, id).map { opt =>
    opt.getOrElse(throw new IllegalStateException(s"Cannot load traceResult with id [$id]."))
  }
  def getByPrimaryKeySeq(creds: Credentials, idSeq: Seq[UUID])(implicit trace: TraceData) = {
    traceF("get.by.primary.key.seq")(td => ApplicationDatabase.queryF(TraceResultQueries.getByPrimaryKeySeq(idSeq))(td))
  }

  override def countAll(creds: Credentials, filters: Seq[Filter] = Nil)(implicit trace: TraceData) = {
    traceF("get.all.count")(td => ApplicationDatabase.queryF(TraceResultQueries.countAll(filters))(td))
  }
  override def getAll(creds: Credentials, filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = {
    traceF("get.all")(td => ApplicationDatabase.queryF(TraceResultQueries.getAll(filters, orderBys, limit, offset))(td))
  }

  // Search
  override def searchCount(creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil)(implicit trace: TraceData) = {
    traceF("search.count")(td => ApplicationDatabase.queryF(TraceResultQueries.searchCount(q, filters))(td))
  }
  override def search(
    creds: Credentials, q: Option[String], filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None
  )(implicit trace: TraceData) = {
    traceF("search")(td => ApplicationDatabase.queryF(TraceResultQueries.search(q, filters, orderBys, limit, offset))(td))
  }

  def searchExact(
    creds: Credentials, q: String, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None
  )(implicit trace: TraceData) = {
    traceF("search.exact")(td => ApplicationDatabase.queryF(TraceResultQueries.searchExact(q, orderBys, limit, offset))(td))
  }

  def countByAuthor(creds: Credentials, author: UUID)(implicit trace: TraceData) = traceF("count.by.author") { td =>
    ApplicationDatabase.queryF(TraceResultQueries.CountByAuthor(author))(td)
  }
  def getByAuthor(creds: Credentials, author: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.author") { td =>
    ApplicationDatabase.queryF(TraceResultQueries.GetByAuthor(author, orderBys, limit, offset))(td)
  }
  def getByAuthorSeq(creds: Credentials, authorSeq: Seq[UUID])(implicit trace: TraceData) = traceF("get.by.author.seq") { td =>
    ApplicationDatabase.queryF(TraceResultQueries.GetByAuthorSeq(authorSeq))(td)
  }

  def countById(creds: Credentials, id: UUID)(implicit trace: TraceData) = traceF("count.by.id") { td =>
    ApplicationDatabase.queryF(TraceResultQueries.CountById(id))(td)
  }
  def getById(creds: Credentials, id: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.id") { td =>
    ApplicationDatabase.queryF(TraceResultQueries.GetById(id, orderBys, limit, offset))(td)
  }
  def getByIdSeq(creds: Credentials, idSeq: Seq[UUID])(implicit trace: TraceData) = traceF("get.by.id.seq") { td =>
    ApplicationDatabase.queryF(TraceResultQueries.GetByIdSeq(idSeq))(td)
  }

  def countByOccurred(creds: Credentials, occurred: LocalDateTime)(implicit trace: TraceData) = traceF("count.by.occurred") { td =>
    ApplicationDatabase.queryF(TraceResultQueries.CountByOccurred(occurred))(td)
  }
  def getByOccurred(creds: Credentials, occurred: LocalDateTime, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.occurred") { td =>
    ApplicationDatabase.queryF(TraceResultQueries.GetByOccurred(occurred, orderBys, limit, offset))(td)
  }
  def getByOccurredSeq(creds: Credentials, occurredSeq: Seq[LocalDateTime])(implicit trace: TraceData) = traceF("get.by.occurred.seq") { td =>
    ApplicationDatabase.queryF(TraceResultQueries.GetByOccurredSeq(occurredSeq))(td)
  }

  def countByTraceTypeEnum(creds: Credentials, t: TraceTypeEnum)(implicit trace: TraceData) = traceF("count.by.t") { td =>
    ApplicationDatabase.queryF(TraceResultQueries.CountByTraceTypeEnum(t))(td)
  }
  def getByTraceTypeEnum(creds: Credentials, t: TraceTypeEnum, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None)(implicit trace: TraceData) = traceF("get.by.t") { td =>
    ApplicationDatabase.queryF(TraceResultQueries.GetByTraceTypeEnum(t, orderBys, limit, offset))(td)
  }
  def getByTraceTypeEnumSeq(creds: Credentials, tSeq: Seq[TraceTypeEnum])(implicit trace: TraceData) = traceF("get.by.t.seq") { td =>
    ApplicationDatabase.queryF(TraceResultQueries.GetByTraceTypeEnumSeq(tSeq))(td)
  }

  // Mutations
  def insert(creds: Credentials, model: TraceResult)(implicit trace: TraceData) = traceF("insert") { td =>
    ApplicationDatabase.executeF(TraceResultQueries.insert(model))(td).flatMap {
      case 1 => getByPrimaryKey(creds, model.id)(td)
      case _ => throw new IllegalStateException("Unable to find newly-inserted Trace Result.")
    }
  }
  def insertBatch(creds: Credentials, models: Seq[TraceResult])(implicit trace: TraceData) = {
    traceF("insertBatch")(td => ApplicationDatabase.executeF(TraceResultQueries.insertBatch(models))(td))
  }
  def create(creds: Credentials, fields: Seq[DataField])(implicit trace: TraceData) = traceF("create") { td =>
    ApplicationDatabase.executeF(TraceResultQueries.create(fields))(td).flatMap { _ =>
      getByPrimaryKey(creds, UUID.fromString(fieldVal(fields, "id")))
    }
  }

  def remove(creds: Credentials, id: UUID)(implicit trace: TraceData) = {
    traceF("remove")(td => getByPrimaryKey(creds, id)(td).flatMap {
      case Some(current) =>
        ApplicationDatabase.executeF(TraceResultQueries.removeByPrimaryKey(id))(td).map(_ => current)
      case None => throw new IllegalStateException(s"Cannot find TraceResult matching [$id].")
    })
  }

  def update(creds: Credentials, id: UUID, fields: Seq[DataField])(implicit trace: TraceData) = {
    traceF("update")(td => getByPrimaryKey(creds, id)(td).flatMap {
      case Some(current) if fields.isEmpty => Future.successful(current -> s"No changes required for Trace Result [$id].")
      case Some(_) => ApplicationDatabase.executeF(TraceResultQueries.update(id, fields))(td).flatMap { _ =>
        getByPrimaryKey(creds, id)(td).map {
          case Some(newModel) =>
            newModel -> s"Updated [${fields.size}] fields of Trace Result [$id]."
          case None => throw new IllegalStateException(s"Cannot find TraceResult matching [$id].")
        }
      }
      case None => throw new IllegalStateException(s"Cannot find TraceResult matching [$id].")
    })
  }

  def csvFor(totalCount: Int, rows: Seq[TraceResult])(implicit trace: TraceData) = {
    traceB("export.csv")(td => util.CsvUtils.csvFor(Some(key), totalCount, rows, TraceResultQueries.fields)(td))
  }
}

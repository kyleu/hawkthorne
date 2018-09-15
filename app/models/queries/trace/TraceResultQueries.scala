/* Generated File */
package models.queries.trace

import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID
import models.TraceTypeEnum
import models.database.{DatabaseField, Row}
import models.database.DatabaseFieldType._
import models.queries.BaseQueries
import models.result.ResultFieldHelper
import models.result.data.DataField
import models.result.filter.Filter
import models.result.orderBy.OrderBy
import models.trace.TraceResult

object TraceResultQueries extends BaseQueries[TraceResult]("traceResult", "trace_result") {
  override val fields = Seq(
    DatabaseField(title = "Id", prop = "id", col = "id", typ = UuidType),
    DatabaseField(title = "T", prop = "t", col = "t", typ = EnumType(TraceTypeEnum)),
    DatabaseField(title = "Data", prop = "data", col = "data", typ = JsonType),
    DatabaseField(title = "Author", prop = "author", col = "author", typ = UuidType),
    DatabaseField(title = "Occurred", prop = "occurred", col = "occurred", typ = TimestampType)
  )
  override protected val pkColumns = Seq("id")
  override protected val searchColumns = Seq("id", "t", "author", "occurred")

  def countAll(filters: Seq[Filter] = Nil) = onCountAll(filters)
  def getAll(filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) = {
    new GetAll(filters, orderBys, limit, offset)
  }

  def search(q: Option[String], filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) = {
    new Search(q, filters, orderBys, limit, offset)
  }
  def searchCount(q: Option[String], filters: Seq[Filter] = Nil) = new SearchCount(q, filters)
  def searchExact(q: String, orderBys: Seq[OrderBy], limit: Option[Int], offset: Option[Int]) = new SearchExact(q, orderBys, limit, offset)

  def getByPrimaryKey(id: UUID) = new GetByPrimaryKey(Seq(id))
  def getByPrimaryKeySeq(idSeq: Seq[UUID]) = new ColSeqQuery(column = "id", values = idSeq)

  final case class CountByAuthor(author: UUID) extends ColCount(column = "author", values = Seq(author))
  final case class GetByAuthor(author: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) extends SeqQuery(
    whereClause = Some(quote("author") + "  = ?"), orderBy = ResultFieldHelper.orderClause(fields, orderBys: _*),
    limit = limit, offset = offset, values = Seq(author)
  )
  final case class GetByAuthorSeq(authorSeq: Seq[UUID]) extends ColSeqQuery(column = "author", values = authorSeq)

  final case class CountById(id: UUID) extends ColCount(column = "id", values = Seq(id))
  final case class GetById(id: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) extends SeqQuery(
    whereClause = Some(quote("id") + "  = ?"), orderBy = ResultFieldHelper.orderClause(fields, orderBys: _*),
    limit = limit, offset = offset, values = Seq(id)
  )
  final case class GetByIdSeq(idSeq: Seq[UUID]) extends ColSeqQuery(column = "id", values = idSeq)

  final case class CountByOccurred(occurred: LocalDateTime) extends ColCount(column = "occurred", values = Seq(occurred))
  final case class GetByOccurred(occurred: LocalDateTime, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) extends SeqQuery(
    whereClause = Some(quote("occurred") + "  = ?"), orderBy = ResultFieldHelper.orderClause(fields, orderBys: _*),
    limit = limit, offset = offset, values = Seq(occurred)
  )
  final case class GetByOccurredSeq(occurredSeq: Seq[LocalDateTime]) extends ColSeqQuery(column = "occurred", values = occurredSeq)

  final case class CountByTraceTypeEnum(t: TraceTypeEnum) extends ColCount(column = "t", values = Seq(t))
  final case class GetByTraceTypeEnum(t: TraceTypeEnum, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) extends SeqQuery(
    whereClause = Some(quote("t") + "  = ?"), orderBy = ResultFieldHelper.orderClause(fields, orderBys: _*),
    limit = limit, offset = offset, values = Seq(t)
  )
  final case class GetByTraceTypeEnumSeq(tSeq: Seq[TraceTypeEnum]) extends ColSeqQuery(column = "t", values = tSeq)

  def insert(model: TraceResult) = new Insert(model)
  def insertBatch(models: Seq[TraceResult]) = new InsertBatch(models)
  def create(dataFields: Seq[DataField]) = new CreateFields(dataFields)

  def removeByPrimaryKey(id: UUID) = new RemoveByPrimaryKey(Seq[Any](id))

  def update(id: UUID, fields: Seq[DataField]) = new UpdateFields(Seq[Any](id), fields)

  override def fromRow(row: Row) = TraceResult(
    id = UuidType(row, "id"),
    t = EnumType(TraceTypeEnum)(row, "t"),
    data = JsonType(row, "data"),
    author = UuidType.opt(row, "author"),
    occurred = TimestampType(row, "occurred")
  )
}

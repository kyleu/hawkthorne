/* Generated File */
package models.queries.history

import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID
import models.GameHistoryType
import models.database.{DatabaseField, Row}
import models.database.DatabaseFieldType._
import models.history.GameHistory
import models.queries.BaseQueries
import models.result.ResultFieldHelper
import models.result.data.DataField
import models.result.filter.Filter
import models.result.orderBy.OrderBy

object GameHistoryQueries extends BaseQueries[GameHistory]("gameHistory", "game_history") {
  override val fields = Seq(
    DatabaseField(title = "Id", prop = "id", col = "id", typ = UuidType),
    DatabaseField(title = "T", prop = "t", col = "t", typ = EnumType(GameHistoryType)),
    DatabaseField(title = "Options", prop = "options", col = "options", typ = JsonType),
    DatabaseField(title = "Creator", prop = "creator", col = "creator", typ = UuidType),
    DatabaseField(title = "Started", prop = "started", col = "started", typ = TimestampType)
  )
  override protected val pkColumns = Seq("id")
  override protected val searchColumns = Seq("id", "t", "creator", "started")

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

  final case class CountByCreator(creator: UUID) extends ColCount(column = "creator", values = Seq(creator))
  final case class GetByCreator(creator: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) extends SeqQuery(
    whereClause = Some(quote("creator") + "  = ?"), orderBy = ResultFieldHelper.orderClause(fields, orderBys: _*),
    limit = limit, offset = offset, values = Seq(creator)
  )
  final case class GetByCreatorSeq(creatorSeq: Seq[UUID]) extends ColSeqQuery(column = "creator", values = creatorSeq)

  final case class CountById(id: UUID) extends ColCount(column = "id", values = Seq(id))
  final case class GetById(id: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) extends SeqQuery(
    whereClause = Some(quote("id") + "  = ?"), orderBy = ResultFieldHelper.orderClause(fields, orderBys: _*),
    limit = limit, offset = offset, values = Seq(id)
  )
  final case class GetByIdSeq(idSeq: Seq[UUID]) extends ColSeqQuery(column = "id", values = idSeq)

  final case class CountByStarted(started: LocalDateTime) extends ColCount(column = "started", values = Seq(started))
  final case class GetByStarted(started: LocalDateTime, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) extends SeqQuery(
    whereClause = Some(quote("started") + "  = ?"), orderBy = ResultFieldHelper.orderClause(fields, orderBys: _*),
    limit = limit, offset = offset, values = Seq(started)
  )
  final case class GetByStartedSeq(startedSeq: Seq[LocalDateTime]) extends ColSeqQuery(column = "started", values = startedSeq)

  final case class CountByGameHistoryType(t: GameHistoryType) extends ColCount(column = "t", values = Seq(t))
  final case class GetByGameHistoryType(t: GameHistoryType, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) extends SeqQuery(
    whereClause = Some(quote("t") + "  = ?"), orderBy = ResultFieldHelper.orderClause(fields, orderBys: _*),
    limit = limit, offset = offset, values = Seq(t)
  )
  final case class GetByGameHistoryTypeSeq(tSeq: Seq[GameHistoryType]) extends ColSeqQuery(column = "t", values = tSeq)

  def insert(model: GameHistory) = new Insert(model)
  def insertBatch(models: Seq[GameHistory]) = new InsertBatch(models)
  def create(dataFields: Seq[DataField]) = new CreateFields(dataFields)

  def removeByPrimaryKey(id: UUID) = new RemoveByPrimaryKey(Seq[Any](id))

  def update(id: UUID, fields: Seq[DataField]) = new UpdateFields(Seq[Any](id), fields)

  override def fromRow(row: Row) = GameHistory(
    id = UuidType(row, "id"),
    t = EnumType(GameHistoryType)(row, "t"),
    options = JsonType(row, "options"),
    creator = UuidType.opt(row, "creator"),
    started = TimestampType(row, "started")
  )
}

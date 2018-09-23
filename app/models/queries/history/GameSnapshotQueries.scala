/* Generated File */
package models.queries.history

import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID
import models.GameSnapshotType
import models.database.{DatabaseField, Row}
import models.database.DatabaseFieldType._
import models.history.GameSnapshot
import models.queries.BaseQueries
import models.result.ResultFieldHelper
import models.result.data.DataField
import models.result.filter.Filter
import models.result.orderBy.OrderBy

object GameSnapshotQueries extends BaseQueries[GameSnapshot]("gameSnapshot", "game_snapshot") {
  override val fields = Seq(
    DatabaseField(title = "Id", prop = "id", col = "id", typ = UuidType),
    DatabaseField(title = "Game Id", prop = "gameId", col = "game_id", typ = UuidType),
    DatabaseField(title = "T", prop = "t", col = "t", typ = EnumType(GameSnapshotType)),
    DatabaseField(title = "Snapshot", prop = "snapshot", col = "snapshot", typ = JsonType),
    DatabaseField(title = "Occurred", prop = "occurred", col = "occurred", typ = TimestampType)
  )
  override protected val pkColumns = Seq("id")
  override protected val searchColumns = Seq("id", "game_id", "t", "occurred")

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

  final case class CountByGameId(gameId: UUID) extends ColCount(column = "game_id", values = Seq(gameId))
  final case class GetByGameId(gameId: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) extends SeqQuery(
    whereClause = Some(quote("game_id") + "  = ?"), orderBy = ResultFieldHelper.orderClause(fields, orderBys: _*),
    limit = limit, offset = offset, values = Seq(gameId)
  )
  final case class GetByGameIdSeq(gameIdSeq: Seq[UUID]) extends ColSeqQuery(column = "game_id", values = gameIdSeq)

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

  final case class CountByGameSnapshotType(t: GameSnapshotType) extends ColCount(column = "t", values = Seq(t))
  final case class GetByGameSnapshotType(t: GameSnapshotType, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) extends SeqQuery(
    whereClause = Some(quote("t") + "  = ?"), orderBy = ResultFieldHelper.orderClause(fields, orderBys: _*),
    limit = limit, offset = offset, values = Seq(t)
  )
  final case class GetByGameSnapshotTypeSeq(tSeq: Seq[GameSnapshotType]) extends ColSeqQuery(column = "t", values = tSeq)

  def insert(model: GameSnapshot) = new Insert(model)
  def insertBatch(models: Seq[GameSnapshot]) = new InsertBatch(models)
  def create(dataFields: Seq[DataField]) = new CreateFields(dataFields)

  def removeByPrimaryKey(id: UUID) = new RemoveByPrimaryKey(Seq[Any](id))

  def update(id: UUID, fields: Seq[DataField]) = new UpdateFields(Seq[Any](id), fields)

  override def fromRow(row: Row) = GameSnapshot(
    id = UuidType(row, "id"),
    gameId = UuidType.opt(row, "game_id"),
    t = EnumType(GameSnapshotType)(row, "t"),
    snapshot = JsonType(row, "snapshot"),
    occurred = TimestampType(row, "occurred")
  )
}

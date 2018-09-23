/* Generated File */
package models.queries.history

import java.time.LocalDateTime
import java.util.UUID
import models.database.{DatabaseField, Row}
import models.database.DatabaseFieldType._
import models.history.GamePlayer
import models.queries.BaseQueries
import models.result.ResultFieldHelper
import models.result.data.DataField
import models.result.filter.Filter
import models.result.orderBy.OrderBy

object GamePlayerQueries extends BaseQueries[GamePlayer]("gamePlayer", "game_player") {
  override val fields = Seq(
    DatabaseField(title = "Game Id", prop = "gameId", col = "game_id", typ = UuidType),
    DatabaseField(title = "User Id", prop = "userId", col = "user_id", typ = UuidType),
    DatabaseField(title = "Idx", prop = "idx", col = "idx", typ = LongType),
    DatabaseField(title = "Joined", prop = "joined", col = "joined", typ = TimestampType)
  )
  override protected val pkColumns = Seq("game_id", "user_id")
  override protected val searchColumns = Seq("game_id", "user_id", "idx", "joined")

  def countAll(filters: Seq[Filter] = Nil) = onCountAll(filters)
  def getAll(filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) = {
    new GetAll(filters, orderBys, limit, offset)
  }

  def search(q: Option[String], filters: Seq[Filter] = Nil, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) = {
    new Search(q, filters, orderBys, limit, offset)
  }
  def searchCount(q: Option[String], filters: Seq[Filter] = Nil) = new SearchCount(q, filters)
  def searchExact(q: String, orderBys: Seq[OrderBy], limit: Option[Int], offset: Option[Int]) = new SearchExact(q, orderBys, limit, offset)

  def getByPrimaryKey(gameId: UUID, userId: UUID) = new GetByPrimaryKey(Seq[Any](gameId, userId))
  def getByPrimaryKeySeq(idSeq: Seq[(UUID, UUID)]) = new SeqQuery(
    whereClause = Some(idSeq.map(_ => "(\"game_id\" = ? and \"user_id\" = ?)").mkString(" or ")),
    values = idSeq.flatMap(_.productIterator.toSeq)
  )

  final case class CountByGameId(gameId: UUID) extends ColCount(column = "game_id", values = Seq(gameId))
  final case class GetByGameId(gameId: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) extends SeqQuery(
    whereClause = Some(quote("game_id") + "  = ?"), orderBy = ResultFieldHelper.orderClause(fields, orderBys: _*),
    limit = limit, offset = offset, values = Seq(gameId)
  )
  final case class GetByGameIdSeq(gameIdSeq: Seq[UUID]) extends ColSeqQuery(column = "game_id", values = gameIdSeq)

  final case class CountByIdx(idx: Long) extends ColCount(column = "idx", values = Seq(idx))
  final case class GetByIdx(idx: Long, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) extends SeqQuery(
    whereClause = Some(quote("idx") + "  = ?"), orderBy = ResultFieldHelper.orderClause(fields, orderBys: _*),
    limit = limit, offset = offset, values = Seq(idx)
  )
  final case class GetByIdxSeq(idxSeq: Seq[Long]) extends ColSeqQuery(column = "idx", values = idxSeq)

  final case class CountByJoined(joined: LocalDateTime) extends ColCount(column = "joined", values = Seq(joined))
  final case class GetByJoined(joined: LocalDateTime, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) extends SeqQuery(
    whereClause = Some(quote("joined") + "  = ?"), orderBy = ResultFieldHelper.orderClause(fields, orderBys: _*),
    limit = limit, offset = offset, values = Seq(joined)
  )
  final case class GetByJoinedSeq(joinedSeq: Seq[LocalDateTime]) extends ColSeqQuery(column = "joined", values = joinedSeq)

  final case class CountByUserId(userId: UUID) extends ColCount(column = "user_id", values = Seq(userId))
  final case class GetByUserId(userId: UUID, orderBys: Seq[OrderBy] = Nil, limit: Option[Int] = None, offset: Option[Int] = None) extends SeqQuery(
    whereClause = Some(quote("user_id") + "  = ?"), orderBy = ResultFieldHelper.orderClause(fields, orderBys: _*),
    limit = limit, offset = offset, values = Seq(userId)
  )
  final case class GetByUserIdSeq(userIdSeq: Seq[UUID]) extends ColSeqQuery(column = "user_id", values = userIdSeq)

  def insert(model: GamePlayer) = new Insert(model)
  def insertBatch(models: Seq[GamePlayer]) = new InsertBatch(models)
  def create(dataFields: Seq[DataField]) = new CreateFields(dataFields)

  def removeByPrimaryKey(gameId: UUID, userId: UUID) = new RemoveByPrimaryKey(Seq[Any](gameId, userId))

  def update(gameId: UUID, userId: UUID, fields: Seq[DataField]) = new UpdateFields(Seq[Any](gameId, userId), fields)

  override def fromRow(row: Row) = GamePlayer(
    gameId = UuidType(row, "game_id"),
    userId = UuidType(row, "user_id"),
    idx = LongType(row, "idx"),
    joined = TimestampType(row, "joined")
  )
}

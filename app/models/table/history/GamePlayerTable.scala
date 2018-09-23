/* Generated File */
package models.table.history

import java.time.LocalDateTime
import java.util.UUID
import services.database.SlickQueryService.imports._

object GamePlayerTable {
  val query = TableQuery[GamePlayerTable]

  def getByPrimaryKey(gameId: UUID, userId: UUID) = query.filter(o => o.gameId === gameId && o.userId === userId).result.headOption

  def getByGameId(gameId: UUID) = query.filter(_.gameId === gameId).result
  def getByGameIdSeq(gameIdSeq: Seq[UUID]) = query.filter(_.gameId.inSet(gameIdSeq)).result

  def getByUserId(userId: UUID) = query.filter(_.userId === userId).result
  def getByUserIdSeq(userIdSeq: Seq[UUID]) = query.filter(_.userId.inSet(userIdSeq)).result
}

class GamePlayerTable(tag: Tag) extends Table[models.history.GamePlayer](tag, "game_player") {
  val gameId = column[UUID]("game_id")
  val userId = column[UUID]("user_id")
  val idx = column[Long]("idx")
  val joined = column[LocalDateTime]("joined")

  val modelPrimaryKey = primaryKey("pk_game_player", (gameId, userId))

  override val * = (gameId, userId, idx, joined) <> (
    (models.history.GamePlayer.apply _).tupled,
    models.history.GamePlayer.unapply
  )
}


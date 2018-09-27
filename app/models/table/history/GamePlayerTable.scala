/* Generated File */
package models.table.history

import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID
import services.database.SlickQueryService.imports._

object GamePlayerTable {
  val query = TableQuery[GamePlayerTable]

  def getByPrimaryKey(gameId: UUID, idx: Int) = query.filter(o => o.gameId === gameId && o.idx === idx).result.headOption

  def getByGameId(gameId: UUID) = query.filter(_.gameId === gameId).result
  def getByGameIdSeq(gameIdSeq: Seq[UUID]) = query.filter(_.gameId.inSet(gameIdSeq)).result

  def getByUserId(userId: UUID) = query.filter(_.userId === userId).result
  def getByUserIdSeq(userIdSeq: Seq[UUID]) = query.filter(_.userId.inSet(userIdSeq)).result
}

class GamePlayerTable(tag: Tag) extends Table[models.history.GamePlayer](tag, "game_player") {
  val gameId = column[UUID]("game_id")
  val userId = column[UUID]("user_id")
  val idx = column[Int]("idx")
  val template = column[String]("template")
  val costume = column[String]("costume")
  val attributes = column[Json]("attributes")
  val joined = column[LocalDateTime]("joined")

  val modelPrimaryKey = primaryKey("pk_game_player", (gameId, idx))

  override val * = (gameId, userId, idx, template, costume, attributes, joined) <> (
    (models.history.GamePlayer.apply _).tupled,
    models.history.GamePlayer.unapply
  )
}


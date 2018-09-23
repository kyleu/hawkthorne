/* Generated File */
package models.table.history

import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID
import models.GameHistoryType
import models.table.GameHistoryTypeColumnType.gameHistoryTypeColumnType
import services.database.SlickQueryService.imports._

object GameHistoryTable {
  val query = TableQuery[GameHistoryTable]

  def getByPrimaryKey(id: UUID) = query.filter(_.id === id).result.headOption
  def getByPrimaryKeySeq(idSeq: Seq[UUID]) = query.filter(_.id.inSet(idSeq)).result

  def getByCreator(creator: UUID) = query.filter(_.creator === creator).result
  def getByCreatorSeq(creatorSeq: Seq[UUID]) = query.filter(_.creator.inSet(creatorSeq)).result
}

class GameHistoryTable(tag: Tag) extends Table[models.history.GameHistory](tag, "game_history") {
  val id = column[UUID]("id")
  val t = column[GameHistoryType]("t")
  val options = column[Json]("options")
  val creator = column[Option[UUID]]("creator")
  val started = column[LocalDateTime]("started")

  val modelPrimaryKey = primaryKey("pk_game_history", id)

  override val * = (id, t, options, creator, started) <> (
    (models.history.GameHistory.apply _).tupled,
    models.history.GameHistory.unapply
  )
}


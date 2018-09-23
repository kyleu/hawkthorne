/* Generated File */
package models.table.history

import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID
import models.GameSnapshotType
import models.table.GameSnapshotTypeColumnType.gameSnapshotTypeColumnType
import services.database.SlickQueryService.imports._

object GameSnapshotTable {
  val query = TableQuery[GameSnapshotTable]

  def getByPrimaryKey(id: UUID) = query.filter(_.id === id).result.headOption
  def getByPrimaryKeySeq(idSeq: Seq[UUID]) = query.filter(_.id.inSet(idSeq)).result

  def getByGameId(gameId: UUID) = query.filter(_.gameId === gameId).result
  def getByGameIdSeq(gameIdSeq: Seq[UUID]) = query.filter(_.gameId.inSet(gameIdSeq)).result
}

class GameSnapshotTable(tag: Tag) extends Table[models.history.GameSnapshot](tag, "game_snapshot") {
  val id = column[UUID]("id")
  val gameId = column[Option[UUID]]("game_id")
  val t = column[GameSnapshotType]("t")
  val snapshot = column[Json]("snapshot")
  val occurred = column[LocalDateTime]("occurred")

  val modelPrimaryKey = primaryKey("pk_game_snapshot", id)

  override val * = (id, gameId, t, snapshot, occurred) <> (
    (models.history.GameSnapshot.apply _).tupled,
    models.history.GameSnapshot.unapply
  )
}


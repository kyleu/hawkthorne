/* Generated File */
package models.table.trace

import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID
import models.TraceTypeEnum
import models.table.TraceTypeEnumColumnType.traceTypeEnumColumnType
import services.database.SlickQueryService.imports._

object TraceResultTable {
  val query = TableQuery[TraceResultTable]

  def getByPrimaryKey(id: UUID) = query.filter(_.id === id).result.headOption
  def getByPrimaryKeySeq(idSeq: Seq[UUID]) = query.filter(_.id.inSet(idSeq)).result

  def getByAuthor(author: UUID) = query.filter(_.author === author).result
  def getByAuthorSeq(authorSeq: Seq[UUID]) = query.filter(_.author.inSet(authorSeq)).result
}

class TraceResultTable(tag: Tag) extends Table[models.trace.TraceResult](tag, "trace_result") {
  val id = column[UUID]("id")
  val t = column[TraceTypeEnum]("t")
  val data = column[Json]("data")
  val author = column[Option[UUID]]("author")
  val occurred = column[LocalDateTime]("occurred")

  val modelPrimaryKey = primaryKey("pk_trace_result", id)

  override val * = (id, t, data, author, occurred) <> (
    (models.trace.TraceResult.apply _).tupled,
    models.trace.TraceResult.unapply
  )
}


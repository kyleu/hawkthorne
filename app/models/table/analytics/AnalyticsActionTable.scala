/* Generated File */
package models.table.analytics

import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID
import models.analytics.AnalyticsActionType
import models.table.analytics.AnalyticsActionTypeColumnType.analyticsActionTypeColumnType
import services.database.SlickQueryService.imports._

object AnalyticsActionTable {
  val query = TableQuery[AnalyticsActionTable]

  def getByPrimaryKey(id: UUID) = query.filter(_.id === id).result.headOption
  def getByPrimaryKeySeq(idSeq: Seq[UUID]) = query.filter(_.id.inSet(idSeq)).result

  def getByAuthor(author: UUID) = query.filter(_.author === author).result
  def getByAuthorSeq(authorSeq: Seq[UUID]) = query.filter(_.author.inSet(authorSeq)).result
}

class AnalyticsActionTable(tag: Tag) extends Table[models.analytics.AnalyticsAction](tag, "analytics_action") {
  val id = column[UUID]("id")
  val t = column[AnalyticsActionType]("t")
  val arg = column[Json]("arg")
  val author = column[UUID]("author")
  val status = column[String]("status")
  val occurred = column[LocalDateTime]("occurred")

  val modelPrimaryKey = primaryKey("pk_analytics_action", id)

  override val * = (id, t, arg, author, status, occurred) <> (
    (models.analytics.AnalyticsAction.apply _).tupled,
    models.analytics.AnalyticsAction.unapply
  )
}


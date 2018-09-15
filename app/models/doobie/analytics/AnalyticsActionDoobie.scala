/* Generated File */
package models.doobie.analytics

import cats.data.NonEmptyList
import java.util.UUID
import models.analytics.AnalyticsAction
import models.doobie.DoobieQueries
import models.doobie.analytics.AnalyticsActionTypeDoobie.analyticsActionTypeMeta
import services.database.DoobieQueryService.Imports._

object AnalyticsActionDoobie extends DoobieQueries[AnalyticsAction]("analytics_action") {
  override protected val countFragment = fr"""select count(*) from "analytics_action""""
  override protected val selectFragment = fr"""select "id", "t", "arg", "author", "status", "occurred" from "analytics_action""""

  override protected val columns = Seq("id", "t", "arg", "author", "status", "occurred")
  override protected val searchColumns = Seq("id", "t", "author", "status", "occurred")

  override protected def searchFragment(q: String) = {
    fr""""id"::text = $q or "t"::text = $q or "arg"::text = $q or "author"::text = $q or "status"::text = $q or "occurred"::text = $q"""
  }

  def getByPrimaryKey(id: UUID) = (selectFragment ++ whereAnd(fr"id = $id")).query[Option[AnalyticsAction]].unique
  def getByPrimaryKeySeq(idSeq: NonEmptyList[UUID]) = (selectFragment ++ in(fr"id", idSeq)).query[AnalyticsAction].to[Seq]

  def countByAuthor(author: UUID) = (countFragment ++ whereAnd(fr"author = $author")).query[Int].unique
  def getByAuthor(author: UUID) = (selectFragment ++ whereAnd(fr"author = $author")).query[AnalyticsAction].to[Seq]
  def getByAuthorSeq(authorSeq: NonEmptyList[UUID]) = (selectFragment ++ whereAnd(in(fr"author", authorSeq))).query[AnalyticsAction].to[Seq]
}


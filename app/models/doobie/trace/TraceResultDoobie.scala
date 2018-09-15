/* Generated File */
package models.doobie.trace

import cats.data.NonEmptyList
import java.util.UUID
import models.doobie.DoobieQueries
import models.doobie.TraceTypeEnumDoobie.traceTypeEnumMeta
import models.trace.TraceResult
import services.database.DoobieQueryService.Imports._

object TraceResultDoobie extends DoobieQueries[TraceResult]("trace_result") {
  override val countFragment = fr"""select count(*) from "trace_result""""
  override val selectFragment = fr"""select "id", "t", "data", "author", "occurred" from "trace_result""""

  override val columns = Seq("id", "t", "data", "author", "occurred")
  override val searchColumns = Seq("id", "t", "author", "occurred")

  override def searchFragment(q: String) = {
    fr""""id"::text = $q or "t"::text = $q or "data"::text = $q or "author"::text = $q or "occurred"::text = $q"""
  }

  def getByPrimaryKey(id: UUID) = (selectFragment ++ whereAnd(fr"id = $id")).query[Option[TraceResult]].unique
  def getByPrimaryKeySeq(idSeq: NonEmptyList[UUID]) = (selectFragment ++ in(fr"id", idSeq)).query[TraceResult].to[Seq]

  def countByAuthor(author: UUID) = (countFragment ++ whereAnd(fr"author = $author")).query[Int].unique
  def getByAuthor(author: UUID) = (selectFragment ++ whereAnd(fr"author = $author")).query[TraceResult].to[Seq]
  def getByAuthorSeq(authorSeq: NonEmptyList[UUID]) = (selectFragment ++ whereAnd(in(fr"author", authorSeq))).query[TraceResult].to[Seq]
}


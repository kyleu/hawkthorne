/* Generated File */
package models.doobie.history

import cats.data.NonEmptyList
import java.util.UUID
import models.doobie.DoobieQueries
import models.doobie.GameHistoryTypeDoobie.gameHistoryTypeMeta
import models.history.GameHistory
import services.database.DoobieQueryService.Imports._

object GameHistoryDoobie extends DoobieQueries[GameHistory]("game_history") {
  override val countFragment = fr"""select count(*) from "game_history""""
  override val selectFragment = fr"""select "id", "t", "options", "creator", "started" from "game_history""""

  override val columns = Seq("id", "t", "options", "creator", "started")
  override val searchColumns = Seq("id", "t", "creator", "started")

  override def searchFragment(q: String) = {
    fr""""id"::text = $q or "t"::text = $q or "options"::text = $q or "creator"::text = $q or "started"::text = $q"""
  }

  def getByPrimaryKey(id: UUID) = (selectFragment ++ whereAnd(fr"id = $id")).query[Option[GameHistory]].unique
  def getByPrimaryKeySeq(idSeq: NonEmptyList[UUID]) = (selectFragment ++ in(fr"id", idSeq)).query[GameHistory].to[Seq]

  def countByCreator(creator: UUID) = (countFragment ++ whereAnd(fr"creator = $creator")).query[Int].unique
  def getByCreator(creator: UUID) = (selectFragment ++ whereAnd(fr"creator = $creator")).query[GameHistory].to[Seq]
  def getByCreatorSeq(creatorSeq: NonEmptyList[UUID]) = (selectFragment ++ whereAnd(in(fr"creator", creatorSeq))).query[GameHistory].to[Seq]
}


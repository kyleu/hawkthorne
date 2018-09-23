/* Generated File */
package models.doobie.history

import cats.data.NonEmptyList
import java.util.UUID
import models.doobie.DoobieQueries
import models.doobie.GameSnapshotTypeDoobie.gameSnapshotTypeMeta
import models.history.GameSnapshot
import services.database.DoobieQueryService.Imports._

object GameSnapshotDoobie extends DoobieQueries[GameSnapshot]("game_snapshot") {
  override val countFragment = fr"""select count(*) from "game_snapshot""""
  override val selectFragment = fr"""select "id", "game_id", "t", "snapshot", "occurred" from "game_snapshot""""

  override val columns = Seq("id", "game_id", "t", "snapshot", "occurred")
  override val searchColumns = Seq("id", "game_id", "t", "occurred")

  override def searchFragment(q: String) = {
    fr""""id"::text = $q or "game_id"::text = $q or "t"::text = $q or "snapshot"::text = $q or "occurred"::text = $q"""
  }

  def getByPrimaryKey(id: UUID) = (selectFragment ++ whereAnd(fr"id = $id")).query[Option[GameSnapshot]].unique
  def getByPrimaryKeySeq(idSeq: NonEmptyList[UUID]) = (selectFragment ++ in(fr"id", idSeq)).query[GameSnapshot].to[Seq]

  def countByGameId(gameId: UUID) = (countFragment ++ whereAnd(fr"gameId = $gameId")).query[Int].unique
  def getByGameId(gameId: UUID) = (selectFragment ++ whereAnd(fr"gameId = $gameId")).query[GameSnapshot].to[Seq]
  def getByGameIdSeq(gameIdSeq: NonEmptyList[UUID]) = (selectFragment ++ whereAnd(in(fr"gameId", gameIdSeq))).query[GameSnapshot].to[Seq]
}


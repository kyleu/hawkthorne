/* Generated File */
package models.doobie.history

import cats.data.NonEmptyList
import java.util.UUID
import models.doobie.DoobieQueries
import models.history.GamePlayer
import services.database.DoobieQueryService.Imports._

object GamePlayerDoobie extends DoobieQueries[GamePlayer]("game_player") {
  override val countFragment = fr"""select count(*) from "game_player""""
  override val selectFragment = fr"""select "game_id", "user_id", "idx", "joined" from "game_player""""

  override val columns = Seq("game_id", "user_id", "idx", "joined")
  override val searchColumns = Seq("game_id", "user_id", "idx", "joined")

  override def searchFragment(q: String) = {
    fr""""game_id"::text = $q or "user_id"::text = $q or "idx"::text = $q or "joined"::text = $q"""
  }

  // def getByPrimaryKey(gameId: UUID, userId: UUID) = ???

  def countByGameId(gameId: UUID) = (countFragment ++ whereAnd(fr"gameId = $gameId")).query[Int].unique
  def getByGameId(gameId: UUID) = (selectFragment ++ whereAnd(fr"gameId = $gameId")).query[GamePlayer].to[Seq]
  def getByGameIdSeq(gameIdSeq: NonEmptyList[UUID]) = (selectFragment ++ whereAnd(in(fr"gameId", gameIdSeq))).query[GamePlayer].to[Seq]

  def countByUserId(userId: UUID) = (countFragment ++ whereAnd(fr"userId = $userId")).query[Int].unique
  def getByUserId(userId: UUID) = (selectFragment ++ whereAnd(fr"userId = $userId")).query[GamePlayer].to[Seq]
  def getByUserIdSeq(userIdSeq: NonEmptyList[UUID]) = (selectFragment ++ whereAnd(in(fr"userId", userIdSeq))).query[GamePlayer].to[Seq]
}


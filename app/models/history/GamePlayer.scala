/* Generated File */
package models.history

import java.time.LocalDateTime
import java.util.UUID
import models.result.data.{DataField, DataFieldModel, DataSummary}
import util.JsonSerializers._

object GamePlayer {
  implicit val jsonEncoder: Encoder[GamePlayer] = deriveEncoder
  implicit val jsonDecoder: Decoder[GamePlayer] = deriveDecoder

  def empty(gameId: UUID = UUID.randomUUID, userId: UUID = UUID.randomUUID, idx: Long = 0L, joined: LocalDateTime = util.DateUtils.now) = {
    GamePlayer(gameId, userId, idx, joined)
  }
}

final case class GamePlayer(
    gameId: UUID,
    userId: UUID,
    idx: Long,
    joined: LocalDateTime
) extends DataFieldModel {
  override def toDataFields = Seq(
    DataField("gameId", Some(gameId.toString)),
    DataField("userId", Some(userId.toString)),
    DataField("idx", Some(idx.toString)),
    DataField("joined", Some(joined.toString))
  )

  def toSummary = DataSummary(model = "gamePlayer", pk = Seq(gameId.toString, userId.toString), title = s"$idx / $joined ($gameId, $userId)")
}

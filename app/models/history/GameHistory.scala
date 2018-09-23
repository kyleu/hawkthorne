/* Generated File */
package models.history

import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID
import models.GameHistoryType
import models.result.data.{DataField, DataFieldModel, DataSummary}
import util.JsonSerializers._

object GameHistory {
  implicit val jsonEncoder: Encoder[GameHistory] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameHistory] = deriveDecoder

  def empty(id: UUID = UUID.randomUUID, t: GameHistoryType = GameHistoryType.Client, options: Json = Json.obj(), creator: Option[UUID] = None, started: LocalDateTime = util.DateUtils.now) = {
    GameHistory(id, t, options, creator, started)
  }
}

final case class GameHistory(
    id: UUID,
    t: GameHistoryType,
    options: Json,
    creator: Option[UUID],
    started: LocalDateTime
) extends DataFieldModel {
  override def toDataFields = Seq(
    DataField("id", Some(id.toString)),
    DataField("t", Some(t.toString)),
    DataField("options", Some(options.toString)),
    DataField("creator", creator.map(_.toString)),
    DataField("started", Some(started.toString))
  )

  def toSummary = DataSummary(model = "gameHistory", pk = Seq(id.toString), title = s"$t / $creator / $started ($id)")
}

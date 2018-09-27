/* Generated File */
package models.history

import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID
import models.result.data.{DataField, DataFieldModel, DataSummary}
import util.JsonSerializers._

object GamePlayer {
  implicit val jsonEncoder: Encoder[GamePlayer] = deriveEncoder
  implicit val jsonDecoder: Decoder[GamePlayer] = deriveDecoder

  def empty(gameId: UUID = UUID.randomUUID, userId: UUID = UUID.randomUUID, idx: Int = 0, template: String = "", costume: String = "", attributes: Json = Json.obj(), joined: LocalDateTime = util.DateUtils.now) = {
    GamePlayer(gameId, userId, idx, template, costume, attributes, joined)
  }
}

final case class GamePlayer(
    gameId: UUID,
    userId: UUID,
    idx: Int,
    template: String,
    costume: String,
    attributes: Json,
    joined: LocalDateTime
) extends DataFieldModel {
  override def toDataFields = Seq(
    DataField("gameId", Some(gameId.toString)),
    DataField("userId", Some(userId.toString)),
    DataField("idx", Some(idx.toString)),
    DataField("template", Some(template)),
    DataField("costume", Some(costume)),
    DataField("attributes", Some(attributes.toString)),
    DataField("joined", Some(joined.toString))
  )

  def toSummary = DataSummary(model = "gamePlayer", pk = Seq(gameId.toString, idx.toString), title = s"$userId / $template / $costume / $joined ($gameId, $idx)")
}

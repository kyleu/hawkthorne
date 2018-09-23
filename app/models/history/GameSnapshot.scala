/* Generated File */
package models.history

import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID
import models.GameSnapshotType
import models.result.data.{DataField, DataFieldModel, DataSummary}
import util.JsonSerializers._

object GameSnapshot {
  implicit val jsonEncoder: Encoder[GameSnapshot] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameSnapshot] = deriveDecoder

  def empty(id: UUID = UUID.randomUUID, gameId: Option[UUID] = None, t: GameSnapshotType = GameSnapshotType.Initial, snapshot: Json = Json.obj(), occurred: LocalDateTime = util.DateUtils.now) = {
    GameSnapshot(id, gameId, t, snapshot, occurred)
  }
}

final case class GameSnapshot(
    id: UUID,
    gameId: Option[UUID],
    t: GameSnapshotType,
    snapshot: Json,
    occurred: LocalDateTime
) extends DataFieldModel {
  override def toDataFields = Seq(
    DataField("id", Some(id.toString)),
    DataField("gameId", gameId.map(_.toString)),
    DataField("t", Some(t.toString)),
    DataField("snapshot", Some(snapshot.toString)),
    DataField("occurred", Some(occurred.toString))
  )

  def toSummary = DataSummary(model = "gameSnapshot", pk = Seq(id.toString), title = s"$gameId / $t / $occurred ($id)")
}

/* Generated File */
package models.analytics

import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID
import models.result.data.{DataField, DataFieldModel, DataSummary}
import util.JsonSerializers._

object AnalyticsAction {
  implicit val jsonEncoder: Encoder[AnalyticsAction] = deriveEncoder
  implicit val jsonDecoder: Decoder[AnalyticsAction] = deriveDecoder

  def empty(id: UUID = UUID.randomUUID, t: AnalyticsActionType = AnalyticsActionType.Connect, arg: Json = Json.obj(), author: UUID = UUID.randomUUID, status: String = "", occurred: LocalDateTime = util.DateUtils.now) = {
    AnalyticsAction(id, t, arg, author, status, occurred)
  }
}

final case class AnalyticsAction(
    id: UUID,
    t: AnalyticsActionType,
    arg: Json,
    author: UUID,
    status: String,
    occurred: LocalDateTime
) extends DataFieldModel {
  override def toDataFields = Seq(
    DataField("id", Some(id.toString)),
    DataField("t", Some(t.toString)),
    DataField("arg", Some(arg.toString)),
    DataField("author", Some(author.toString)),
    DataField("status", Some(status)),
    DataField("occurred", Some(occurred.toString))
  )

  def toSummary = DataSummary(model = "analyticsAction", pk = Seq(id.toString), title = s"$t / $author / $status ($id)")
}

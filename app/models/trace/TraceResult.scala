/* Generated File */
package models.trace

import io.circe.Json
import java.time.LocalDateTime
import java.util.UUID
import models.TraceTypeEnum
import models.result.data.{DataField, DataFieldModel, DataSummary}
import util.JsonSerializers._

object TraceResult {
  implicit val jsonEncoder: Encoder[TraceResult] = deriveEncoder
  implicit val jsonDecoder: Decoder[TraceResult] = deriveDecoder

  def empty(id: UUID = UUID.randomUUID, t: TraceTypeEnum = TraceTypeEnum.Client, data: Json = Json.obj(), author: Option[UUID] = None, occurred: LocalDateTime = util.DateUtils.now) = {
    TraceResult(id, t, data, author, occurred)
  }
}

final case class TraceResult(
    id: UUID,
    t: TraceTypeEnum,
    data: Json,
    author: Option[UUID],
    occurred: LocalDateTime
) extends DataFieldModel {
  override def toDataFields = Seq(
    DataField("id", Some(id.toString)),
    DataField("t", Some(t.toString)),
    DataField("data", Some(data.toString)),
    DataField("author", author.map(_.toString)),
    DataField("occurred", Some(occurred.toString))
  )

  def toSummary = DataSummary(model = "traceResult", pk = Seq(id.toString), title = s"$t / $author / $occurred ($id)")
}

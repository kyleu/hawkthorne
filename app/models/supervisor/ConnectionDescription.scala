package models.supervisor

import java.time.LocalDateTime
import java.util.UUID

import util.JsonSerializers._

object ConnectionDescription {
  implicit val jsonEncoder: Encoder[ConnectionDescription] = deriveEncoder
  implicit val jsonDecoder: Decoder[ConnectionDescription] = deriveDecoder
}

final case class ConnectionDescription(id: UUID, userId: UUID, name: String, channel: String, started: LocalDateTime)

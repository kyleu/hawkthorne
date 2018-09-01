package models.supervisor

import java.time.LocalDateTime
import java.util.UUID

import models.options.GameOptions
import util.JsonSerializers._

object GameDescription {
  implicit val jsonEncoder: Encoder[GameDescription] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameDescription] = deriveDecoder
}

final case class GameDescription(id: UUID, options: GameOptions, started: LocalDateTime)

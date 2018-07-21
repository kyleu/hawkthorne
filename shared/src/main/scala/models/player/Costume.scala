package models.player

import models.data.series.Episode
import util.JsonSerializers._

object Costume {
  implicit val jsonEncoder: Encoder[Costume] = deriveEncoder
  implicit val jsonDecoder: Decoder[Costume] = deriveDecoder
}

case class Costume(key: String, episode: Episode, name: String, ow: Int)

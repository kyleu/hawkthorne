package wiki

import java.time.LocalDateTime
import util.JsonSerializers._

object WikiExportResult {
  object File {
    implicit val jsonEncoder: Encoder[File] = deriveEncoder
    implicit val jsonDecoder: Decoder[File] = deriveDecoder
  }

  final case class File(src: String, tgts: Seq[String])

  implicit val jsonEncoder: Encoder[WikiExportResult] = deriveEncoder
  implicit val jsonDecoder: Decoder[WikiExportResult] = deriveDecoder
}

final case class WikiExportResult(
    config: WikiExportConfig,
    started: LocalDateTime = util.DateUtils.now,
    durationNanos: Long = 0L,
    files: Seq[WikiExportResult.File] = Nil
)

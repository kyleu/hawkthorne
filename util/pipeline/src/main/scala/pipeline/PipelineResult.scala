package pipeline

import java.time.LocalDateTime
import util.JsonSerializers._

object PipelineResult {
  object File {
    implicit val jsonEncoder: Encoder[File] = deriveEncoder
    implicit val jsonDecoder: Decoder[File] = deriveDecoder
  }

  final case class File(src: String, tgts: Seq[String])

  implicit val jsonEncoder: Encoder[PipelineResult] = deriveEncoder
  implicit val jsonDecoder: Decoder[PipelineResult] = deriveDecoder
}

final case class PipelineResult(
    config: PipelineConfig,
    started: LocalDateTime = util.DateUtils.now,
    durationNanos: Long = 0L,
    files: Seq[PipelineResult.File] = Nil
)

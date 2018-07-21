package models.animation

import util.JsonSerializers._

object Animation {
  implicit val jsonEncoder: Encoder[Animation] = deriveEncoder
  implicit val jsonDecoder: Decoder[Animation] = deriveDecoder
}

case class Animation(id: String, frames: IndexedSeq[Int], delay: Double = 0.1, loop: Boolean = false) {
  val durationMs = frames.size * delay
  val firstFrame = frames.headOption.getOrElse(throw new IllegalMonitorStateException(s"Empty frames for animation [$id]."))

  private[this] var activeFrame = 0
  private[this] var elapsedMs = 0.0

  private[this] var jitter = 0.0
  def setJitter(j: Double) = jitter = j * frames.size

  def nextFrame(deltaMs: Double) = {
    elapsedMs += deltaMs
    val time = elapsedMs + jitter
    if (frames.size == 1 || (!loop && (time > durationMs))) {
      None
    } else {
      val ret = frames(((time % durationMs) / delay).toInt)
      if (ret == activeFrame) {
        None
      } else {
        activeFrame = ret
        Some(ret)
      }
    }
  }

  def elapsed = elapsedMs
}

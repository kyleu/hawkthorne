package models.animation

case class Animation(id: String, frames: Seq[Int], delay: Double, loop: Boolean = false) {
  val durationMs = frames.size * delay

  def nextFrame(currFrame: Int, millis: Double) = if (!loop && (millis > durationMs)) {
    currFrame
  } else {
    ((millis % durationMs) / delay).toInt
  }

  def isComplete(millis: Double) = (!loop) && (millis > durationMs)
}

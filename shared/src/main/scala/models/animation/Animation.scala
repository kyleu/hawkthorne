package models.animation

case class Animation(id: String, frames: IndexedSeq[Int], delay: Double, loop: Boolean = false, autostart: Boolean = true) {
  val durationMs = frames.size * delay
  val firstFrame = frames.headOption.getOrElse(throw new IllegalMonitorStateException(s"Empty frames for animation [$id]."))

  private[this] var started = autostart
  private[this] var activeFrame = 0
  private[this] var elapsedMs = 0.0

  def nextFrame(deltaMs: Double) = {
    elapsedMs += deltaMs
    if (!loop && (elapsedMs > durationMs)) {
      None
    } else {
      val ret = frames(((elapsedMs % durationMs) / delay).toInt)
      if (ret == activeFrame) {
        None
      } else {
        activeFrame = ret
        Some(ret)
      }
    }
  }

  def elapsed = elapsedMs
  def completedOverage = if (started && (!loop) && (elapsedMs > durationMs)) {
    Some(elapsedMs - durationMs)
  } else {
    None
  }
}

package models.animation

case class Animation(id: String, frames: Seq[Int], delay: Double, loop: Boolean = false, autostart: Boolean = true) {
  val durationMs = frames.size * delay
  private[this] var started = autostart
  private[this] var activeFrame = 0
  private[this] var elapsedMs = 0.0

  def nextFrame(deltaMs: Double) = {
    elapsedMs += deltaMs
    if (!loop && (elapsedMs > durationMs)) {
      None
    } else {
      val ret = ((elapsedMs % durationMs) / delay).toInt
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

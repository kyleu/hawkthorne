package models.animation

import util.JsonSerializers._

import scala.util.Random

object Animation {
  implicit val jsonEncoder: Encoder[Animation] = deriveEncoder
  implicit val jsonDecoder: Decoder[Animation] = deriveDecoder

  def fromString(id: String, s: String, speed: Double, loop: Boolean) = {
    val coords = AnimationCoords.fromString(s)
    val stride = coords.map(_._1).max + 1
    val frames = coords.map(c => c._1 + (c._2 * stride))
    Animation(id = id, frames = frames, delay = speed, loop = loop)
  }
}

final case class Animation(id: String, frames: IndexedSeq[Int], delay: Double, loop: Boolean, archetype: Boolean = true) {
  val durationMs = frames.size * delay
  val firstFrame = frames.headOption.getOrElse(throw new IllegalMonitorStateException(s"Empty frames for animation [$id]."))

  private[this] var activeFrame = 0
  private[this] var elapsedMs = 0.0

  private[this] var jitter = 0.0
  def setJitter(j: Double) = jitter = j * frames.size

  def nextFrame(deltaMs: Double) = {
    if (archetype) { throw new IllegalStateException(s"Animation [$id] is an archetype, and cannot be started.") }
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

  def newCopy = {
    if (!archetype) { throw new IllegalStateException(s"Use `copy` to get a clone of non-archetype [$id]") }
    val ret = Animation(id = id, frames = frames, delay = delay, loop = loop, archetype = false)
    if (jitter != 0) { ret.setJitter(Random.nextDouble) }
    ret
  }
}

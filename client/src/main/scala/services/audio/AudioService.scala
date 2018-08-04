package services.audio

import com.definitelyscala.phaserce.{Game, Sound}
import models.asset.Asset

class AudioService(prefix: String) {
  private[this] var volume = 10
  private[this] var game: Option[Game] = None
  private[this] val cache = collection.mutable.HashMap.empty[String, Sound]

  def reset(g: Game) = {
    cache.values.foreach(_.destroy(true))
    cache.clear()
    game = Some(g)
  }

  def setVolume(vol: Int) = volume = Math.min(Math.max(vol, 0), 10)

  def asset(key: String) = Asset.Audio(s"$prefix.$key", s"audio/$prefix/$key.ogg")

  def load(key: String) = cache.getOrElseUpdate(key, {
    util.Logging.debug(s"Loading [$prefix.$key].")
    game.getOrElse(throw new IllegalStateException("Audio not initialized.")).add.audio(s"$prefix.$key")
  })

  def play(key: String, vol: Double = 1.0, loop: Boolean = false) = {
    val newVol = vol / 10.0 * volume
    load(key).play(volume = newVol, loop = loop)
    util.Logging.debug(s"Playing [$prefix.$key] at volume [$newVol], loop = $loop")
  }

  def stop(key: String) = {
    util.Logging.debug(s"Stopping [$prefix.$key].")
    load(s"$prefix.$key").stop()
  }
}

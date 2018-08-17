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

  def play(key: String, vol: Double = 1.0, loop: Boolean = false): Sound = play(load(key), vol = vol, loop = loop)
  def play(sound: Sound, vol: Double, loop: Boolean): Sound = {
    val newVol = vol / 10.0 * volume
    util.Logging.debug(s"Playing [$prefix.${sound.name}] at volume [$newVol], loop = $loop")
    sound.play(volume = newVol, loop = loop)
  }
}

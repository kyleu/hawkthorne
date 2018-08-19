package models.settings

import models.options.GameOptions
import org.scalajs.dom
import services.audio.{MusicService, SoundEffectService}
import util.JsonSerializers._

object ClientSettings {
  private[this] var current: Option[ClientSettings] = None
  private[this] val storageKey = "hawkthorne.settings"

  implicit val jsonEncoder: Encoder[ClientSettings] = deriveEncoder
  implicit val jsonDecoder: Decoder[ClientSettings] = deriveDecoder

  def getSettings = current.getOrElse(throw new IllegalStateException("No registered settings"))

  def load() = {
    val s = Option(dom.window.localStorage.getItem(storageKey)) match {
      case Some(rsp) =>
        val json = parseJson(rsp, Some(s"Invalid storage json"))
        json.as[ClientSettings] match {
          case Right(x) => x
          case Left(x) => throw new IllegalStateException(s"Invalid storage content [${rsp.asJson.spaces2}]: ${x.getMessage}", x)
        }
      case None =>
        val s = ClientSettings()
        save(s)
        s
    }
    current = Some(s)
    util.Logging.debug("Settings loaded successfully.")
    s
  }

  def applySettings(s: ClientSettings) = {
    util.Logging.info(s"Applying settings [$s].")
    MusicService.setVolume(s.music)
    SoundEffectService.setVolume(s.sfx)
    s
  }

  def loadAndApply() = applySettings(load())

  def save(s: ClientSettings): Unit = if (!current.contains(s)) {
    dom.window.localStorage.setItem(storageKey, s.asJson.spaces2)
    current = Some(s)
    loadAndApply()
  }
}

case class ClientSettings(
    music: Int = 10,
    sfx: Int = 10,
    defaultOptions: GameOptions = GameOptions(),
    showTutorials: Boolean = true,
    showFps: Boolean = false,
    fullscreen: Boolean = false
) {
  override def toString = this.asJson.spaces2
}

package models.settings

import models.analytics.AnalyticsActionType
import models.game.GameOptions
import org.scalajs.dom
import services.audio.{MusicService, SoundEffectService}
import services.socket.AnalyticsService
import util.JsonSerializers._

case class ClientSettings(
    music: Int = 10,
    sfx: Int = 10,
    defaultOptions: GameOptions = GameOptions(),
    showTutorials: Boolean = true,
    showFps: Boolean = false,
    fullscreen: Boolean = false
)

object ClientSettings {
  private[this] var current: Option[ClientSettings] = None
  private[this] val storageKey = "hawkthorne.settings"

  implicit val jsonEncoder: Encoder[ClientSettings] = deriveEncoder
  implicit val jsonDecoder: Decoder[ClientSettings] = deriveDecoder

  def getSettings = current.getOrElse(throw new IllegalStateException("No registered settings"))

  def load() = {
    val s = Option(dom.window.localStorage.getItem(storageKey)) match {
      case Some(rsp) => parseJson(rsp) match {
        case Right(json) => json.as[ClientSettings] match {
          case Right(x) => x
          case Left(x) => throw new IllegalStateException(s"Invalid storage content [  ${rsp.asJson.spaces2}  ]: ${x.getMessage}", x)
        }
        case Left(x) => throw new IllegalStateException(s"Invalid storage json [  ${rsp.asJson.spaces2}  ]: ${x.getMessage}", x)
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

  def loadAndApply() = {
    val s = load()
    util.Logging.info(s"Applying settings [$s].")
    MusicService.setVolume(s.music)
    SoundEffectService.setVolume(s.sfx)
    s
  }

  def save(s: ClientSettings) = {
    val json = s.asJson
    dom.window.localStorage.setItem(storageKey, json.spaces2)
    AnalyticsService.send(AnalyticsActionType.OptionsSet, json)
    current = Some(s)
    s
  }
}

package models.settings

import java.util.UUID

import org.scalajs.dom
import util.JsonSerializers._
import util.Logging

object ClientSettings {
  private[this] var current: Option[ClientSettings] = None
  private[this] val storageKey = "settings"

  implicit val jsonEncoder: Encoder[ClientSettings] = deriveEncoder
  implicit val jsonDecoder: Decoder[ClientSettings] = deriveDecoder

  private[this] def empty(userId: UUID) = ClientSettings(userId, music = 10, sfx = 10, extraThing = "Default", toggle = true)

  def getSettings = current.getOrElse(throw new IllegalStateException("No registered settings"))

  def load() = {
    val s = Option(dom.window.localStorage.getItem("settings")) match {
      case Some(rsp) => rsp.asJson.as[ClientSettings].right.getOrElse(throw new IllegalStateException(s"Invalid storage response [$rsp]"))
      case None => empty(UUID.randomUUID)
    }
    current = Some(s)
    Logging.info(s"Loaded settings [$s]")
    s
  }

  def save(s: ClientSettings) = {
    dom.window.localStorage.setItem(storageKey, s.asJson.spaces2)
    Logging.info(s"Saved settings [$s]")
    current = Some(s)
    s
  }
}

case class ClientSettings(
    userId: UUID,
    music: Int,
    sfx: Int,
    extraThing: String,
    toggle: Boolean
)

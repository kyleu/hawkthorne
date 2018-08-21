package models.component

import com.definitelyscala.phaserce.Game
import services.audio.SoundEffectService

object BaseModal {
  val speed = 200
}

class BaseModal(
    override val game: Game,
    val name: String,
    val maxWidth: Int = 256,
    val maxHeight: Int = 72
) extends BaseComponent {
  private[this] var width = 6.0
  private[this] var height = 6.0

  private[this] var targetWidth = maxWidth.toDouble
  private[this] var targetHeight = maxHeight.toDouble

  private[this] var openCallback: Option[() => Unit] = None
  private[this] var closeCallback: Option[() => Unit] = None

  private[this] var needsUpdate = true
  private[this] var opening = false
  private[this] var closing = false

  def open(onOpen: () => Unit) = {
    util.Logging.info("Opening!")
    SoundEffectService.play("menu.expand")
    targetWidth = maxWidth.toDouble
    targetHeight = maxHeight.toDouble
    opening = true
    closing = false
    openCallback.foreach(_ => throw new IllegalStateException("Previous open has not been cleared."))
    openCallback = Some(onOpen)
    update(0)
  }

  def close(onClose: () => Unit) = {
    util.Logging.info("Closing!")
    SoundEffectService.play("menu.close")
    targetWidth = 6
    targetHeight = 6
    opening = false
    closing = true
    closeCallback.foreach(_ => throw new IllegalStateException("Previous close has not been cleared."))
    closeCallback = Some(onClose)
    update(0)
  }

  override def update(deltaMs: Double) = {
    val done = width == targetWidth && height == targetHeight
    if (done) {
      if (opening) {
        opening = false
        openCallback.foreach(_())
        openCallback = None
      }
      if (closing) {
        closing = false
        closeCallback.foreach(_())
        closeCallback = None
      }
    } else {
      val delta = deltaMs * BaseModal.speed.toDouble
      if (opening) {
        util.Logging.info(s"Opening Delta: [$delta]")
        width = Math.min(targetWidth, width + delta)
        height = Math.min(targetHeight, height + delta)
      }
      if (closing) {
        util.Logging.info(s"Closing Delta: [$delta]")
        width = Math.max(targetWidth, width - delta)
        height = Math.max(targetHeight, height - delta)
      }
      needsUpdate = true
    }

    if (needsUpdate) {
      needsUpdate = false
      util.Logging.info(s"Updating modal content: Width [$width/$targetWidth], Height: [$height/$targetHeight]")
    }
  }

  private[this] var _x = 0.0 // TODO replace with group call
  override def x = _x
  override def x_=(newX: Double) = _x = newX

  private[this] var _y = 0.0 // TODO replace with group call
  override def y = _y
  override def y_=(newY: Double) = _y = newY

  private[this] var _visible = true // TODO replace with group call
  override def visible = _visible
  override def visible_=(v: Boolean) = _visible = v

  override def destroy() = {} // TODO Fix, asshole
}

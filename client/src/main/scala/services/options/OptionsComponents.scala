package services.options

import com.definitelyscala.phaserce.Game
import models.component.{Checkbox, Menu, RangeMeter}
import models.settings.ClientSettings

class OptionsComponents(game: Game, menu: Menu, settings: ClientSettings) {
  private[this] def checkbox(idx: Int, name: String) = {
    val newY = (menu.margin + menu.fontOffset + (menu.lineHeight * idx)).toInt
    val ret = new Checkbox(game, menu.group, name, 244, newY)
    ret.visible = false
    ret
  }
  val fullscreenCheckbox = checkbox(0, "fullscreen")
  fullscreenCheckbox.checked = settings.fullscreen
  val fpsCheckbox = checkbox(1, "fps")
  fpsCheckbox.checked = settings.showFps

  val hardcoreCheckbox = checkbox(0, "hardcore")
  hardcoreCheckbox.checked = settings.defaultOptions.hardcore
  val tutorialCheckbox = checkbox(1, "tutorial")
  tutorialCheckbox.checked = settings.showTutorials

  private[this] def meter(idx: Int, name: String) = {
    val initialY = (menu.margin + menu.fontOffset + (menu.lineHeight * idx)).toInt
    val ret = new RangeMeter(game = game, parent = menu.group, name = name, initialX = 205, initialY = initialY)
    ret.visible = false
    ret
  }
  val musicMeter = meter(0, "music")
  musicMeter.setting = settings.music
  val sfxMeter = meter(1, "sfx")
  sfxMeter.setting = settings.sfx

  def switchToGame() = {
    hardcoreCheckbox.visible = true
    tutorialCheckbox.visible = true
    musicMeter.visible = false
    sfxMeter.visible = false
    fullscreenCheckbox.visible = false
    fpsCheckbox.visible = false
  }

  def switchToAudio() = {
    hardcoreCheckbox.visible = false
    tutorialCheckbox.visible = false
    musicMeter.visible = true
    sfxMeter.visible = true
    fullscreenCheckbox.visible = false
    fpsCheckbox.visible = false
  }

  def switchToVideo() = {
    hardcoreCheckbox.visible = false
    tutorialCheckbox.visible = false
    musicMeter.visible = false
    sfxMeter.visible = false
    fullscreenCheckbox.visible = true
    fpsCheckbox.visible = true
  }

  def switchToMain() = {
    hardcoreCheckbox.visible = false
    tutorialCheckbox.visible = false
    musicMeter.visible = false
    sfxMeter.visible = false
    fullscreenCheckbox.visible = false
    fpsCheckbox.visible = false
  }
}

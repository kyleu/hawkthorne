package services.options

import com.definitelyscala.phaserce.Game
import models.gui.{Checkbox, Menu, RangeMeter}
import models.settings.ClientSettings

class OptionsComponents(game: Game, menu: Menu, initialSettings: ClientSettings) {
  private[this] var lastSettings = initialSettings

  private[this] def checkbox(idx: Int, name: String, onChange: Boolean => Unit) = {
    val newY = (menu.margin + menu.fontOffset + (menu.lineHeight * idx)).toInt
    val ret = new Checkbox(game = game, group = menu.group, name = name, initialX = 244, initialY = newY, onChange = onChange)
    ret.visible = false
    ret
  }

  def update(newSettings: ClientSettings) = {
    ClientSettings.save(newSettings)
    lastSettings = newSettings
  }

  val fullscreenCheckbox = checkbox(0, "fullscreen", v => update(lastSettings.copy(fullscreen = v)))
  fullscreenCheckbox.checked = lastSettings.fullscreen

  val fpsCheckbox = checkbox(1, "fps", v => update(lastSettings.copy(showFps = v)))
  fpsCheckbox.checked = lastSettings.showFps

  val hardcoreCheckbox = checkbox(0, "hardcore", v => update(lastSettings.copy(defaultOptions = lastSettings.defaultOptions.copy(hardcore = v))))
  hardcoreCheckbox.checked = lastSettings.defaultOptions.hardcore

  val tutorialCheckbox = checkbox(1, "tutorial", v => update(lastSettings.copy(showTutorials = v)))
  tutorialCheckbox.checked = lastSettings.showTutorials

  private[this] def meter(idx: Int, name: String, onChange: Int => Unit) = {
    val initialY = (menu.margin + menu.fontOffset + (menu.lineHeight * idx)).toInt
    val ret = new RangeMeter(game = game, parent = menu.group, name = name, initialX = 205, initialY = initialY, onChange = onChange)
    ret.visible = false
    ret
  }
  val musicMeter = meter(0, "music", v => update(lastSettings.copy(music = v)))
  musicMeter.setting = lastSettings.music

  val sfxMeter = meter(1, "sfx", v => update(lastSettings.copy(sfx = v)))
  sfxMeter.setting = lastSettings.sfx

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

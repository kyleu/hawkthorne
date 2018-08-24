package services.options

import com.definitelyscala.phaserce.Game
import models.analytics.AnalyticsActionType
import models.gui.Menu
import models.input.{MenuAction, PointerAction}
import models.settings.ClientSettings
import services.socket.AnalyticsService

class OptionsMenu(game: Game, onExit: () => Unit) {
  private[this] val size = 380.0
  private[this] var zoom = 1.0
  private[this] var inMain = true

  private[this] val menu = Menu(
    game = game, name = "options.menu", fontKey = "big", arrowKey = "options.menu.arrow", backgroundKey = "options.menu.bg",
    width = 272, height = 176, margin = 12.0, lineHeight = 26.0, fontColor = 0x000000, fontOffset = 4.0
  )
  game.stage.add(menu.group)

  private[this] val comps = new OptionsComponents(game, menu, ClientSettings.getSettings)

  private[this] def onSelect(key: String): Unit = key match {
    case "costume" => util.Logging.info("TODO")
    case "game" => switchToGame()
    case "audio" => switchToAudio()
    case "video" => switchToVideo()
    case "credits" => util.Logging.info("TODO")

    case "hardcore" => comps.hardcoreCheckbox.toggle()
    case "tutorials" => comps.tutorialCheckbox.toggle()

    case "music" => comps.musicMeter.increment()
    case "sfx" => comps.sfxMeter.increment()

    case "fullscreen" => comps.fullscreenCheckbox.toggle()
    case "fps" => comps.fpsCheckbox.toggle()

    case "back" if inMain =>
      AnalyticsService.send(AnalyticsActionType.OptionsSet, util.JsonSerializers.serialize(ClientSettings.getSettings))
      onExit()
    case "back" => switchToMain()

    case _ => throw new IllegalStateException(s"Unhandled option menu key [$key].")
  }

  private[this] def action(act: (String, String)) = act._1 -> (() => onSelect(act._2))
  private[this] def actionSingle(act: String) = action(act -> act.toLowerCase)

  private[this] val mainActs = IndexedSeq("Costume", "Game", "Audio", "Video", "Credits", "Back").map(actionSingle)
  private[this] def switchToMain() = {
    inMain = true
    menu.setOptions(mainActs)
    comps.switchToMain()
  }

  switchToMain()

  private[this] val gameActs = IndexedSeq("Hardcore", "Tutorials", "Back").map(actionSingle)
  private[this] def switchToGame() = {
    inMain = false
    menu.setOptions(gameActs)
    comps.switchToGame()
    None
  }

  private[this] val audioActs = IndexedSeq("Music", "SFX", "Back").map(actionSingle)
  private[this] def switchToAudio() = {
    inMain = false
    menu.setOptions(audioActs)
    comps.switchToAudio()
    None
  }

  private[this] val videoActs = IndexedSeq("Fullscreen" -> "fullscreen", "Show FPS" -> "fps", "Back" -> "back").map(action)
  private[this] def switchToVideo() = {
    inMain = false
    menu.setOptions(videoActs)
    comps.switchToVideo()
    None
  }

  def menuActions(acts: Seq[MenuAction]) = acts.foreach(menu.onMenuAction)

  def onPointer(act: PointerAction) = menu.onPointer(act, zoom)

  def resize(width: Int, height: Int) = {
    zoom = Math.min(width / size, height / size)
    menu.group.scale.set(zoom, zoom)
    menu.x = (width - (menu.background.width * zoom)) / 2
    menu.y = (height - (menu.background.height * zoom)) / 2
  }

  def destroy() = menu.destroy()
}

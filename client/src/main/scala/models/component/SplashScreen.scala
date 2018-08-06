package models.component

import com.definitelyscala.phaserce.{Game, Point}
import util.PhaserUtils

object SplashScreen {
  def show(game: Game, x: Int = 0, y: Int = 0) = {
    val backdrop = PhaserUtils.makeBackdrop(game = game, width = game.width, height = game.height)
    game.add.existing(backdrop)

    val splash = game.add.sprite(game.width / 2, game.height / 2, "splash")
    splash.anchor = util.PhaserUtils.centerPoint
    val splashScale = game.width * 0.6 / splash.width
    splash.scale.set(splashScale, splashScale)

    val progress = game.add.sprite(game.width / 2, (game.height / 2) + (100 * splashScale), "progress", 16)
    progress.anchor = util.PhaserUtils.centerPoint
    progress.scale.set(splashScale, splashScale)

    progress -> (() => {
      game.world.removeChild(backdrop)
      game.world.removeChild(splash)
      game.world.removeChild(progress)
      ()
    })
  }
}

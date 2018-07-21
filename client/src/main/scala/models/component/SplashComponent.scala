package models.component

import com.definitelyscala.phaserce._

object SplashComponent {
  def show(game: Game, x: Int = 0, y: Int = 0) = {
    val solidBlack = game.make.bitmapData(1, 1)
    solidBlack.fill(0, 0, 0)

    val backdrop = game.add.sprite(0, 0, solidBlack)
    backdrop.width = game.width
    backdrop.height = game.height

    val splash = game.add.sprite(game.width / 2, game.height / 2, "splash")
    splash.anchor = new Point(0.5, 0.5)
    val splashScale = game.width * 0.6 / splash.width
    splash.scale = new Point(splashScale, splashScale)

    val progress = game.add.sprite(game.width / 2, (game.height / 2) + (100 * splashScale), "progress", 16)
    progress.anchor = new Point(0.5, 0.5)
    progress.scale = new Point(splashScale, splashScale)

    () => {
      game.world.removeChild(backdrop)
      game.world.removeChild(splash)
      game.world.removeChild(progress)
      ()
    }
  }
}

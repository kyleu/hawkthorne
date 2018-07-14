package models.phaser

import com.definitelyscala.phaserce._

class SplashComponent(game: Game) {
  val group = new Group(game, name = "group.splash")

  val solidBlack = game.make.bitmapData(1, 1)
  solidBlack.fill(0, 0, 0)

  val backdrop = new Sprite(game, 0, 0, solidBlack)
  backdrop.name = "backdrop"
  backdrop.width = game.width
  backdrop.height = game.height
  group.add(backdrop)

  val splash = new Sprite(game, game.width / 2, game.height / 2, "splash")
  splash.name = "splash"
  splash.anchor = new Point(0.5, 0.5)
  val splashScale = game.width * 0.6 / splash.width
  splash.scale = new Point(splashScale, splashScale)
  group.add(splash)

  val progress = new Sprite(game, game.width / 2, (game.height / 2) + (100 * splashScale), "progress", 16)
  progress.name = "progress.bar"
  progress.anchor = new Point(0.5, 0.5)
  progress.scale = new Point(splashScale, splashScale)
  group.add(progress)

  def show() = {
    game.add.existing(group)
  }

  def hide() = {
    game.world.removeChild(group)
  }
}

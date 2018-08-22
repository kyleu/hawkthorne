package services.state

import com.definitelyscala.phaserce.{Game, Point, Tilemap}
import models.asset._
import util.PhaserUtils

object LoadingState {
  val prefix = "/assets/game/"

  def load(asset: Asset, game: Game) = asset match {
    case a: Asset.Audio if !game.cache.checkSoundKey(a.key) => Some(game.load.audio(key = a.key, urls = prefix + a.path))
    case a: Asset.Audio => None
    case i: Asset.Image if !game.cache.checkTextureKey(i.key) => Some(game.load.image(key = i.key, url = prefix + i.path))
    case i: Asset.Image => None
    case t: Asset.Tilemap if !game.cache.checkTilemapKey(t.key) =>
      Some(game.load.tilemap(key = t.key, url = prefix + t.path, data = util.NullUtils.inst, format = Tilemap.TILED_JSON))
    case t: Asset.Tilemap => None
    case s: Asset.Spritesheet if !game.cache.checkTextureKey(s.key) =>
      Some(game.load.spritesheet(key = s.key, url = prefix + s.path, frameWidth = s.width.toDouble, frameHeight = s.height.toDouble))
    case s: Asset.Spritesheet => None
  }
}

class LoadingState(
    next: GameState,
    phaser: Game,
    assets: Seq[Asset]
) extends GameState("initial", phaser) {
  override def create(game: Game) = {
    val s = game.add.sprite(game.width / 2, game.height / 2, "splash")
    s.anchor.set(0.5, 0.5)
    val scale = game.width * 0.6 / s.width
    s.scale.set(scale, scale)

    val progress = game.add.sprite(game.width / 2, (game.height / 2) + (100 * scale), "progress", 0)
    progress.anchor = new Point(0.5, 0.5)
    progress.scale.set(scale, scale)

    game.state.add(next.key, next, autoStart = false)

    assets.foreach(LoadingState.load(_, game))
    var filesCompleted = 0

    PhaserUtils.addToSignal(game.load.onFileComplete, _ => {
      filesCompleted += 1
      progress.frame = ((filesCompleted / assets.size.toDouble) * 17).toInt
    })
    PhaserUtils.addToSignal(game.load.onLoadComplete, _ => {
      progress.frame = 16
      game.load.onFileComplete.removeAll()
      game.load.onLoadComplete.removeAll()
      game.state.start(next.key, clearWorld = true, clearCache = false)
    })
    game.load.start()
  }
}

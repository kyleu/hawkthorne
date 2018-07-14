package services.state

import com.definitelyscala.phaserce.{Game, Point, Tilemap}
import util.NullUtils

object LoadingState {
  val prefix = "/assets/game/"

  case class Assets(
      audio: Seq[(String, String)] = Nil,
      images: Seq[(String, String)] = Nil,
      spritesheets: Seq[(String, String, Int, Int)] = Nil,
      tilemaps: Seq[(String, String)] = Nil
  ) {
    lazy val size = audio.size + images.size + spritesheets.size + tilemaps.size
    def plus(o: Assets) = Assets(
      audio = audio ++ o.audio, images = images ++ o.images, spritesheets = spritesheets ++ o.spritesheets, tilemaps = tilemaps ++ o.tilemaps
    )
  }
}

class LoadingState(
    next: GameState,
    phaser: Game,
    assets: LoadingState.Assets
) extends GameState("initial", phaser) {
  override def create(game: Game) = {
    val s = game.add.sprite(game.width / 2, game.height / 2, "splash")
    s.anchor = new Point(0.5, 0.5)
    val scale = game.width * 0.6 / s.width
    s.scale = new Point(scale, scale)

    val progress = game.add.sprite(game.width / 2, (game.height / 2) + (100 * scale), "progress", 0)
    progress.anchor = new Point(0.5, 0.5)
    progress.scale = new Point(scale, scale)

    game.state.add(next.key, next, autoStart = false)

    assets.audio.foreach(a => game.load.audio(a._1, LoadingState.prefix + a._2))
    assets.images.foreach(s => game.load.image(s._1, LoadingState.prefix + s._2))
    assets.spritesheets.foreach(s => game.load.spritesheet(s._1, LoadingState.prefix + s._2, s._3.toDouble, s._4.toDouble))
    assets.tilemaps.foreach(t => game.load.tilemap(t._1, LoadingState.prefix + t._2, null, Tilemap.TILED_JSON))

    var totalFiles = (assets.size + 1).toDouble
    var filesCompleted = 0

    game.load.onFileComplete.add(() => {
      filesCompleted += 1
      progress.frame = ((filesCompleted / totalFiles) * 17).toInt
    }, NullUtils.inst, 1.0)
    game.load.onLoadComplete.add(() => {
      game.load.onFileComplete.removeAll()
      game.load.onLoadComplete.removeAll()
      game.state.start(next.key, clearWorld = true, clearCache = false)
    }, NullUtils.inst, 1.0)
    game.load.start()
  }
}

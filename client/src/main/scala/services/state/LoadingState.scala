package services.state

import com.definitelyscala.phaserce.{Game, Point, Tilemap}
import util.NullUtils

object LoadingState {
  val prefix = "/assets/game/"
}

class LoadingState(
    next: GameState,
    audio: Seq[(String, String)] = Nil,
    images: Seq[(String, String)] = Nil,
    spritesheets: Seq[(String, String, Int, Int)] = Nil,
    tilemaps: Seq[(String, String)] = Nil
) extends GameState("initial") {
  override def create(game: Game) = {
    val s = game.add.sprite(game.width / 2, game.height / 2, "splash")
    s.anchor = new Point(0.5, 0.5)
    val scale = game.width * 0.6 / s.width
    s.scale = new Point(scale, scale)

    val progress = game.add.sprite(game.width / 2, (game.height / 2) + (100 * scale), "progress", 0)
    progress.anchor = new Point(0.5, 0.5)
    progress.scale = new Point(scale, scale)

    game.state.add(next.key, next, autoStart = false)

    audio.foreach(a => game.load.audio(a._1, LoadingState.prefix + a._2))
    images.foreach(s => game.load.image(s._1, LoadingState.prefix + s._2))
    spritesheets.foreach(s => game.load.spritesheet(s._1, LoadingState.prefix + s._2, s._3.toDouble, s._4.toDouble))
    tilemaps.foreach(t => game.load.tilemap(t._1, LoadingState.prefix + t._2, null, Tilemap.TILED_JSON))

    var totalFiles = (images.size + spritesheets.size + audio.size + tilemaps.size).toDouble
    var filesCompleted = 0

    game.load.onFileComplete.add(() => {
      filesCompleted += 1
      progress.frame = ((filesCompleted / totalFiles) * 17).toInt
    }, NullUtils.inst, 1.0)
    game.load.onLoadComplete.add(() => {
      game.state.start(next.key, clearWorld = true, clearCache = false)
    }, NullUtils.inst, 1.0)
    game.load.start()
  }
}

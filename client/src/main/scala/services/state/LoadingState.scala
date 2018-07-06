package services.state

import com.definitelyscala.phaserce.{Game, Point}
import models.character.Characters
import util.NullUtils

class LoadingState(next: GameState) extends GameState("initial") {
  private[this] var elapsedSeconds = 0.0

  override def create(game: Game) = {
    val s = game.add.sprite(game.width / 2, game.height / 2, "splash")
    s.anchor = new Point(0.5, 0.5)
    val scale = game.width * 0.6 / s.width
    s.scale = new Point(scale, scale)

    game.state.add(next.key, next, autoStart = false)

    val urls = Characters.allCostumes.map(c => s"${c._1.id}.${c._2.key}" -> s"/assets/game/images/character/${c._1.id}/${c._2.key}.png")
    urls.foreach(url => game.load.spritesheet(url._1, url._2, 48, 48))

    game.load.onFileComplete.add(() => println("File loaded!"), NullUtils.inst, 1.0)
    game.load.onLoadComplete.add(() => {
      game.state.start(next.key, clearWorld = true, clearCache = false)
    }, NullUtils.inst, 1.0)
    game.load.start()
  }
}

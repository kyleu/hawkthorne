package services.state

import com.definitelyscala.phaserce.{Game, Sound}
import models.asset.Asset
import models.component.VerticalParticles
import models.font.Font
import services.input.InputService

object OptionsState {
  def load(phaser: Game, inputService: InputService, debug: Boolean) = new LoadingState(
    next = new OptionsState(phaser = phaser, inputService = inputService, debug = debug), phaser = phaser,
    assets = Font.assets :+ Asset.music("daybreak")
  )
}

class OptionsState(phaser: Game, inputService: InputService, debug: Boolean) extends GameState("test", phaser) {
  private[this] var particles: Option[VerticalParticles] = None
  private[this] var music: Option[Sound] = None

  override def create(game: Game) = {
    Font.reset()
    music = Some(game.add.audio(key = "music.daybreak", loop = true))
    music.foreach(_.play())
    particles = Some(new VerticalParticles(game))
  }

  override def update(game: Game) = {
    val dt = game.time.physicsElapsed
    particles.foreach(_.update(dt))
    inputService.update(dt)
  }

  override def shutdown(game: Game) = {
    music.foreach(_.stop())
    super.shutdown(game)
  }
}

package services.state

import com.definitelyscala.phaserce.Game
import models.asset.Asset
import models.player.{Player, PlayerSprite}
import services.input.InputService

object TestState {
  def load(phaser: Game) = new LoadingState(
    next = new TestState(phaser),
    phaser = phaser,
    assets = Seq(Asset.Spritesheet(Player.default.spritesheet._1, Player.default.spritesheet._2, Player.default.spritesheet._3, Player.default.spritesheet._4))
  )
}

class TestState(phaser: Game) extends GameState("test", phaser) {
  private[this] lazy val group = game.add.group(name = s"test.group")
  private[this] lazy val player = new PlayerSprite(game, group, Player.default, game.width.toInt / 2, game.height.toInt / 2)
  private[this] lazy val cursors = game.input.keyboard.createCursorKeys()
  private[this] var input: Option[InputService] = None

  override def create(game: Game) = {
    player.toString
    cursors.toString
    input = Some(new InputService(phaser, IndexedSeq(player)))
  }

  override def update(game: Game) = {
    input.foreach(_.update(0L))
  }
}

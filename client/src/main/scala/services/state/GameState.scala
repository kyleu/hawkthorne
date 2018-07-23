package services.state

import com.definitelyscala.phaserce.{Game, State}

abstract class GameState(k: String, phaser: Game) extends State {
  key = k

  final override def resize(width: Double, height: Double) = {
    onResize(width.toInt, height.toInt)
    super.resize(width, height)
  }

  def onResize(width: Int, height: Int) = {}
}

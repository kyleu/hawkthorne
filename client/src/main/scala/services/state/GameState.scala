package services.state

import com.definitelyscala.phaserce.{Game, State}
import models.ResponseMessage

abstract class GameState(k: String, phaser: Game) extends State {
  key = k

  def onMessage(msg: ResponseMessage) = util.Logging.warn(s"Received unknown response message of type [${msg.getClass.getSimpleName}].")

  final override def resize(width: Double, height: Double) = {
    onResize(width.toInt, height.toInt)
    super.resize(width, height)
  }

  def onResize(width: Int, height: Int) = {}
}

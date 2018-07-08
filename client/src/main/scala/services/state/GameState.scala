package services.state

import com.definitelyscala.phaserce.{Game, State}

class GameState(k: String, phaser: Game) extends State {
  key = k
}

package services.event

import com.definitelyscala.phaserce.Game
import services.socket.{SocketConnection, UserManager}

case class HawkthorneSystem(socket: SocketConnection, phaser: Game, startMs: Long) {
  util.Logging.info(s"Hawkthorne system started in [${System.currentTimeMillis - startMs}ms]")

  UserManager.setSystemReady() // TODO Remove
}

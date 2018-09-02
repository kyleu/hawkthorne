package services.game

import java.util.UUID

import models.game.cmd.GameCommand
import models.game.msg.GameMessage
import models.options.{GameOptions, SystemOptions}
import services.game.GameInstanceDebug._
import services.map.GameMap

object GameInstance {
  import util.JsonSerializers._

  implicit val jsonEncoder: Encoder[GameInstance] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameInstance] = deriveDecoder
}

final case class GameInstance(gameId: UUID, options: GameOptions, map: GameMap) extends GameInstancePlayers {
  private[this] var running = false

  private[this] var elapsedSeconds = 0.0
  val bounds = (options.map.width * SystemOptions.tileSize) -> (options.map.height * SystemOptions.tileSize)

  def start(initialCommands: Seq[GameCommand]) = {
    if (running) { throw new IllegalStateException(s"Game [$gameId] already started.") }
    running = true
    apply(update(0, initialCommands: _*))
    this
  }

  def stop() = {
    if (!running) { throw new IllegalStateException(s"Game [$gameId] already stopped.") }
    running = false
  }

  def apply(ret: Seq[GameMessage]) = ret.foreach {
    case pm: GameMessage.PlayerMessage if pm.idx == -1 => // noop
    case pm: GameMessage.PlayerMessage => players(pm.idx)(pm)
    case _: GameMessage.Notify => // noop
    case pa: GameMessage.PlayerAdded if pa.x == players(pa.player.idx).input.x && pa.y == players(pa.player.idx).input.y => // noop
    case pa: GameMessage.PlayerAdded =>
      //players(pa.player.idx).input.setPosition(pa.x.toDouble, pa.y.toDouble)
      throw new IllegalStateException(s"Received $pa, but player [${pa.player.idx}] is at [${players(pa.player.idx).input.getPosition}]")
    case x => log(s"Unable to apply game message [$x].")
  }

  def update(delta: Double, gu: GameCommand*): Seq[GameMessage] = {
    if (!running) { throw new IllegalStateException(s"Game instance [$gameId] has not been started.") }
    elapsedSeconds += delta
    gu.flatMap {
      case GameCommand.AddPlayer(player, spawn) => Seq(addPlayer(player = player, spawnPoint = spawn))
      case GameCommand.RemovePlayer(id) => Seq(removePlayer(id))
      case pi: GameCommand.PlayerInput => players(pi.idx).input.process(delta, pi)
      case x => throw new IllegalStateException(s"Unhandled update [$x].")
    }
  }

  def toDebug = GameInstanceDebug(gameId, options, players, map, elapsedSeconds)
}

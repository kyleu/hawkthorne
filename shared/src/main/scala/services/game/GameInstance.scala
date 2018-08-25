package services.game

import java.util.UUID

import models.data.map.TiledMap
import models.game.cmd.GameCommand
import models.game.msg.GameMessage
import models.options.{GameOptions, SystemOptions}
import services.game.GameInstanceDebug._

object GameInstance {
  import util.JsonSerializers._

  implicit val jsonEncoder: Encoder[GameInstance] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameInstance] = deriveDecoder
}

final case class GameInstance(
    gameId: UUID,
    options: GameOptions,
    var activeMaps: Map[TiledMap, GameMap] = Map.empty
) extends GameInstancePlayers {
  private[this] var running = false

  private[this] var elapsedSeconds = 0.0
  val bounds = (options.map.width * SystemOptions.tileSize) -> (options.map.height * SystemOptions.tileSize)

  def start(initialCommands: Seq[GameCommand]) = {
    debug(toString)
    if (running) { throw new IllegalStateException(s"Game [$gameId] already started.") }
    running = true
    apply(update(0, initialCommands: _*))
  }

  def stop() = {
    if (!running) { throw new IllegalStateException(s"Game [$gameId] already stopped.") }
    running = false
  }

  def addMap(m: GameMap) = activeMaps.get(m.map) match {
    case Some(x) => throw new IllegalStateException(s"Cannot add already-present map [${x.map}] to game [$gameId]")
    case None => activeMaps = activeMaps + (m.map -> m)
  }

  def getMap(m: TiledMap) = activeMaps.getOrElse(m, throw new IllegalStateException(s"Cannot find map [$m] in game [$gameId]"))

  def apply(ret: Seq[GameMessage]) = ret.foreach {
    case pm: GameMessage.PlayerMessage if pm.idx == -1 => // noop
    case pm: GameMessage.PlayerMessage => players(pm.idx)(pm)
    case _: GameMessage.Notify => // noop
    case pa: GameMessage.PlayerAdded if pa.x == players(pa.player.idx).input.x && pa.y == players(pa.player.idx).input.y => // noop
    case pa: GameMessage.PlayerAdded =>
      throw new IllegalStateException(s"Received $pa, but player [${pa.player.idx}] is at [${players(pa.player.idx).input.getPosition}]")
    case x => log(s"Unable to apply game message [$x].")
  }

  def update(delta: Double, gu: GameCommand*): Seq[GameMessage] = {
    if (!running) { throw new IllegalStateException(s"Game instance [$gameId] has not been started.") }
    elapsedSeconds += delta
    gu.flatMap {
      case GameCommand.AddPlayer(player, map, spawn) => Seq(addPlayer(player = player, map = getMap(map), spawnPoint = spawn))
      case GameCommand.RemovePlayer(id) => Seq(removePlayer(id))
      case pi: GameCommand.PlayerInput => players(pi.idx).input.process(delta, pi)
      case x => throw new IllegalStateException(s"Unhandled update [$x].")
    }
  }

  override def toString = GameInstanceDebug.debugString(gameId, options, players, activeMaps, elapsedSeconds)
}

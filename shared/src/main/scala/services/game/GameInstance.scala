package services.game

import java.util.UUID

import models.game.{GameCommand, GameMessage, GameStage}
import models.options.GameOptions
import services.game.GameInstanceDebug._
import util.Point

object GameInstance {
  import util.JsonSerializers._

  implicit val jsonEncoder: Encoder[GameInstance] = deriveEncoder
  implicit val jsonDecoder: Decoder[GameInstance] = deriveDecoder
}

final case class GameInstance(gameId: UUID, options: GameOptions, stage: GameStage, spawn: Point) extends GameInstancePlayers {
  private[this] var elapsedSeconds = 0.0
  val bounds = (options.map.width * 24) -> (options.map.height * 24)

  def start() = {
    log(toString)
  }

  private[this] def onPlayerInput(delta: Double, pi: GameCommand.PlayerInput): Seq[GameMessage] = {
    val record = players(pi.idx)
    record.input.process(delta, pi)
  }

  def apply(ret: Seq[GameMessage]) = ret.foreach {
    case pm: GameMessage.PlayerMessage if pm.idx == -1 => // noop
    case pm: GameMessage.PlayerMessage => players(pm.idx)(pm)
    case _: GameMessage.Notify => // noop
    case x => log(s"Unable to apply game message [$x].")
  }

  def update(delta: Double, gu: GameCommand*): Seq[GameMessage] = {
    elapsedSeconds += delta
    gu.flatMap {
      case GameCommand.AddPlayer(player) => Seq(addPlayer(player))
      case GameCommand.RemovePlayer(id) => Seq(removePlayer(id))
      case pi: GameCommand.PlayerInput => onPlayerInput(delta, pi)
      case x => throw new IllegalStateException(s"Unhandled update [$x].")
    }
  }

  override def toString = GameInstanceDebug.debugString(gameId, options, players, stage, elapsedSeconds)
}

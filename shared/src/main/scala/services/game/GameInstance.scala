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

  private[this] def onInput(delta: Double, pi: GameCommand.PlayerInput) = {
    val record = players(pi.idx)
    val (anim, loc) = record.input.process(delta, record.x, record.y, pi)
    val aMsg = anim.map(a => GameMessage.PlayerAnimationUpdated(pi.idx, a)).toSeq
    val lMsg = loc.map { case (newX, newY) => GameMessage.PlayerLocationUpdated(pi.idx, newX, newY) }.toSeq
    aMsg ++ lMsg
  }

  def apply(ret: Seq[GameMessage]) = ret.foreach {
    case pm: GameMessage.PlayerMessage if pm.idx == -1 => // noop
    case pm: GameMessage.PlayerMessage => players(pm.idx)(pm)
    case x => log(s"Unhandled game message [$x].")
  }

  def update(delta: Double, applyMessages: Boolean, gu: GameCommand*): Seq[GameMessage] = {
    elapsedSeconds += delta
    val ret = gu.flatMap {
      case GameCommand.AddPlayer(player) => Seq(addPlayer(player))
      case GameCommand.RemovePlayer(id) => Seq(removePlayer(id))
      case pi: GameCommand.PlayerInput => onInput(delta, pi)
      case x => throw new IllegalStateException(s"Unhandled update [$x].")
    }
    if (applyMessages) { apply(ret) }
    ret
  }

  override def toString = GameInstanceDebug.debugString(gameId, options, players, stage, elapsedSeconds)
}

package models

import java.util.UUID

import models.game.cmd.GameCommand
import models.options.GameOptions
import models.player.Player
import util.JsonSerializers._

sealed trait ResponseMessage

object ResponseMessage {
  implicit val jsonEncoder: Encoder[ResponseMessage] = deriveEncoder
  implicit val jsonDecoder: Decoder[ResponseMessage] = deriveDecoder

  // System
  final case class ServerError(reason: String, content: String) extends ResponseMessage
  final case class VersionResponse(version: String) extends ResponseMessage
  final case class Pong(ts: Long) extends ResponseMessage
  final case class Disconnected(reason: String) extends ResponseMessage
  final case class SystemBroadcast(channel: String, msg: String) extends ResponseMessage
  final case class UserSettings(userId: UUID, username: String, email: String) extends ResponseMessage

  // Game
  final case class GameNotFound(id: UUID) extends ResponseMessage
  final case class GameStarted(id: UUID, options: GameOptions, playerIdx: Int, players: IndexedSeq[Player]) extends ResponseMessage
  final case class GameUpdates(duration: Long, tick: Int, seq: Seq[GameCommand]) extends ResponseMessage
}

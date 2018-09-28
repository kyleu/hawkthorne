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
  final case class Pong(ts: Long, serverTime: Long) extends ResponseMessage
  final case class Disconnected(reason: String) extends ResponseMessage
  final case class SystemBroadcast(channel: String, msg: String) extends ResponseMessage
  final case class UserSettings(userId: UUID, username: String, email: String) extends ResponseMessage
  final case class SendClientTrace(t: String) extends ResponseMessage
  final case object SystemReady extends ResponseMessage

  // Game
  final case class GameNotFound(id: UUID) extends ResponseMessage
  final case class GameJoined(id: UUID, options: GameOptions, players: IndexedSeq[Player], playerIdx: Int) extends ResponseMessage
  final case class GameUpdates(duration: Long, tick: Int, seq: Seq[GameCommand]) extends ResponseMessage
}

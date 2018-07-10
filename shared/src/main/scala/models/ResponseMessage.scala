package models

import java.util.UUID

import models.game.{GameOptions, GameUpdate}
import util.JsonSerializers._

sealed trait ResponseMessage

object ResponseMessage {
  implicit val jsonEncoder: Encoder[ResponseMessage] = deriveEncoder
  implicit val jsonDecoder: Decoder[ResponseMessage] = deriveDecoder

  // System
  case class ServerError(reason: String, content: String) extends ResponseMessage
  case class VersionResponse(version: String) extends ResponseMessage
  case class Pong(ts: Long) extends ResponseMessage
  case class Disconnected(reason: String) extends ResponseMessage
  case class UserSettings(userId: UUID, username: String, email: String) extends ResponseMessage

  // Game
  case class GameNotFound(id: UUID) extends ResponseMessage
  case class GameStarted(id: UUID, options: GameOptions, playerIdx: Int, layout: String, stage: String, players: IndexedSeq[String]) extends ResponseMessage
  case class GameUpdates(duration: Long, tick: Int, seq: Seq[GameUpdate]) extends ResponseMessage
  case class GameFinished(id: UUID, stats: String, playerStats: Seq[String]) extends ResponseMessage
}


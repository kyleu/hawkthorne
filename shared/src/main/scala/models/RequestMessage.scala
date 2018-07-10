package models

import java.util.UUID

import models.game.GameUpdate
import util.JsonSerializers._

sealed trait RequestMessage

object RequestMessage {
  implicit val jsonEncoder: Encoder[RequestMessage] = deriveEncoder
  implicit val jsonDecoder: Decoder[RequestMessage] = deriveDecoder

  // System
  case class MalformedRequest(reason: String, content: String) extends RequestMessage
  case class GetVersion(v: String) extends RequestMessage
  case class Ping(ts: Long) extends RequestMessage
  case class DebugRequest(t: String, msg: String) extends RequestMessage

  // Game
  case class JoinGame(id: UUID) extends RequestMessage
  case class ObserveGame(id: UUID) extends RequestMessage
  case class PlayerUpdate(msgs: Seq[GameUpdate], ts: Long = System.currentTimeMillis) extends RequestMessage
}

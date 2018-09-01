package models

import java.util.UUID

import models.analytics.AnalyticsActionType
import models.game.cmd.GameCommand
import models.options.GameOptions
import util.JsonSerializers._

sealed trait RequestMessage

object RequestMessage {
  implicit val jsonEncoder: Encoder[RequestMessage] = deriveEncoder
  implicit val jsonDecoder: Decoder[RequestMessage] = deriveDecoder

  // System
  final case class MalformedRequest(reason: String, content: String) extends RequestMessage
  final case class ClientError(message: String, loc: String, ctx: Json) extends RequestMessage
  final case class GetVersion(v: String) extends RequestMessage
  final case class Ping(ts: Long) extends RequestMessage
  final case class DebugRequest(t: String, msg: String) extends RequestMessage

  // Game
  final case class StartGame(id: UUID, options: GameOptions) extends RequestMessage
  final case class JoinGame(id: UUID) extends RequestMessage
  final case class ObserveGame(id: UUID) extends RequestMessage
  final case class PlayerUpdate(msgs: Seq[GameCommand], ts: Long = System.currentTimeMillis) extends RequestMessage

  // Analytics
  final case class AnalyticsMessage(t: AnalyticsActionType, arg: Json) extends RequestMessage
}
